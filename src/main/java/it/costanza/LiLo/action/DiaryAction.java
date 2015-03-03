package it.costanza.LiLo.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Logger;

import it.costanza.LiLo.bean.ModuleExtended;
import it.costanza.LiLo.bean.ModuleFinder;
import it.costanza.LiLo.bean.NavigatorElement;
import it.costanza.LiLo.exception.UnauthorizedContent;
import it.costanza.LiLo.logic.ModuleLogic;
import it.costanza.LiLo.logic.UserLogic;
import it.costanza.LiLo.mybatis.bean.ModuleType;
import it.costanza.LiLo.mybatis.bean.User;
import it.costanza.LiLo.util.Const;
import it.costanza.LiLo.util.Utility;

import com.opensymphony.xwork2.ActionSupport;

public class DiaryAction extends ActionSupport{

	private static final long serialVersionUID = 110611053537418654L;
	private static final Logger log = Logger.getLogger("lifelogLogger");

	//Campo in arrivo dalla jsp
	private ModuleFinder moduleFinder = new ModuleFinder();

	//Campo in uscita dalla jsp
	private ModuleExtended moduleExtended;
	private ArrayList<ModuleExtended> moduleExtendedList;
	private ArrayList<ModuleType> userModuleType;
	private ArrayList<NavigatorElement> navigatorElementList;


	public String viewDayHost(){
		log.debug(Const.IN);
		//occorre capire se ï¿½ arrivato un id o una data da cercare
		if(moduleExtended.getModuleCluster().getIdModuleCluster()!=0){
			//Qui occorre la logica per vedere se la giornata ï¿½ la sua e prendere tutti i moduli	
		}

		return SUCCESS;
	}

//TODO gestire meglio gli struts result
	public String viewModule() throws UnauthorizedContent{
		log.debug(Const.IN);
		UserLogic ul = new UserLogic();
		ModuleLogic ml = new ModuleLogic();
		User user = ul.getUserInSession();
		String strutsResult = "";
		log.debug("User estratto dalla sessione: "+user.toString());
		log.debug("Module finder in arrivo: "+moduleFinder.toString());


		if(moduleFinder.getIdModule()!=null && moduleFinder.getIdModule()!=0){
			//caso in cui arriva direttamente un idModulo
			ml.checkModuleOwnership(user,moduleFinder.getIdModule());
			moduleExtended = ml.getModuleExtended(moduleFinder.getIdModule(), user);
			strutsResult =  Const.SINGULAR_MODULE_VIEW;
		}else if (moduleFinder.getDateDayHost()!=null) {
			//caso in cui arriva una data TODO provare se metto una data ed un idModulo cosa succede se entra
			//da entrambe le parti
			Integer idCluster = ml.getIdClusterFromDate(moduleFinder.getDateDayHost(), user);
			moduleExtendedList = ml.getModuleExtendList(idCluster, user);
			strutsResult = Const.MULTIPLE_MODULE_VIEW;
		}
		else if (moduleFinder.getIdModuleCluster()!=null) {
			//caso in cui arriva direttamente un idCluster
			moduleExtendedList = ml.getModuleExtendList(moduleFinder.getIdModuleCluster(), user);
			strutsResult = Const.MULTIPLE_MODULE_VIEW;
		}
		else if(moduleFinder.getCriteria()!=null){
			//caso in cui è specificato un criterio
			switch (moduleFinder.getCriteria()) {
			case Const.RANDOM://caso in cui si cerca un giorno random dell'utente
				Integer idCluster = ml.getRandomIdCluster(user);
				moduleExtendedList = ml.getModuleExtendList(idCluster, user);
				strutsResult = Const.MULTIPLE_MODULE_VIEW;
				break;
			}
		}
		else if(moduleFinder.getCriteria()!=null){
			//caso in cui è specificato un criterio
			switch (moduleFinder.getCriteria()) {
			case Const.RANDOM://caso in cui si cerca un giorno random dell'utente
				Integer idCluster = ml.getRandomIdCluster(user);
				moduleExtendedList = ml.getModuleExtendList(idCluster, user);
				strutsResult = Const.MULTIPLE_MODULE_VIEW;
				break;
			}
		}


		//Costruzione navigator
		Date dateStart = Utility.aggiungiTogliGiorno(new Date(),-14);
		if(moduleExtendedList!=null && moduleExtendedList.size()>0)
			dateStart = Utility.aggiungiTogliGiorno(moduleExtendedList.get(0).getModuleDayHost().getDateDayHost(),-7);
		Date dateEnd = Utility.aggiungiTogliGiorno(dateStart,+14);

		navigatorElementList = ml.buildNavigator(user, dateStart, dateEnd);

		return strutsResult;
	}

	public String gotoSearchModule(){
		log.debug(Const.IN);
		ModuleLogic ml = new ModuleLogic();
		UserLogic ul = new UserLogic();
		User user = ul.getUserInSession();
		log.debug("User estratto dalla sessione: "+user.toString());
		userModuleType = ml.getUserModuleType(user);

		//Costruzione navigator
		navigatorElementList = ml.buildNavigator(user,Utility.aggiungiTogliGiorno(new Date(), -14),new Date());

		return SUCCESS;
	}


	public String gotoWriteModule(){
		log.debug(Const.IN);
		ModuleLogic ml = new ModuleLogic();
		UserLogic ul = new UserLogic();
		User user = ul.getUserInSession();
		log.debug("User estratto dalla sessione: "+user.toString());
		userModuleType = ml.getUserModuleType(user);

		return SUCCESS;
	}

	public String getNavigatorAjax(){
		log.debug(Const.IN);
		try {
			Date startDate = null;
			Date endDate = null;
			ModuleLogic ml = new ModuleLogic();
			UserLogic ul = new UserLogic();
			User user = ul.getUserInSession();
			log.debug("User estratto dalla sessione: "+user.toString());

			//Costruzione navigator
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");


			if(moduleFinder.getStartDate() == null)
				startDate = Utility.aggiungiTogliGiorno(sdf.parse(moduleFinder.getEndDate()), -14);
			else
				startDate = sdf.parse(moduleFinder.getStartDate());

			if(moduleFinder.getEndDate() == null)
				endDate = Utility.aggiungiTogliGiorno(sdf.parse(moduleFinder.getStartDate()), +14);
			else
				endDate = sdf.parse(moduleFinder.getEndDate());

			navigatorElementList = ml.buildNavigator(user, startDate, endDate);

		} catch (Exception e) {
			log.error(e.getMessage());
			return ERROR;
		}

		return SUCCESS;
	}



	public ModuleExtended getModuleExtended() {
		return moduleExtended;
	}
	public void setModuleExtended(ModuleExtended moduleExtended) {
		this.moduleExtended = moduleExtended;
	}
	public ModuleFinder getModuleFinder() {
		return moduleFinder;
	}
	public void setModuleFinder(ModuleFinder moduleFinder) {
		this.moduleFinder = moduleFinder;
	}
	public ArrayList<ModuleType> getUserModuleType() {
		return userModuleType;
	}
	public void setUserModuleType(ArrayList<ModuleType> userModuleType) {
		this.userModuleType = userModuleType;
	}
	public ArrayList<ModuleExtended> getModuleExtendedList() {
		return moduleExtendedList;
	}
	public void setModuleExtendedList(ArrayList<ModuleExtended> moduleExtendedList) {
		this.moduleExtendedList = moduleExtendedList;
	}
	public ArrayList<NavigatorElement> getNavigatorElementList() {
		return navigatorElementList;
	}
	public void setNavigatorElementList(ArrayList<NavigatorElement> navigatorElementList) {
		this.navigatorElementList = navigatorElementList;
	}

}
