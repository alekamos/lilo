package it.costanza.LiLo.action;

import org.apache.log4j.Logger;

import it.costanza.LiLo.logic.UserLogic;
import it.costanza.LiLo.mybatis.bean.User;
import it.costanza.LiLo.util.Const;

import com.opensymphony.xwork2.ActionContext;
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
		log.debug("Utente in arrivo da JSP "+user.toString());

		User usrEstratto = ul.estraiUtenteByLoginAndPassword(user);
		log.debug(usrEstratto);
		if(usrEstratto!=null){
			log.debug("Estratto utente non null, credenziali valide");
			ul.mettiUtenteInSessione(usrEstratto);
			log.debug("Utente inserito in sessione sotto oggetto user");
			
			log.debug(Const.OUT);
			return SUCCESS;
		}else{
			log.debug("Estratto utente null, credenziali non valide");
			return INPUT;
		}


	}

	public String signUp(){
		log.debug(Const.IN);
		log.debug("Utente in arrivo da JSP "+user.toString());
		log.debug("Verifico che l'utente non sia già iscritto con stesso user e stessa mail");
		String errori = ul.verificaUtenteGiaPresente(user);
		log.debug("Errori segnalati dalle verifiche: ");
		if(errori!=null && errori.equals(""))
			ul.salvaUtente(user);
		else
			return INPUT;


		return SUCCESS;
	}









	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
