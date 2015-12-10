package it.costanza.LiLo.action;

import org.apache.log4j.Logger;

import it.costanza.LiLo.logic.UserLogic;
import it.costanza.LiLo.mybatis.bean.User;
import it.costanza.LiLo.util.Const;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{


	private static final long serialVersionUID = -1643965805061972703L;
	private static final Logger log = Logger.getLogger("lifelogLogger");

	//Campo in arrivo dalla jsp
	private User user;


	//Classe logica 
	private UserLogic ul = new UserLogic();


	public String signIn(){
		log.debug(Const.IN);
		long tStart = System.currentTimeMillis();
		log.debug("Utente in arrivo da JSP "+user.toString());

		User usrEstratto = ul.getUserByUsrPwd(user);
		log.debug(usrEstratto);
		if(usrEstratto!=null){
			log.debug("Estratto utente non null, credenziali valide");
			ul.putUserInSession(usrEstratto);
			log.debug("Utente inserito in sessione sotto oggetto user");
			long tEnd = System.currentTimeMillis();
			log.debug("Elapsed : "+(tEnd-tStart)+"ms");
			log.debug(Const.OUT);
			return SUCCESS;

		}else{
			log.debug("Estratto utente null, credenziali non valide");
			String error = ul.checkUserExist(user);
			if(error.equals(Const.USERNAME_NOT_FOUND))
				addFieldError("user.username", "Username not exist");
			else if (error.equals(Const.USERNAME_FOUND)) //Se non � riuscito a loggarsi ma l'username esiste � per logica password errata
				addFieldError("user.password", "Incorrect password");

			long tEnd = System.currentTimeMillis();
			log.debug("Elapsed : "+(tEnd-tStart)+"ms");
			log.debug(Const.OUT);
			return INPUT;
		}


	}

	public String signUp(){
		log.debug(Const.IN);
		long tStart = System.currentTimeMillis();
		log.debug("Utente in arrivo da JSP "+user.toString());
		log.debug("Verifico che l'utente non sia già iscritto con stesso user e stessa mail");
		String errori = ul.checkUserExist(user);
		log.debug("Errori segnalati dalle verifiche: ");
		if(!errori.equals(Const.USERNAME_FOUND) && !errori.equals(Const.EMAIL_FOUND) )
			ul.insertUser(user);
		else{
			if(errori.equals(Const.USERNAME_FOUND))
				addFieldError("user.username", "Username used yet");
			if(errori.equals(Const.EMAIL_FOUND))
				addFieldError("user.email", "Email registered yet");
			
			long tEnd = System.currentTimeMillis();
			log.debug("Elapsed : "+(tEnd-tStart)+"ms");
			log.debug(Const.OUT);
			return INPUT;
		}

		long tEnd = System.currentTimeMillis();
		log.debug("Elapsed : "+(tEnd-tStart)+"ms");
		log.debug(Const.OUT);
		return SUCCESS;
	}

	public String logout(){
		log.debug(Const.IN);

		ul.deleteUserInSession();



		return SUCCESS;
	}









	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
