package it.costanza.LiLo.mybatis.bean;

import java.util.Date;

public class Calendar {
    private Date date;

    private String dayOfWeek;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
}