package it.costanza.LiLo.action;

import org.apache.log4j.Logger;

import it.costanza.LiLo.bean.ModuleExtended;
import it.costanza.LiLo.logic.ModuleLogic;
import it.costanza.LiLo.logic.UserLogic;
import it.costanza.LiLo.mybatis.bean.ModuleHeader;
import it.costanza.LiLo.mybatis.bean.User;
import it.costanza.LiLo.util.Const;

import com.opensymphony.xwork2.ActionSupport;

public class DiaryAction extends ActionSupport{

	private static final long serialVersionUID = 110611053537418654L;
	private static final Logger log = Logger.getLogger("lifelogLogger");

	//Campo in arrivo dalla jsp
	private ModuleHeader moduleHeader = new ModuleHeader();

	//Campo in uscita dalla jsp
	private ModuleExtended moduleExtended = new ModuleExtended();

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



	public String viewModule(){
		log.debug(Const.IN);

		if(moduleExtended.getModuleHeader()!=null && moduleExtended.getModuleHeader().getIdModule()!=0){
			User user = ul.getUserInSession();
			log.debug("User estratto dalla sessione: "+user.toString());

			boolean allowView =  ml.checkModuleOwnership(user,moduleHeader);
			if(allowView){
				moduleExtended = ml.getModule(moduleHeader);
				return SUCCESS;
			}else
				return "forbidden";
		}else
			return ERROR;
	}





	
	
	
	public ModuleExtended getModuleExtended() {
		return moduleExtended;
	}
	public void setModuleExtended(ModuleExtended moduleExtended) {
		this.moduleExtended = moduleExtended;
	}
	public ModuleHeader getModuleHeader() {
		return moduleHeader;
	}
	public void setModuleHeader(ModuleHeader moduleHeader) {
		this.moduleHeader = moduleHeader;
	}

}
