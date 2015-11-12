package it.costanza.LiLo.action;

import java.io.IOException;

import it.costanza.LiLo.bean.DashBoardBean;
import it.costanza.LiLo.bean.GraphBean;
import it.costanza.LiLo.logic.ModuleLogic;
import it.costanza.LiLo.logic.StatLogic;
import it.costanza.LiLo.logic.UserLogic;
import it.costanza.LiLo.mybatis.bean.User;
import it.costanza.LiLo.util.Const;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

public class StatAction extends ActionSupport{


	private static final long serialVersionUID = 4275395776711759333L;
	private static final Logger log = Logger.getLogger("lifelogLogger");
	
	private DashBoardBean dashBoardBean;
	
	
	public String gotoDashboard() throws IOException{
		log.debug(Const.IN);
		UserLogic ul = new UserLogic();
		User user = ul.getUserInSession();
		log.debug("User estratto dalla sessione: "+user.toString());

		StatLogic st = new StatLogic();
		dashBoardBean = st.getDatiDashBoard(user);
		
		//dati histo
		GraphBean graph = st.buildDatasetTotalWordFromNavigator(dashBoardBean, "Date", "Size Content");
		dashBoardBean.setGraphBean(graph);
		
		
		return SUCCESS;
	}


	public DashBoardBean getDashBoardBean() {
		return dashBoardBean;
	}


	public void setDashBoardBean(DashBoardBean dashBoardBean) {
		this.dashBoardBean = dashBoardBean;
	}



	
}
