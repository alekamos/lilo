package it.costanza.LiLo.mybatis.bean;

import java.util.Date;

public class ModuleDatetime {
    private Integer idModule;

    private Date datetime1Value;

    private Date datetime2Value;

    private Date datetime3Value;

    public Integer getIdModule() {
        return idModule;
    }

    public void setIdModule(Integer idModule) {
        this.idModule = idModule;
    }

    public Date getDatetime1Value() {
        return datetime1Value;
    }

    public void setDatetime1Value(Date datetime1Value) {
        this.datetime1Value = datetime1Value;
    }

    public Date getDatetime2Value() {
        return datetime2Value;
    }

    public void setDatetime2Value(Date datetime2Value) {
        this.datetime2Value = datetime2Value;
    }

    public Date getDatetime3Value() {
        return datetime3Value;
    }

    public void setDatetime3Value(Date datetime3Value) {
        this.datetime3Value = datetime3Value;
    }
}