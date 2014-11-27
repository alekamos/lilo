package it.costanza.LiLo.dao;



import it.costanza.LiLo.util.Const;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

/** 
 *  Class contains all the basic CRUD related methods which are inherited by all objects.
 *  Children daos should generally not overwrite these method but add extra ones as needed.  
 */
public abstract class MyBatisDAO<T, PK> implements GenericDaoInterface<T, PK>{
	
	//private static Logger log = LoggerFactory.getLogger(MyBatisDAO.class);
	private Class<T> type;
		
	/** 
	 * Define prefixes for easier naming convetions between XML mapper files and the DAO class 
	 **/	
	
	
	
	/** Default Constructor */
    public MyBatisDAO(Class<T> type) {
        this.type = type;
    }
    
    @SuppressWarnings("unchecked")
	public T selectById(PK id) throws PersistenceException {
        
    	SqlSession session = MyBatisLoader.getSqlSession();	
    	T obj = null;
		try
		{		
			String query = Const.NS_PREFIX+this.type.getSimpleName()+Const.NS_SUFFIX+"."+Const.PREFIX_SELECT_QUERY;
			obj = (T)session.selectOne(query,id);      
		}
		finally
		{
			session.close();
		}
		return obj;
    }
    


    public int insert(T object) throws PersistenceException{        
    	SqlSession session = MyBatisLoader.getSqlSession();
    	Integer status = null;
    	try
		{			
    		String query = Const.NS_PREFIX+object.getClass().getSimpleName()+Const.NS_SUFFIX+"."+Const.PREFIX_INSERT_QUERY;
			status = (Integer)session.insert(query,object);
			session.commit();			
		}
		finally
		{
			session.close();
		}		
		return status;
    }
    
    
    public int update(T o)throws PersistenceException {
        
    	SqlSession session = MyBatisLoader.getSqlSession();
		Integer status = null;
    	try
		{			
			String query = Const.NS_PREFIX+o.getClass().getSimpleName()+Const.NS_SUFFIX+"."+Const.PREFIX_UPDATE_QUERY;
    		status = session.update(query,o);
			session.commit();
			
		}
		finally
		{
			session.close();
		}	
		return status;
    	
    }

    
    public int delete(PK id)  throws PersistenceException{
    	SqlSession session = MyBatisLoader.getSqlSession();
		Integer status = null;
		try
		{			
			String query = Const.NS_PREFIX+this.type.getSimpleName()+Const.NS_SUFFIX+"."+Const.PREFIX_DELETE_QUERY;
			status = session.delete(query,id);
			session.commit();
		}	
		finally
		{
			session.close();
		}	
		return status;
		
    }






//*****Non implementate
    
    /** 
     *  Method returns all rows for this object.
     *  </br></br>  
     *  Example:
     *  </br>  
     *  If your DAO object is called CarInfo.java, 
     *  the corresponding mapper query id should be: &lt;select id="getAllCarInfo" ...  
     *  </br></br>  
     *  SQL Executed: select * from [tablename]
     *  </br></br>  
     *  Notes:
     *  </br>   
     *  Consider overdiding this method in order to handle large numbers of objects 
     *  with multiple references.  
     *  LAZY LOADING should be enabled in this case, otherwise you might run out of memory (eg. get all UserAccounts if the table has 1,000,000 rows)
     *  look into the aggresiveLazyLoading property 
     *  */
    
    /*
    public ArrayList<T> getAll() throws PersistenceException {
        
    	SqlSession session = sf.openSession();	
    	ArrayList<T> list = null;
		try
		{					
			String query = this.type.getSimpleName()+Const.NS_SUFFIX+"."+PREFIX_SELECT_QUERY;
			list = (ArrayList<T>)session.selectList(query); 
		}
		finally
		{
			session.close();
		}   
		return list;
    }
*/

 
    
    /** 
     *  Method returns first object which matches the given name (exact match).
     *  </br></br>  
     *  It's up to you to decide what constitutes an object's name. Typically you would have a 
     *  NAME column in the table, but not all objects have this. Generally this method should be overriden (if you need it at all)
     *  in the child dao class.
     *  </br></br>
     *  Example:
     *  </br>  
     *  If your DAO object is called CarInfo.java, 
     *  the corresponding mapper query id should be: &lt;select id="getCarInfoByName" ...  
     *  </br></br>  
     *  SQL Executed (example): select * from [tablename] where NAME = ? 
     *  
     */
    /*
    public T getByName(String name) throws PersistenceException {
        
    	SqlSession session = sf.openSession();
    	T obj = null;
		try
		{	
			String query = Const.NS_SUFFIX+"."+PREFIX_SELECT_QUERY+this.type.getSimpleName()+"ByName";
			obj = (T)session.selectOne(query,name);			
		}
		finally
		{
			session.close();
		}
		return obj;
    }
*/







}

