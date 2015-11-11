package it.costanza.LiLo.dao;
import it.costanza.LiLo.mybatis.bean.Calendar;


public class CalendarDao extends MyBatisDAO<Calendar, Integer>{

	public CalendarDao() {
		super(Calendar.class);
	}

}
