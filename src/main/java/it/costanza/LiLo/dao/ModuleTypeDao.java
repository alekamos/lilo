package it.costanza.LiLo.dao;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;


import it.costanza.LiLo.mybatis.bean.ModuleType;
import it.costanza.LiLo.util.Const;

public class ModuleTypeDao extends MyBatisDAO<ModuleType, Integer>{



	public ModuleTypeDao() {
		super(ModuleType.class);
	}
	
    public ArrayList<ModuleType> searchByUserId(Integer idUser) throws PersistenceException {
    	SqlSession session = MyBatisLoader.getSqlSession();
    	List<ModuleType> list;
		try
		{					
			String query = Const.NS_PREFIX+this.getClass().getSimpleName().replace("Dao", "")+Const.NS_SUFFIX+"."+Const.PREFIX_SELECTBYUSER_QUERY;
			list = session.selectList(query,idUser); 
		}
		finally
		{
			session.close();
		}   
		return (ArrayList<ModuleType>) list;
    }
    
 

}
