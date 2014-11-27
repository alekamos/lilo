package it.costanza.LiLo.dao;

import it.costanza.LiLo.mybatis.bean.ModuleNumeric;


public class ModuleNumericDao extends MyBatisDAO<ModuleNumeric, Integer>{

	public ModuleNumericDao() {
		super(ModuleNumeric.class);
	}

}
