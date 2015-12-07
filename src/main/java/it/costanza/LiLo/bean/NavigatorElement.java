package it.costanza.LiLo.bean;

import java.util.Date;

public class NavigatorElement {

	private Date dateDay;
	private Integer idModuleCluster;
	private Integer idModuleType;
	private Integer idModule;
	private Integer idUser;
	private Long size;
	
	//Costruttore pubblico
	
	public NavigatorElement(){};
	
	
	
	public Date getDateDay() {
		return dateDay;
	}
	public void setDateDay(Date dateDay) {
		this.dateDay = dateDay;
	}



	public Integer getIdModuleCluster() {
		return idModuleCluster;
	}



	public void setIdModuleCluster(Integer idModuleCluster) {
		this.idModuleCluster = idModuleCluster;
	}



	public Integer getIdModuleType() {
		return idModuleType;
	}



	public void setIdModuleType(Integer idModuleType) {
		this.idModuleType = idModuleType;
	}



	public Integer getIdModule() {
		return idModule;
	}



	public void setIdModule(Integer idModule) {
		this.idModule = idModule;
	}



	public Integer getIdUser() {
		return idUser;
	}



	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}



	public Long getSize() {
		return size;
	}



	public void setSize(Long size) {
		this.size = size;
	}

	
	
	
	
}
