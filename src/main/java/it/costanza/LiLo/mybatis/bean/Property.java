package it.costanza.LiLo.mybatis.bean;

import java.util.Date;

public class Property {
    private Integer idProperty;

    private String nameProperty;

    private String descrProperty;

    private String availableValues;

    private Date insertTimestamp;

    private Date updateTimestamp;

    public Integer getIdProperty() {
        return idProperty;
    }

    public void setIdProperty(Integer idProperty) {
        this.idProperty = idProperty;
    }

    public String getNameProperty() {
        return nameProperty;
    }

    public void setNameProperty(String nameProperty) {
        this.nameProperty = nameProperty;
    }

    public String getDescrProperty() {
        return descrProperty;
    }

    public void setDescrProperty(String descrProperty) {
        this.descrProperty = descrProperty;
    }

    public String getAvailableValues() {
        return availableValues;
    }

    public void setAvailableValues(String availableValues) {
        this.availableValues = availableValues;
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
}