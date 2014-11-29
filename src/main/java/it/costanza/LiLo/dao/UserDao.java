package it.costanza.LiLo.dao;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import it.costanza.LiLo.mybatis.bean.User;
import it.costanza.LiLo.util.Const;

public class UserDao extends MyBatisDAO<User, Integer>{

	public UserDao() {
		super(User.class);
	}
	
	   public User searchByUsernameAndPassword(User userIn) throws PersistenceException {
	    	SqlSession session = MyBatisLoader.getSqlSession();
	    	User userOut;
			try
			{					
				String query = Const.NS_PREFIX+this.getClass().getSimpleName().replace("Dao", "")+Const.NS_SUFFIX+"."+"selectByUsernameAndPassword";
				userOut = session.selectOne(query,userIn); 
			}
			finally
			{
				session.close();
			}   
			return userOut;
	    }

	public User searchByUsername(User userIn) {
    	SqlSession session = MyBatisLoader.getSqlSession();
    	User userOut;
		try
		{					
			String query = Const.NS_PREFIX+this.getClass().getSimpleName().replace("Dao", "")+Const.NS_SUFFIX+"."+"selectByUsername";
			userOut = session.selectOne(query,userIn); 
		}
		finally
		{
			session.close();
		}   
		return userOut;
    }
	
	public User searchByEmail(User userIn) {
    	SqlSession session = MyBatisLoader.getSqlSession();
    	User userOut;
		try
		{					
			String query = Const.NS_PREFIX+this.getClass().getSimpleName().replace("Dao", "")+Const.NS_SUFFIX+"."+"selectByEmail";
			userOut = session.selectOne(query,userIn); 
		}
		finally
		{
			session.close();
		}   
		return userOut;
    }
	

}
