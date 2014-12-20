package it.costanza.LiLo.mybatis.bean;

import it.costanza.LiLo.util.Utility;

import java.util.ArrayList;

public class ModuleText {
    private Integer idModule;

    private String text2Value;

    private String text3Value;

    private String text1Value;

    public Integer getIdModule() {
        return idModule;
    }

    public void setIdModule(Integer idModule) {
        this.idModule = idModule;
    }

    public String getText2Value() {
        return text2Value;
    }

    public void setText2Value(String text2Value) {
        this.text2Value = text2Value;
    }

    public String getText3Value() {
        return text3Value;
    }

    public void setText3Value(String text3Value) {
        this.text3Value = text3Value;
    }

    public String getText1Value() {
        return text1Value;
    }

    public void setText1Value(String text1Value) {
        this.text1Value = text1Value;
    }
    

    
    @Override
    public String toString() {

    	ArrayList<String> chiavi = new ArrayList<String>();
    	ArrayList<String> valori = new ArrayList<String>();
    	
    	chiavi.add("idModule");
    	chiavi.add("text1Value");
    	chiavi.add("text2Value");
    	chiavi.add("text3Value");


    	
    	valori.add(idModule+"");
    	valori.add(text1Value);
    	valori.add(text2Value);
    	valori.add(text3Value);
    	
    	return Utility.toStringPerBean(chiavi, valori);
    	
    }
}