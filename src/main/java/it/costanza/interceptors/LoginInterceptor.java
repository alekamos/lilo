package it.costanza.interceptors;

import it.costanza.LiLo.logic.UserLogic;
import it.costanza.LiLo.mybatis.bean.User;
import it.costanza.LiLo.util.Const;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor  extends AbstractInterceptor {

	private static final long serialVersionUID = 3750925325469420241L;
	private static final Logger log = Logger.getLogger("lifelogLogger");

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {

		log.debug(Const.IN);

		UserLogic ul = new UserLogic();
		User userInSession = ul.getUserInSession();

		if (userInSession == null) 		
			return Action.LOGIN;

		else 
			return invocation.invoke();

	}
}