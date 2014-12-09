package it.costanza.LiLo.action;

import java.util.ArrayList;

import org.apache.log4j.Logger;

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
	private ArrayList<ModuleType> moduleTypeList = new ArrayList<ModuleType>();
	private ModuleType moduleType = new ModuleType();


	//Classe logica 
	private ModuleLogic ml = new ModuleLogic();
	private UserLogic ul = new UserLogic();


	
	
	
	
	
	public String gotoModuleTypeManagement(){
		log.debug(Const.IN);
		User user = ul.getUserInSession();
		log.debug("User estratto dalla sessione: "+user.toString());
		moduleTypeList = ml.getListaModuliTypeUtente(user);
		
		//Aggiungo i moduli di default
		moduleTypeList = ml.getModuliDefault(moduleTypeList);

		return SUCCESS;
	}
	
	
	public String createModuleType(){
		log.debug(Const.IN);
		User user = ul.getUserInSession();
		log.debug("User estratto dalla sessione: "+user.toString());
		moduleType.setIdUser(user.getIdUser());
		moduleType = ml.normalizzaCampi(moduleType);
		
		
		ml.salvaModuloType(moduleType);

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


}
