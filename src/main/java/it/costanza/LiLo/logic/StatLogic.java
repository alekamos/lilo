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
		for (NavigatorElement navigatorElement : navigatorObject) {

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

		dbBean.setNav(navigatorObject);



		return dbBean;
	}

	public String buildDatasetTotalWordFromNavigator(
			ArrayList<NavigatorElement> nav,String xlabel,String ylabel) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
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
