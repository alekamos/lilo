package it.costanza.LiLo.action;

import it.costanza.LiLo.logic.UserLogic;
import it.costanza.LiLo.mybatis.bean.User;
import it.costanza.LiLo.util.Const;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

public class StatAction extends ActionSupport{


	private static final long serialVersionUID = 4275395776711759333L;
	private static final Logger log = Logger.getLogger("lifelogLogger");
	
	public String gotoDashboard(){
		log.debug(Const.IN);
		UserLogic ul = new UserLogic();
		User user = ul.getUserInSession();
		log.debug("User estratto dalla sessione: "+user.toString());


		return SUCCESS;
	}
	
}
