package it.costanza.LiLo.bean;

import java.util.Date;

public class NavigatorElement {

	private Date dateDay;
	private long idModuleCluster;
	private long idModuleType;
	private long idModule;
	private long idUser;
	
	//Costruttore pubblico
	
	public NavigatorElement(){};
	
	
	
	public Date getDateDay() {
		return dateDay;
	}
	public void setDateDay(Date dateDay) {
		this.dateDay = dateDay;
	}

	public long getIdModuleType() {
		return idModuleType;
	}
	public void setIdModuleType(long idModuleType) {
		this.idModuleType = idModuleType;
	}
	public long getIdModule() {
		return idModule;
	}
	public void setIdModule(long idModule) {
		this.idModule = idModule;
	}
	public long getIdUser() {
		return idUser;
	}
	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}
	public long getIdModuleCluster() {
		return idModuleCluster;
	}
	public void setIdModuleCluster(long idModuleCluster) {
		this.idModuleCluster = idModuleCluster;
	}
	
	
	
	
	
}
