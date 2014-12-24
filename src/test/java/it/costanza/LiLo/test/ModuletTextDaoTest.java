package it.costanza.LiLo.test;

import static org.junit.Assert.*;

import it.costanza.LiLo.dao.ModuleTextDao;
import it.costanza.LiLo.mybatis.bean.ModuleText;


import org.junit.Test;

public class ModuletTextDaoTest {

	@Test
	public void testModuleTypeFinderByUser(){
		
		int idModule = 19;
		
		ModuleTextDao mt = new ModuleTextDao();
		ModuleText moduleText = mt.selectById(idModule);
		assertTrue(moduleText.getIdModule()==idModule);
	}

}
