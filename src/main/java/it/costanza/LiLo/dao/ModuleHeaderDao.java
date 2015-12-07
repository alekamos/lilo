package it.costanza.LiLo.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import it.costanza.LiLo.mybatis.bean.ModuleHeader;
import it.costanza.LiLo.util.Const;



public class ModuleHeaderDao extends MyBatisDAO<ModuleHeader, Integer>{

	public ModuleHeaderDao() {
		super(ModuleHeader.class);
	}
	
	
    public ArrayList<ModuleHeader> searchByUserId(Integer idUser) throws PersistenceException {
    	SqlSession session = MyBatisLoader.getSqlSession();
    	List<ModuleHeader> list;
		try
		{					
			String query = Const.NS_PREFIX+this.getClass().getSimpleName().replace("Dao", "")+Const.NS_SUFFIX+"."+Const.PREFIX_SELECTBYUSER_QUERY;
			list = session.selectList(query,idUser); 
		}
		finally
		{
			session.close();
		}   
		return (ArrayList<ModuleHeader>) list;
    }
    
    /**
     * Cerca tutti i moduli header per tipo e utente.
     * @param moduleHeader
     * @return
     * @throws PersistenceException
     */
    public ArrayList<ModuleHeader> searchByUserAndType(ModuleHeader moduleHeader) throws PersistenceException {
    	SqlSession session = MyBatisLoader.getSqlSession();
    	List<ModuleHeader> list;
		try
		{					
			String query = Const.NS_PREFIX+this.getClass().getSimpleName().replace("Dao", "")+Const.NS_SUFFIX+"."+"selectByUserAndType";
			list = session.selectList(query,moduleHeader); 
		}
		finally
		{
			session.close();
		}   
		return (ArrayList<ModuleHeader>) list;
    }
    
    
    

}
