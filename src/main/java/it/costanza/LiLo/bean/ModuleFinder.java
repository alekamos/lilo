package it.costanza.LiLo.bean;

import java.util.Date;
/**
 * Oggetto che serve dal form per portarsi i campi di ricerca
 * @author costanza
 *
 */
public class ModuleFinder {
	
	
	private Integer idModule;
	private Integer idModuleType;
	private Date dateDayHost;
	
	//costruttore vuoto
	public ModuleFinder(){};
	
	
	public Integer getIdModule() {
		return idModule;
	}
	public void setIdModule(Integer idModule) {
		this.idModule = idModule;
	}
	public Integer getIdModuleType() {
		return idModuleType;
	}
	public void setIdModuleType(Integer idModuleType) {
		this.idModuleType = idModuleType;
	}
	public Date getDateDayHost() {
		return dateDayHost;
	}
	public void setDateDayHost(Date dateDayHost) {
		this.dateDayHost = dateDayHost;
	}

}
