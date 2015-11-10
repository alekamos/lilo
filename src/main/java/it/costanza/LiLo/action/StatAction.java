package it.costanza.LiLo.action;

import java.io.IOException;

import it.costanza.LiLo.bean.DashBoardBean;
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
	
	private DashBoardBean dbBean;
	private String xlabel;
	private String ylabel;
	private String dataset;
	
	public String gotoDashboard() throws IOException{
		log.debug(Const.IN);
		UserLogic ul = new UserLogic();
		User user = ul.getUserInSession();
		log.debug("User estratto dalla sessione: "+user.toString());

		StatLogic st = new StatLogic();
		dbBean = st.getDatiDashBoard(user);
		
		
		//dati histo
		xlabel = "Date";
		ylabel = "Content";
		dataset = st.buildDatasetTotalWordFromNavigator(dbBean.getNav(), xlabel, ylabel);
		
		xlabel = "\"Date\"";
		ylabel = "\"Content\"";
		
		return SUCCESS;
	}

	public DashBoardBean getDbBean() {
		return dbBean;
	}

	public void setDbBean(DashBoardBean dbBean) {
		this.dbBean = dbBean;
	}

	public String getXlabel() {
		return xlabel;
	}

	public void setXlabel(String xlabel) {
		this.xlabel = xlabel;
	}

	public String getYlabel() {
		return ylabel;
	}

	public void setYlabel(String ylabel) {
		this.ylabel = ylabel;
	}

	public String getDataset() {
		return dataset;
	}

	public void setDataset(String dataset) {
		this.dataset = dataset;
	}
	
}
