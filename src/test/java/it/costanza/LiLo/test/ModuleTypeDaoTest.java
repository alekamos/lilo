package it.costanza.LiLo.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import it.costanza.LiLo.dao.ModuleTypeDao;
import it.costanza.LiLo.mybatis.bean.ModuleType;

import org.junit.Test;

public class ModuleTypeDaoTest {

	@Test
	public void testModuleTypeFinderByUser(){
		ModuleType mt = new ModuleType();
		ModuleTypeDao mtd = new ModuleTypeDao();

		ArrayList<ModuleType> list = mtd.searchByUserId(1);	
		assertTrue(list.size()==2);
	}

}
