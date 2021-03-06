package it.costanza.LiLo.action;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import it.costanza.LiLo.bean.ModuleExtended;
import it.costanza.LiLo.logic.ModuleLogic;
import it.costanza.LiLo.logic.UserLogic;
import it.costanza.LiLo.mybatis.bean.ModuleType;
import it.costanza.LiLo.mybatis.bean.User;
import it.costanza.LiLo.util.Const;

import com.opensymphony.xwork2.ActionSupport;

public class ModuleAction extends ActionSupport{

	private static final long serialVersionUID = 3258340637887790849L;
	private static final Logger log = Logger.getLogger("lifelogLogger");

	//Campo in arrivo dalla jsp


	//Campo in arrivo dalla jsp
	private ArrayList<ModuleType> moduleTypeList;
	private ModuleType moduleType;
	private ModuleExtended moduleExtended;

	
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
		ml.insertModuleExtended(moduleExtended);

		return SUCCESS;
	}

	public String gotoUseModule(){
		log.debug(Const.IN);
		ModuleLogic ml = new ModuleLogic();
		UserLogic ul = new UserLogic();
		User user = ul.getUserInSession();
		log.debug("User estratto dalla sessione: "+user.toString());
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


}
