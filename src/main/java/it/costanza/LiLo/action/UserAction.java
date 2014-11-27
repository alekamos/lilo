package it.costanza.LiLo.action;

import org.apache.log4j.Logger;

import it.costanza.LiLo.mybatis.bean.User;
import it.costanza.LiLo.util.Const;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{


	private static final long serialVersionUID = -1643965805061972703L;
	private static final Logger log = Logger.getLogger("lifelogLogger");

	//Campo in arrivo dalla jsp
	private User user;




	public String signIn(){
		log.debug(Const.IN);
		log.debug(user.toString());
		log.debug(Const.OUT);

		return SUCCESS;
	}
	
	public String signUp(){
		log.debug(Const.IN);
		log.debug(user.toString());
		log.debug(Const.OUT);

		return SUCCESS;
	}









	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
