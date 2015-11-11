package it.costanza.LiLo.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import it.costanza.LiLo.mybatis.bean.ModuleList;
import it.costanza.LiLo.util.Const;





public class ModuleListDao extends MyBatisDAO<ModuleList, Integer>{



	public ModuleListDao() {
		super(ModuleList.class);
	}

	/**
	 * Il metodo estrae tutte le righe appartenenti allo stesso modulo.
	 * @param id
	 * @return
	 * @throws PersistenceException
	 */
	public ArrayList<ModuleList> selectListByIdModule(Integer id) throws PersistenceException {
		SqlSession session = MyBatisLoader.getSqlSession();
		List<ModuleList> list;
		try
		{					
			String query = Const.NS_PREFIX+this.getClass().getSimpleName().replace("Dao", "")+Const.NS_SUFFIX+"."+Const.PREFIX_SELECT_LIST_IDMODULE;
			list = session.selectList(query,id); 
		}
		finally
		{
			session.close();
		}   
		return (ArrayList<ModuleList>) list;
	}



}
