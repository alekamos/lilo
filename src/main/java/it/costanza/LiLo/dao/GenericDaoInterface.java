package it.costanza.LiLo.dao;

import org.apache.ibatis.exceptions.PersistenceException;

/**
 * Generic implementation of DAO pattern
 * http://www.ibm.com/developerworks/java/library/j-genericdao.html
 */
public interface GenericDaoInterface<T, PK>{
	public T selectById(PK id) throws PersistenceException;//get obj of type T by the primary key 'id'	
	public int insert(T objInstance) throws PersistenceException;//insert an object of type T into the database
    int update(T transientObject) throws PersistenceException; //update an object of type T    
    int delete(PK id)  throws PersistenceException;//delete an object of type T
    

}
