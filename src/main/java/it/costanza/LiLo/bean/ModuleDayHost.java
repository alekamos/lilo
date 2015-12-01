package it.costanza.LiLo.bean;

import it.costanza.LiLo.util.Utility;

import java.util.ArrayList;
import java.util.Date;

public class ModuleDayHost{

	private Date dateDayHost;
	private long idModule;
	private long idModuleType;
	private long idModuleCluster;
	private long idUser;
	
	
	
	
	public Date getDateDayHost() {
		return dateDayHost;
	}
	public void setDateDayHost(Date dateDayHost) {
		this.dateDayHost = dateDayHost;
	}
	public long getIdModule() {
		return idModule;
	}
	public void setIdModule(long idModule) {
		this.idModule = idModule;
	}
	public long getIdModuleType() {
		return idModuleType;
	}
	public void setIdModuleType(long idModuleType) {
		this.idModuleType = idModuleType;
	}
	public long getIdModuleCluster() {
		return idModuleCluster;
	}
	public void setIdModuleCluster(long idModuleCluster) {
		this.idModuleCluster = idModuleCluster;
	}
	public long getIdUser() {
		return idUser;
	}
	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}
	

	 @Override
	    public String toString() {

	    	ArrayList<String> chiavi = new ArrayList<String>();
	    	ArrayList<String> valori = new ArrayList<String>();
	    	
	    	chiavi.add("dateDayHost");
	    	chiavi.add("idModule");
	    	chiavi.add("idModuleType");
	    	chiavi.add("idModuleCluster");
	    	chiavi.add("idUser");


	    	
	    	valori.add(dateDayHost+"");
	    	valori.add(idModule+"");
	    	valori.add(idModuleType+"");
	    	valori.add(idModuleCluster+"");
	    	valori.add(idUser+"");
	    	
	    	return Utility.toStringPerBean(chiavi, valori);
	    	
	    }
	
	
	
	
	
	
}
