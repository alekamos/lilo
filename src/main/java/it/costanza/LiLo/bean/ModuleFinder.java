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
	private Date startDateDt;
	private Date endDateDt;
	private String criteria;
	private String containedText;
	
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
    	chiavi.add("idModuleCluster");
    	chiavi.add("idModuleType");
    	chiavi.add("dateDayHost");
    	chiavi.add("startDate");
    	chiavi.add("endDate");
    	chiavi.add("startDateDt");
    	chiavi.add("endDateDt");
    	chiavi.add("criteria");
    	chiavi.add("containedText");

    	
    	valori.add("idModule"+"");
    	valori.add("idModuleCluster"+"");
    	valori.add("idModuleType"+"");
    	valori.add("dateDayHost"+"");
    	valori.add("startDate"+"");
    	valori.add("endDate"+"");
    	valori.add("startDateDt"+"");
    	valori.add("endDateDt"+"");
    	valori.add("criteria"+"");
    	valori.add("containedText"+"");

    	
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


	public String getCriteria() {
		return criteria;
	}


	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}


	public String getContainedText() {
		return containedText;
	}


	public void setContainedText(String containedText) {
		this.containedText = containedText;
	}


	public Date getStartDateDt() {
		return startDateDt;
	}


	public void setStartDateDt(Date startDateDt) {
		this.startDateDt = startDateDt;
	}


	public Date getEndDateDt() {
		return endDateDt;
	}


	public void setEndDateDt(Date endDateDt) {
		this.endDateDt = endDateDt;
	}


	
}
