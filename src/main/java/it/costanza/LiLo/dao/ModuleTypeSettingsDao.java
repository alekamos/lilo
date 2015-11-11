package it.costanza.LiLo.dao;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;


import it.costanza.LiLo.mybatis.bean.ModuleTypeSettings;
import it.costanza.LiLo.util.Const;

public class ModuleTypeSettingsDao extends MyBatisDAO<ModuleTypeSettings, Integer>{



	public ModuleTypeSettingsDao() {
		super(ModuleTypeSettings.class);
	}
	
	/**
     * Cerca tutti i moduli header per tipo e utente.
     * @param moduleHeader
     * @return
     * @throws PersistenceException
     */
    public ArrayList<ModuleTypeSettings> searchByIdPropertyAndValue(ModuleTypeSettings moduleTypeSettings) throws PersistenceException {
    	SqlSession session = MyBatisLoader.getSqlSession();
    	List<ModuleTypeSettings> list;
		try
		{					
			String query = Const.NS_PREFIX+this.getClass().getSimpleName().replace("Dao", "")+Const.NS_SUFFIX+"."+"selectByIdProperyAndValue";
			list = session.selectList(query,moduleTypeSettings); 
		}
		finally
		{
			session.close();
		}   
		return (ArrayList<ModuleTypeSettings>) list;
    }
    
 

}
