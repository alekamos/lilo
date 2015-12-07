package it.costanza.LiLo.action;

import it.costanza.LiLo.bean.ModuleExtended;
import it.costanza.LiLo.bean.ModuleFinder;
import it.costanza.LiLo.exception.UnauthorizedContent;
import it.costanza.LiLo.logic.ModuleLogic;
import it.costanza.LiLo.logic.UserLogic;
import it.costanza.LiLo.mybatis.bean.ModuleType;
import it.costanza.LiLo.mybatis.bean.User;
import it.costanza.LiLo.util.Const;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

public class ModuleAction extends ActionSupport{

	private static final long serialVersionUID = 3258340637887790849L;
	private static final Logger log = Logger.getLogger("lifelogLogger");

	//Campo in arrivo dalla jsp


	//Campo in arrivo dalla jsp
	private ArrayList<ModuleType> moduleTypeList;
	private ModuleType moduleType;
	private ModuleExtended moduleExtended;
	private ModuleFinder moduleFinder;

	
	public String gotoModuleTypeManagement(){
		log.debug(Const.IN);
		ModuleLogic ml = new ModuleLogic();
		UserLogic ul = new UserLogic();
		User user = ul.getUserInSession();
		log.debug("User estratto dalla sessione: "+user.toString());
		moduleTypeList = ml.getUserModuleType(user);

		//Aggiungo i moduli di default
		moduleTypeList = ml.getDefaultModuleType(moduleTypeList);

		return SUCCESS;
	}


	public String createNewModuleType(){
		log.debug(Const.IN);
		ModuleLogic ml = new ModuleLogic();
		UserLogic ul = new UserLogic();
		User user = ul.getUserInSession();
		log.debug("User estratto dalla sessione: "+user.toString());
		moduleType.setIdUser(user.getIdUser());
		moduleType = ml.cleanModuleType(moduleType);
		ml.insertModuleType(moduleType);

		return SUCCESS;
	}


	public String saveModule(){
		log.debug(Const.IN);
		ModuleLogic ml = new ModuleLogic();
		UserLogic ul = new UserLogic();
		User user = ul.getUserInSession();
		log.debug("User estratto dalla sessione: "+user.toString());
		moduleExtended.getModuleHeader().setIdUser(user.getIdUser());
		log.debug("Modulo in arrivo da jsP: "+moduleExtended.toString());
		Integer idCluster = ml.insertModuleExtended(moduleExtended);
		moduleFinder = new ModuleFinder();
		moduleFinder.setIdModuleCluster(idCluster);
		return SUCCESS;
	}
	
	public String updateModule() throws UnauthorizedContent{
		log.debug(Const.IN);
		ModuleLogic ml = new ModuleLogic();
		UserLogic ul = new UserLogic();
		moduleFinder = new ModuleFinder();
		User user = ul.getUserInSession();
		log.debug("User estratto dalla sessione: "+user.toString());
		ml.checkModuleTypeOwnership(user,moduleExtended.getModuleType().getIdModuleType());
		ml.checkModuleOwnership(user,moduleExtended.getModuleHeader().getIdModule());
		Integer idModuleCluster = ml.updateModuleExtend(user,moduleExtended);
		
		moduleFinder.setIdModuleCluster(idModuleCluster);
		
		return SUCCESS;
	}
	
	public String gotoUpdateModule() throws UnauthorizedContent{
		log.debug(Const.IN);
		ModuleLogic ml = new ModuleLogic();
		UserLogic ul = new UserLogic();
		User user = ul.getUserInSession();
		log.debug("User estratto dalla sessione: "+user.toString());
		ml.checkModuleTypeOwnership(user,moduleType.getIdModuleType());
		moduleType = ml.getModuleType(moduleType);
		log.debug("ModuleType caricato: "+moduleType.toString());
		ml.checkModuleOwnership(user,moduleFinder.getIdModule());
		moduleExtended = ml.getModuleExtended(moduleFinder.getIdModule(), user);
		
		return SUCCESS;
	}

	public String gotoUseModule() throws UnauthorizedContent{
		log.debug(Const.IN);
		ModuleLogic ml = new ModuleLogic();
		UserLogic ul = new UserLogic();
		User user = ul.getUserInSession();
		log.debug("User estratto dalla sessione: "+user.toString());
		ml.checkModuleTypeOwnership(user,moduleType.getIdModuleType());
		moduleType = ml.getModuleType(moduleType);
		log.debug("ModuleType caricato: "+moduleType.toString());
		return SUCCESS;
	}
	
	public String gotoUseModuleAjax() throws UnauthorizedContent{
		log.debug(Const.IN);
		ModuleLogic ml = new ModuleLogic();
		UserLogic ul = new UserLogic();
		User user = ul.getUserInSession();
		log.debug("User estratto dalla sessione: "+user.toString());
		ml.checkModuleTypeOwnership(user,moduleType.getIdModuleType());
		moduleType = ml.getModuleType(moduleType);
		log.debug("ModuleType caricato: "+moduleType.toString());
		return SUCCESS;
	}
	


	public ArrayList<ModuleType> getModuleTypeList() {
		return moduleTypeList;
	}


	public void setModuleTypeList(ArrayList<ModuleType> moduleTypeList) {
		this.moduleTypeList = moduleTypeList;
	}


	public ModuleType getModuleType() {
		return moduleType;
	}

	public void setModuleType(ModuleType moduleType) {
		this.moduleType = moduleType;
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


}
