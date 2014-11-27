package it.costanza.LiLo.dao;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import it.costanza.LiLo.bean.ModuleExtended;
import it.costanza.LiLo.mybatis.bean.ModuleCluster;
import it.costanza.LiLo.util.Const;



public class ModuleClusterDao extends MyBatisDAO<ModuleCluster, Integer>{

	public ModuleClusterDao() {
		super(ModuleCluster.class);
	}

	
    public ArrayList<ModuleCluster> searchByUserId(Integer idUser) throws PersistenceException {
    	SqlSession session = MyBatisLoader.getSqlSession();
    	List<ModuleCluster> list;
		try
		{					
			String query = Const.NS_PREFIX+this.getClass().getSimpleName().replace("Dao", "")+Const.NS_SUFFIX+"."+Const.PREFIX_SELECTBYUSER_QUERY;
			list = session.selectList(query,idUser); 
		}
		finally
		{
			session.close();
		}   
		return (ArrayList<ModuleCluster>) list;
    }
    
    public ArrayList<ModuleCluster> searchByUserAndIdCluster(ModuleCluster moduleCluster) throws PersistenceException {
    	SqlSession session = MyBatisLoader.getSqlSession();
    	List<ModuleCluster> list;
		try
		{					
			String query = Const.NS_PREFIX+this.getClass().getSimpleName().replace("Dao", "")+Const.NS_SUFFIX+"."+"selectByUserAndCluster";
			list = session.selectList(query,moduleCluster); 
		}
		finally
		{
			session.close();
		}   
		return (ArrayList<ModuleCluster>) list;
    }
    
    public Integer searchMaxIdCluster() throws PersistenceException {
    	SqlSession session = MyBatisLoader.getSqlSession();
    	Integer max;
		try
		{					
			String query = Const.NS_PREFIX+this.getClass().getSimpleName().replace("Dao", "")+Const.NS_SUFFIX+"."+"selectMaxIdCluster";
			max = session.selectOne(query); 
		}
		finally
		{
			session.close();
		}   
		return max;
    }
    
    /**
     * Il metodo cerca automaticamente se è presente già un cluster (giornata) in quella data
     * @param Al metodo occorre passare un module extended definito così:
     * in moduleHeader cè riempito l'idModulo e l'idUser
     * in Module datetime al campo 1 c'è la data da cercare.
     * @return
     * @throws PersistenceException
     */
    public Integer searchIfExistClusterYet(ModuleExtended me) throws PersistenceException {
    	SqlSession session = MyBatisLoader.getSqlSession();
    	Integer max;
		try
		{					
			String query = Const.NS_PREFIX+this.getClass().getSimpleName().replace("Dao", "")+Const.NS_SUFFIX+"."+"selectIfExistIdClusterForUserAndIdModuleAndDate";
			max = session.selectOne(query,me); 
		}
		finally
		{
			session.close();
		}   
		return max;
    }
    
    
    
    
    
    
	
}
