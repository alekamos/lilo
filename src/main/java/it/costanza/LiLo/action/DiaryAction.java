package it.costanza.LiLo.action;

import org.apache.log4j.Logger;

import it.costanza.LiLo.bean.ModuleDayHost;
import it.costanza.LiLo.bean.ModuleExtended;
import it.costanza.LiLo.bean.ModuleFinder;
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
	private ModuleFinder moduleFinder = new ModuleFinder();

	//Campo in uscita dalla jsp
	private ModuleExtended moduleExtended = new ModuleExtended();

	//Classe logica 
	private ModuleLogic ml = new ModuleLogic();
	private UserLogic ul = new UserLogic();

	public String viewDayHost(){
		log.debug(Const.IN);
		//occorre capire se � arrivato un id o una data da cercare
		if(moduleExtended.getModuleCluster().getIdModuleCluster()!=0){
			//Qui occorre la logica per vedere se la giornata � la sua e prendere tutti i moduli	
		}

		return SUCCESS;
	}



	public String viewModule(){
		log.debug(Const.IN);

		
			User user = ul.getUserInSession();
			log.debug("User estratto dalla sessione: "+user.toString());

			boolean allowView =  ml.checkModuleOwnership(user,moduleFinder.getIdModule());
			if(allowView){
				moduleExtended = ml.getModule(moduleFinder.getIdModule());
				Integer idModuleDayHost = ml.getIdModuleDayHostFromIdCluster(moduleExtended.getModuleCluster().getIdModuleCluster());
				ModuleDayHost dayHost = ml.getDayHost(idModuleDayHost);
				moduleExtended.setModuleDayHost(dayHost);
				return SUCCESS;
			}else
				return "forbidden";

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
