package it.costanza.LiLo.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import it.costanza.LiLo.mybatis.bean.ListElement;
import it.costanza.LiLo.util.Const;


public class ListElementDao extends MyBatisDAO<ListElement, Integer>{



	public ListElementDao() {
		super(ListElement.class);
	}

/**
 * Il metodo cerca gli element per tipo
 * @param element
 * @return
 * @throws PersistenceException
 */
	public ArrayList<ListElement> searchByUser(ListElement element) throws PersistenceException {
		SqlSession session = MyBatisLoader.getSqlSession();
		List<ListElement> list;
		try
		{					
			String query = Const.NS_PREFIX+this.getClass().getSimpleName().replace("Dao", "")+Const.NS_SUFFIX+"."+"selectByType";
			list = session.selectList(query,element); 
		}
		finally
		{
			session.close();
		}   
		return (ArrayList<ListElement>) list;
	}
	
	
	/**
	 * Il metodo cerca gli elementi appartenetni all'user e type
	 * @param element
	 * @return
	 * @throws PersistenceException
	 */
	public ArrayList<ListElement> searchByUserAndType(ListElement element) throws PersistenceException {
		SqlSession session = MyBatisLoader.getSqlSession();
		List<ListElement> list;
		try
		{					
			String query = Const.NS_PREFIX+this.getClass().getSimpleName().replace("Dao", "")+Const.NS_SUFFIX+"."+"selectByUserAndType";
			list = session.selectList(query,element); 
		}
		finally
		{
			session.close();
		}   
		return (ArrayList<ListElement>) list;
	}
	
	
	/**
	 * Il metodo cerca gli elementi con la clausula IN passando un elenco di idElement.
	 * @param lista
	 * @return
	 * @throws PersistenceException
	 */
	public ArrayList<ListElement> searchByMultipleId(ArrayList<Integer> lista) throws PersistenceException {
		SqlSession session = MyBatisLoader.getSqlSession();
		List<ListElement> list;
		try
		{					
			String query = Const.NS_PREFIX+this.getClass().getSimpleName().replace("Dao", "")+Const.NS_SUFFIX+"."+"selectByMultipleId";
			list = session.selectList(query,lista); 
		}
		finally
		{
			session.close();
		}   
		return (ArrayList<ListElement>) list;
	}





}
