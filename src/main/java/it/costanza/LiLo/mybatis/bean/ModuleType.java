package it.costanza.LiLo.mybatis.bean;

import it.costanza.LiLo.util.Utility;

import java.util.ArrayList;
import java.util.Date;

public class ModuleType {
    private Integer idModuleType;

    private Integer idUser;

    private String name;

    private String description;

    private String textContent1Name;

    private String textContent2Name;

    private String textContent3Name;

    private String listContent1Name;

    private String listContent1Type;

    private String listContent2Name;

    private String listContent2Type;

    private String listContent3Name;

    private String listContent3Type;

    private String numericDataContent1Name;

    private String numericDataContent1Type;

    private String numericDataContent2Name;

    private String numericDataContent2Type;

    private String numericDataContent3Name;

    private String numericDataContent3Type;

    private String datetimeContent1Name;

    private String datetimeContent1Type;

    private String datetimeContent2Name;

    private String datetimeContent2Type;

    private String datetimeContent3Name;

    private String datetimeContent3Type;

    private Date insertTimestamp;

    private Date updateTimestamp;
    
    
    //Costruttore default
    public ModuleType(){}
    
    //costrutttore con idModuleType
    public ModuleType(Integer idModuleType){
    	this.idModuleType = idModuleType;
    }
    
    

    public Integer getIdModuleType() {
        return idModuleType;
    }

    public void setIdModuleType(Integer idModuleType) {
        this.idModuleType = idModuleType;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTextContent1Name() {
        return textContent1Name;
    }

    public void setTextContent1Name(String textContent1Name) {
        this.textContent1Name = textContent1Name;
    }

    public String getTextContent2Name() {
        return textContent2Name;
    }

    public void setTextContent2Name(String textContent2Name) {
        this.textContent2Name = textContent2Name;
    }

    public String getTextContent3Name() {
        return textContent3Name;
    }

    public void setTextContent3Name(String textContent3Name) {
        this.textContent3Name = textContent3Name;
    }

    public String getListContent1Name() {
        return listContent1Name;
    }

    public void setListContent1Name(String listContent1Name) {
        this.listContent1Name = listContent1Name;
    }

    public String getListContent1Type() {
        return listContent1Type;
    }

    public void setListContent1Type(String listContent1Type) {
        this.listContent1Type = listContent1Type;
    }

    public String getListContent2Name() {
        return listContent2Name;
    }

    public void setListContent2Name(String listContent2Name) {
        this.listContent2Name = listContent2Name;
    }

    public String getListContent2Type() {
        return listContent2Type;
    }

    public void setListContent2Type(String listContent2Type) {
        this.listContent2Type = listContent2Type;
    }

    public String getListContent3Name() {
        return listContent3Name;
    }

    public void setListContent3Name(String listContent3Name) {
        this.listContent3Name = listContent3Name;
    }

    public String getListContent3Type() {
        return listContent3Type;
    }

    public void setListContent3Type(String listContent3Type) {
        this.listContent3Type = listContent3Type;
    }

    public String getNumericDataContent1Name() {
        return numericDataContent1Name;
    }

    public void setNumericDataContent1Name(String numericDataContent1Name) {
        this.numericDataContent1Name = numericDataContent1Name;
    }

    public String getNumericDataContent1Type() {
        return numericDataContent1Type;
    }

    public void setNumericDataContent1Type(String numericDataContent1Type) {
        this.numericDataContent1Type = numericDataContent1Type;
    }

    public String getNumericDataContent2Name() {
        return numericDataContent2Name;
    }

    public void setNumericDataContent2Name(String numericDataContent2Name) {
        this.numericDataContent2Name = numericDataContent2Name;
    }

    public String getNumericDataContent2Type() {
        return numericDataContent2Type;
    }

    public void setNumericDataContent2Type(String numericDataContent2Type) {
        this.numericDataContent2Type = numericDataContent2Type;
    }

    public String getNumericDataContent3Name() {
        return numericDataContent3Name;
    }

    public void setNumericDataContent3Name(String numericDataContent3Name) {
        this.numericDataContent3Name = numericDataContent3Name;
    }

    public String getNumericDataContent3Type() {
        return numericDataContent3Type;
    }

    public void setNumericDataContent3Type(String numericDataContent3Type) {
        this.numericDataContent3Type = numericDataContent3Type;
    }

    public String getDatetimeContent1Name() {
        return datetimeContent1Name;
    }

    public void setDatetimeContent1Name(String datetimeContent1Name) {
        this.datetimeContent1Name = datetimeContent1Name;
    }

    public String getDatetimeContent1Type() {
        return datetimeContent1Type;
    }

    public void setDatetimeContent1Type(String datetimeContent1Type) {
        this.datetimeContent1Type = datetimeContent1Type;
    }

    public String getDatetimeContent2Name() {
        return datetimeContent2Name;
    }

    public void setDatetimeContent2Name(String datetimeContent2Name) {
        this.datetimeContent2Name = datetimeContent2Name;
    }

    public String getDatetimeContent2Type() {
        return datetimeContent2Type;
    }

    public void setDatetimeContent2Type(String datetimeContent2Type) {
        this.datetimeContent2Type = datetimeContent2Type;
    }

    public String getDatetimeContent3Name() {
        return datetimeContent3Name;
    }

    public void setDatetimeContent3Name(String datetimeContent3Name) {
        this.datetimeContent3Name = datetimeContent3Name;
    }

    public String getDatetimeContent3Type() {
        return datetimeContent3Type;
    }

    public void setDatetimeContent3Type(String datetimeContent3Type) {
        this.datetimeContent3Type = datetimeContent3Type;
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

		chiavi.add("idModuleType");
    	chiavi.add("idUser");
    	chiavi.add("name");
    	chiavi.add("description");
    	chiavi.add("textContent1Name");
    	chiavi.add("textContent2Name");
    	chiavi.add("textContent3Name");
    	chiavi.add("listContent1Name");
    	chiavi.add("listContent1Type");
    	chiavi.add("listContent2Name");
    	chiavi.add("listContent2Type");
    	chiavi.add("listContent3Name");
    	chiavi.add("listContent3Type");
    	chiavi.add("numericDataContent1Name");
    	chiavi.add("numericDataContent1Type");
    	chiavi.add("numericDataContent2Name");
    	chiavi.add("numericDataContent2Type");
    	chiavi.add("numericDataContent3Name");
    	chiavi.add("numericDataContent3Type");
    	chiavi.add("datetimeContent1Name");
    	chiavi.add("datetimeContent1Type");
    	chiavi.add("datetimeContent2Name");
    	chiavi.add("datetimeContent2Type");
    	chiavi.add("datetimeContent3Name");
    	chiavi.add("datetimeContent3Type");
    	chiavi.add("insertTimestamp");
    	chiavi.add("updateTimestamp");

		valori.add(idModuleType+"");
    	valori.add(idUser+"");
    	valori.add(name);
    	valori.add(description);
    	valori.add(textContent1Name);
    	valori.add(textContent2Name);
    	valori.add(textContent3Name);
    	valori.add(listContent1Name);
    	valori.add(listContent1Type);
    	valori.add(listContent2Name);
    	valori.add(listContent2Type);
    	valori.add(listContent3Name);
    	valori.add(listContent3Type);
    	valori.add(numericDataContent1Name);
    	valori.add(numericDataContent1Type);
    	valori.add(numericDataContent2Name);
    	valori.add(numericDataContent2Type);
    	valori.add(numericDataContent3Name);
    	valori.add(numericDataContent3Type);
    	valori.add(datetimeContent1Name);
    	valori.add(datetimeContent1Type);
    	valori.add(datetimeContent2Name);
    	valori.add(datetimeContent2Type);
    	valori.add(datetimeContent3Name);
    	valori.add(datetimeContent3Type);
    	valori.add(insertTimestamp+"");
    	valori.add(updateTimestamp+"");
    	
    	return Utility.toStringPerBean(chiavi, valori);
    	
    }
}