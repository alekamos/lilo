package it.costanza.LiLo.dao;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import it.costanza.LiLo.bean.ModuleDayHost;
import it.costanza.LiLo.bean.ModuleExtended;
import it.costanza.LiLo.bean.NavigatorElement;
import it.costanza.LiLo.bean.NavigatorSearch;
import it.costanza.LiLo.mybatis.bean.ModuleCluster;
import it.costanza.LiLo.util.Const;



public class ModuleDayHostDao extends MyBatisDAO<ModuleDayHost, Integer>{

	public ModuleDayHostDao() {
		super(ModuleDayHost.class);
	}

	
	/**
	 * Il metodo estrae mettendo in left join con calendar i giorni ed affianco mette i dati sul dayhost che trova.
	 * @param navigatorSearch
	 * @return
	 * @throws PersistenceException
	 */
    public ArrayList<NavigatorElement> searchDayHostList(NavigatorSearch navigatorSearch) throws PersistenceException {
    	SqlSession session = MyBatisLoader.getSqlSession();
    	List<NavigatorElement> list;
		try
		{					
			String query = Const.NS_PREFIX+this.getClass().getSimpleName().replace("Dao", "")+Const.NS_SUFFIX+"."+"selectListDayHostInDateRange";
			list = session.selectList(query,navigatorSearch); 
		}
		finally
		{
			session.close();
		}   
		return (ArrayList<NavigatorElement>) list;
    }
    
  
    
	
}
