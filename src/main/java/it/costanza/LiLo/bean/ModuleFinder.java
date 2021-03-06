package it.costanza.LiLo.bean;

import it.costanza.LiLo.util.Utility;

import java.util.ArrayList;
import java.util.Date;
/**
 * Oggetto che serve dal form per portarsi i campi di ricerca
 * @author costanza
 *
 */
public class ModuleFinder {
	
	
	private Integer idModule;
	private Integer idModuleCluster;
	private Integer idModuleType;
	private Date dateDayHost;
	private String startDate;
	private String endDate;
	
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

	
	@Override
	public String toString() {
    	
    	ArrayList<String> chiavi = new ArrayList<String>();
    	ArrayList<String> valori = new ArrayList<String>();
    	
    	
    	chiavi.add("idModule");
    	chiavi.add("idModuleType");
    	chiavi.add("dateDayHost");

    	
    	valori.add(idModule+"");
    	valori.add(idModuleType+"");
    	valori.add(dateDayHost+"");

    	
    	return Utility.toStringPerBean(chiavi, valori);
    	
    }


	public Integer getIdModuleCluster() {
		return idModuleCluster;
	}


	public void setIdModuleCluster(Integer idModuleCluster) {
		this.idModuleCluster = idModuleCluster;
	}


	public String getStartDate() {
		return startDate;
	}


	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}


	public String getEndDate() {
		return endDate;
	}


	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


	
}
