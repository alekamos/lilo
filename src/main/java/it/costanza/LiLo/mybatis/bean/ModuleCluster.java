package it.costanza.LiLo.mybatis.bean;

import it.costanza.LiLo.util.Utility;

import java.util.ArrayList;
import java.util.Date;

public class ModuleCluster {
    private Integer idModuleCluster;

    private Integer idUser;

    private Integer idModuleType;

    private Integer idModule;

    private Date insertTimestamp;

    private Date updateTimestamp;

    public Integer getIdModuleCluster() {
        return idModuleCluster;
    }

    public void setIdModuleCluster(Integer idModuleCluster) {
        this.idModuleCluster = idModuleCluster;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
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

    public Date getInsertTimestamp() {
        return insertTimestamp;
    }

    public void setInsertTimestamp(Date insertTimestamp) {
        this.insertTimestamp = insertTimestamp;
    }

    public Date getUpdateTimestamp() {
        return updateTimestamp;
    }

    public void setUpdateTimestamp(Date updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }
    

    @Override
    public String toString() {

    	ArrayList<String> chiavi = new ArrayList<String>();
    	ArrayList<String> valori = new ArrayList<String>();
    	
    	chiavi.add("idModuleCluster");
    	chiavi.add("idUser");
    	chiavi.add("idModuleType");
    	chiavi.add("idModule");
       	chiavi.add("insertTimestamp");
    	chiavi.add("updateTimestamp");


    	
    	valori.add(idModuleCluster+"");
    	valori.add(idUser+"");
    	valori.add(idModuleType+"");
    	valori.add(idModule+"");
    	valori.add(insertTimestamp+"");
    	valori.add(updateTimestamp+"");
    	
    	return Utility.toStringPerBean(chiavi, valori);
    	
    }
    
}