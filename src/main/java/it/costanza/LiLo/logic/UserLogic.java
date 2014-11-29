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
	public User estraiUtenteByLoginAndPassword(User user){
		log.debug(Const.IN);

		user.setPassword(Encryption.toMD5(user.getPassword()));

		return dao.searchByUsernameAndPassword(user);

	}


	public void salvaUtente(User user){
		log.debug(Const.IN);

		user.setPassword(Encryption.toMD5(user.getPassword()));
		int righeInserite = dao.insert(user);
		log.debug("Inserita "+righeInserite +" riga. ");

	}


	public void mettiUtenteInSessione(User user){
		ActionContext.getContext().getSession().put("user", user);
	}


	public String verificaUtenteGiaPresente(User user) {
		log.debug(Const.IN);
		String out = "";

		User utenteEstratto = dao.searchByUsername(user);
		if(utenteEstratto!=null)
			out = "usrename.presente";
		else{
			utenteEstratto = dao.searchByEmail(user);
			if(utenteEstratto!=null)
				out = "email.presente";
		}
		
		return out;
	}



}
