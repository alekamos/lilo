package it.costanza.LiLo.logic;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;

import it.costanza.LiLo.dao.UserDao;
import it.costanza.LiLo.mybatis.bean.User;
import it.costanza.LiLo.util.Const;
import it.costanza.LiLo.util.Encryption;


public class UserLogic {

	private static final Logger log = Logger.getLogger("lifelogLogger");
	UserDao dao = new UserDao();

	/**
	 * Oltre a richiamare il dao effettua un hash della password in modo da confrontarla con quella presente nel DB.
	 * @param user
	 * @return
	 */
	public User getUserByUsrPwd(User user){
		log.debug(Const.IN);

		user.setPassword(Encryption.toMD5(user.getPassword()));

		return dao.searchByUsernameAndPassword(user);

	}


	/**
	 * Salva l'untete sul DB
	 * @param user
	 */
	public void insertUser(User user){
		log.debug(Const.IN);

		user.setPassword(Encryption.toMD5(user.getPassword()));
		int righeInserite = dao.insert(user);
		log.debug("Inserita "+righeInserite +" riga. ");

	}

	/**
	 * Mette l'untete in sessione
	 * @param user
	 */
	public void putUserInSession(User user){
		log.debug(Const.IN);
		log.debug("Oggetto arrivato al metodo: "+user.toString());
		ActionContext.getContext().getSession().put("user", user);
	}

	/**
	 * Prende l'utente dalla sessione
	 * @return
	 */
	public User getUserInSession(){
		User user = (User) ActionContext.getContext().getSession().get("user");
		return user;
	}



	/**
	 * Verifica dapprima se esiste l'username nella base dati, successivamente passa al controllo sulla mail.
	 * Può rispondere con
	 * USERNAME_NOT_FOUND non trova l'username
	 * USERNAME_FOUND trova l'username
	 * EMAIL_FOUND trova la mail
	 * EMAIL_NOT_FOUND non trova la mail
	 * @param user
	 * @return
	 */
	public String checkUserExist(User user) {
		log.debug(Const.IN);
		String out = Const.USERNAME_NOT_FOUND;

		User utenteEstratto = dao.searchByUsername(user);
		if(utenteEstratto!=null)
			out = Const.USERNAME_FOUND;
		else if (user.getEmail()!=null) {
			utenteEstratto = dao.searchByEmail(user);
			if(utenteEstratto!=null)
				out = Const.EMAIL_FOUND;
			else 
				out = Const.EMAIL_NOT_FOUND;
		}

		return out;
	}

	/**
	 * Rimuove l'utente dalla sessione, logout
	 */
	public void deleteUserInSession() {
		ActionContext.getContext().getSession().remove("user");

	}



}
