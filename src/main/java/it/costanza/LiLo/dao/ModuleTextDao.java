package it.costanza.LiLo.dao;

import it.costanza.LiLo.mybatis.bean.ModuleText;

public class ModuleTextDao extends MyBatisDAO<ModuleText, Integer>{

	public ModuleTextDao() {
		
		super(ModuleText.class);
	}

}
