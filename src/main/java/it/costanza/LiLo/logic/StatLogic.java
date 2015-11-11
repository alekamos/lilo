package it.costanza.LiLo.logic;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import it.costanza.LiLo.bean.DashBoardBean;
import it.costanza.LiLo.bean.ModuleExtended;
import it.costanza.LiLo.bean.NavigatorElement;
import it.costanza.LiLo.mybatis.bean.User;
import it.costanza.LiLo.util.Utility;

import org.apache.log4j.Logger;

public class StatLogic {

	final String OG = "{";
	final String CG = "}";
	final String V = ",";
	final String AP = "\"";
	final String DP = ":";
	final String SP = " ";


	private static final Logger log = Logger.getLogger("lifelogLogger");

	public DashBoardBean getDatiDashBoard(User user) throws IOException {

		DashBoardBean dbBean = new DashBoardBean();
		ModuleLogic ml = new ModuleLogic();

		ArrayList<NavigatorElement> navigatorObject = ml.buildNavigator(user, Utility.aggiungiTogliGiorno(new Date(), -365), new Date());
		navigatorObject = getTextSizeOfModuleExtended(navigatorObject,user);
		dbBean.setNav(navigatorObject);

		return dbBean;
	}


	/**
	 * Estrae tutti i moduli ModuleText contenuti nell'array del navigator estraendo per tutti gli elementi (dayHost) tutti i moduli del dayHost;
	 * ed estrae proprio tutti i moduletext. Conta le stringhe e setta il campo size con la dimensione delle stringhe (numero di lettere).
	 * @param navigatorObject
	 * @param user
	 * @return
	 */
	private ArrayList<NavigatorElement> getTextSizeOfModuleExtended(ArrayList<NavigatorElement> navigatorObject, User user) {
		for (NavigatorElement navigatorElement : navigatorObject) {

			ModuleLogic ml = new ModuleLogic();

			if(navigatorElement.getIdModuleCluster()!=null && navigatorElement.getIdModuleCluster()!=0){
				ArrayList<ModuleExtended> ModulesOfDay = ml.getModuleExtendList(navigatorElement.getIdModuleCluster(), user);

				long provvSize = 0;

				for (ModuleExtended module : ModulesOfDay) {

					if(module.getModuleText()!= null && module.getModuleText().getText1Value()!= null)
						provvSize = provvSize+module.getModuleText().getText1Value().length();

					if(module.getModuleText()!= null && module.getModuleText().getText2Value()!= null)
						provvSize = provvSize+module.getModuleText().getText2Value().length();

					if(module.getModuleText()!= null && module.getModuleText().getText3Value()!= null)
						provvSize = provvSize+module.getModuleText().getText3Value().length();

				}
				navigatorElement.setSize(provvSize);
			}
			else
				navigatorElement.setSize((long) 0);
		}

		return navigatorObject;
	}


	/**
	 * Crea il datasset per l'istogramma di amchart con data in formato dd-MM-yy
	 * @param nav
	 * @param xlabel senza apici
	 * @param ylabel senza apici
	 * @return
	 */
	public String buildDatasetTotalWordFromNavigator(
			ArrayList<NavigatorElement> nav,String xlabel,String ylabel) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String out = "";
		String xdata = "";
		String ydata = "";

		for (NavigatorElement navigatorElement : nav) {

			//Creazione Stringa
			if(!out.equals(""))
				out+=V;

			xdata =sdf.format(navigatorElement.getDateDay());
			ydata = navigatorElement.getSize()+"";


			out += OG+AP+xlabel+AP+DP+AP+xdata+AP+V+AP+ylabel+AP+DP+ydata+CG;
		}

		return out;
	}


}
