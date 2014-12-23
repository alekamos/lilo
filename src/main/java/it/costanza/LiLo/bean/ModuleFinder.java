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
	
}
