package it.costanza.LiLo.dao;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import it.costanza.LiLo.bean.ModuleDayHost;
import it.costanza.LiLo.bean.ModuleFinder;
import it.costanza.LiLo.bean.NavigatorElement;
import it.costanza.LiLo.bean.NavigatorSearch;
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

	/**
	 * Il metodo estrae un giorno random dell'utente
	 * @param dayHost
	 * @return
	 */
	public ModuleDayHost searchRandomDayHost(ModuleDayHost dayHost) {
		SqlSession session = MyBatisLoader.getSqlSession();
		ModuleDayHost moduleDayHost = new ModuleDayHost();
		
		try
		{					
			String query = Const.NS_PREFIX+this.getClass().getSimpleName().replace("Dao", "")+Const.NS_SUFFIX+"."+"selectRandomDayHost";
			moduleDayHost = session.selectOne(query, dayHost);
		}
		finally
		{
			session.close();
		}   
		return moduleDayHost;
	}


	public ArrayList<ModuleDayHost> searchDayHostListCriteria(
			ModuleFinder moduleFinder) {
		SqlSession session = MyBatisLoader.getSqlSession();
		List<ModuleDayHost> list;
		try
		{					
			String query = Const.NS_PREFIX+this.getClass().getSimpleName().replace("Dao", "")+Const.NS_SUFFIX+"."+"selectListDayHostCriteria";
			list = session.selectList(query,moduleFinder);
		}
		finally
		{
			session.close();
		}   
		return (ArrayList<ModuleDayHost>) list;
	}


	public ModuleDayHost searchMostRecentDayHost(ModuleDayHost dayHost) {
		SqlSession session = MyBatisLoader.getSqlSession();
		ModuleDayHost moduleDayHost = new ModuleDayHost();
		
		try
		{					
			String query = Const.NS_PREFIX+this.getClass().getSimpleName().replace("Dao", "")+Const.NS_SUFFIX+"."+"selectMostRecentDayHost";
			moduleDayHost = session.selectOne(query, dayHost);
		}
		finally
		{
			session.close();
		}   
		return moduleDayHost;
	}

}
