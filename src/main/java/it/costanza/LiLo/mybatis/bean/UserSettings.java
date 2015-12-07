package it.costanza.LiLo.mybatis.bean;

import java.util.Date;

public class UserSettings {
    private Integer idUser;

    private Integer idProperty;

    private String value;

    private Date insertTimestamp;

    private Date updateTimestamp;

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdProperty() {
        return idProperty;
    }

    public void setIdProperty(Integer idProperty) {
        this.idProperty = idProperty;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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