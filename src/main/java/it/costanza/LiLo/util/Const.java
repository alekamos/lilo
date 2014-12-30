package it.costanza.LiLo.util;

public class Const {

	//Nomi tabelle
	public static final String CALENDAR = "CALENDAR";
	public static final String LIST_ELEMENTS = "LIST_ELEMENTS";
	public static final String MODULE_HEADER = "MODULE_HEADER";
	public static final String MODULES_CLUSTER = "MODULES_CLUSTER";
	public static final String MODULES_DATETIME = "MODULES_DATETIME";
	public static final String MODULES_NUMERIC_DATA = "MODULES_NUMERIC_DATA";
	public static final String MODULES_LIST = "MODULES_LIST";
	public static final String MODULES_TEXT = "MODULES_TEXT";
	public static final String MODULES_TYPES = "MODULES_TYPES";
	public static final String MODULE_TYPE_SETTINGS = "MODULE_TYPE_SETTINGS";
	public static final String PROPERTIES = "PROPERTIES";
	public static final String USERS = "USERS";
	public static final String USER_SETTINGS = "USER_SETTINGS";

	//costanti per mybatis
	public static final String NS_SUFFIX = "Mapper";
	public static final String NS_PREFIX = "it.costanza.LiLo.mybatis.mappers.";
	public static final String PREFIX_SELECT_QUERY = "selectByPrimaryKey"; 
	public static final String PREFIX_INSERT_QUERY = "insertSelective";
	public static final String PREFIX_UPDATE_QUERY = "updateByPrimaryKeySelective";  
	public static final String PREFIX_DELETE_QUERY = "deleteByPrimaryKey";  

	//costanti per le query
	public static final String PREFIX_SELECTBYUSER_QUERY = "selectByUser";
	public static final String PREFIX_SELECT_LIST_IDMODULE = "selectListByIdModule";
	
	//costanti per i log
	public static final Object IN = "<------   IN   ------>";
	public static final Object OUT = "<------   OUT   ------>";
	
	//Costanti allineate con il DB
	public static final int[] ARRAY_MODULI_DEFAULT = {1};
	public static int ID_TYPE_DAY_HOST = 7;
	
	//Nomi costanti struts2
	public static final String UNAUTHORIZED_CONTENT = "unauthorized_content";

}
