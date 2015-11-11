package it.costanza.LiLo.dao;
import it.costanza.LiLo.mybatis.bean.Property;


public class PropertyDao extends MyBatisDAO<Property, Integer>{

	public PropertyDao() {
		super(Property.class);
	}

}
