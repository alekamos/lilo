package it.costanza.LiLo.action;


import it.costanza.LiLo.util.Const;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

public class StartupAction extends ActionSupport{


	
	private static final long serialVersionUID = 4429493407119223118L;
	private static final Logger log = Logger.getLogger("lifelogLogger");

	public String startupMethod(){
		log.debug(Const.IN);
		log.debug(Const.OUT);
		return SUCCESS;
	}
}
