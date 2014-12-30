package it.costanza.LiLo.action;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import it.costanza.LiLo.bean.ModuleDayHost;
import it.costanza.LiLo.bean.ModuleExtended;
import it.costanza.LiLo.bean.ModuleFinder;
import it.costanza.LiLo.exception.UnauthorizedContent;
import it.costanza.LiLo.logic.ModuleLogic;
import it.costanza.LiLo.logic.UserLogic;
import it.costanza.LiLo.mybatis.bean.ModuleCluster;
import it.costanza.LiLo.mybatis.bean.ModuleType;
import it.costanza.LiLo.mybatis.bean.User;
import it.costanza.LiLo.util.Const;

import com.opensymphony.xwork2.ActionSupport;

public class DiaryAction extends ActionSupport{

	private static final long serialVersionUID = 110611053537418654L;
	private static final Logger log = Logger.getLogger("lifelogLogger");

	//Campo in arrivo dalla jsp
	private ModuleFinder moduleFinder = new ModuleFinder();

	//Campo in uscita dalla jsp
	private ModuleExtended moduleExtended = new ModuleExtended();
	private ArrayList<ModuleExtended> moduleExtendedList = new ArrayList<ModuleExtended>();
	private ArrayList<ModuleType> userModuleType;

	//Classe logica 
	private ModuleLogic ml = new ModuleLogic();
	private UserLogic ul = new UserLogic();



	public String viewDayHost(){
		log.debug(Const.IN);
		//occorre capire se è arrivato un id o una data da cercare
		if(moduleExtended.getModuleCluster().getIdModuleCluster()!=0){
			//Qui occorre la logica per vedere se la giornata è la sua e prendere tutti i moduli	
		}

		return SUCCESS;
	}





	public String viewModule() throws UnauthorizedContent{
		log.debug(Const.IN);

		User user = ul.getUserInSession();
		log.debug("User estratto dalla sessione: "+user.toString());
		log.debug("Module finder in arrivo: "+moduleFinder.toString());


		if(moduleFinder.getIdModule()!=null && moduleFinder.getIdModule()!=0){
			//caso in cui arriva direttamente un idModulo
			ml.checkModuleOwnership(user,moduleFinder.getIdModule());
			moduleExtended = ml.getModuleExtended(moduleFinder.getIdModule(), user);
		}else if (moduleFinder.getDateDayHost()!=null) {
			//caso in cui arriva una data TODO provare se metto una data ed un idModulo cosa succede se entra
			//da entrambe le parti
			Integer idCluster = ml.getIdClusterFromDate(moduleFinder.getDateDayHost(), user);
			moduleExtendedList = ml.getModuleExtendList(idCluster, user);

		}

		return SUCCESS;


	}

	public String gotoSearchModule(){
		log.debug(Const.IN);

		User user = ul.getUserInSession();
		log.debug("User estratto dalla sessione: "+user.toString());
		userModuleType = ml.getUserModuleType(user);

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

}
