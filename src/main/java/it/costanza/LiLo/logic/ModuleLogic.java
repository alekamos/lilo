/**
 * 
 */
package it.costanza.LiLo.logic;

import it.costanza.LiLo.bean.ModuleDayHost;
import it.costanza.LiLo.bean.ModuleExtended;
import it.costanza.LiLo.bean.ModuleFinder;
import it.costanza.LiLo.dao.ModuleClusterDao;
import it.costanza.LiLo.dao.ModuleExtendedDao;
import it.costanza.LiLo.dao.ModuleHeaderDao;
import it.costanza.LiLo.dao.ModuleTypeDao;
import it.costanza.LiLo.mybatis.bean.ModuleCluster;
import it.costanza.LiLo.mybatis.bean.ModuleDatetime;
import it.costanza.LiLo.mybatis.bean.ModuleHeader;
import it.costanza.LiLo.mybatis.bean.ModuleType;
import it.costanza.LiLo.mybatis.bean.User;
import it.costanza.LiLo.util.Const;
import it.costanza.LiLo.util.Utility;

import java.util.ArrayList;

import org.apache.log4j.Logger;

/**
 * @author costanza
 *La classe contiene i metodi e l'intelligenza per gestire i moduli
 */
public class ModuleLogic {


	private static final Logger log = Logger.getLogger("lifelogLogger");

	/**
	 * Crea un arraylist con la lista di tabelle che il metodo ModuleExtended.getModuleExtended deve caricare.
	 * @param idModuleType del type di modulo
	 * @return lista di tabelle da caricare
	 */
	private ArrayList<String> buildTableNameListToLoad(Integer idModuleType){
		ArrayList<String> listaTabelle = new ArrayList<String>();
		ModuleTypeDao dao = new ModuleTypeDao();
		ModuleType mt = dao.selectById(idModuleType);
		
		//Sempre module Header e moduleCluster:
		listaTabelle.add(Const.MODULE_HEADER);
		listaTabelle.add(Const.MODULES_CLUSTER);
		
		//Controllo sui testi
		if(!Utility.isEmpty(mt.getTextContent1Name()) || !Utility.isEmpty(mt.getTextContent2Name()) || !Utility.isEmpty(mt.getTextContent3Name()))
			listaTabelle.add(Const.MODULES_TEXT);
		//Controllo sulle date
		if(!Utility.isEmpty(mt.getDatetimeContent1Name()))
			listaTabelle.add(Const.MODULES_DATETIME);
		//Controllo sulle liste
		if(!Utility.isEmpty(mt.getListContent1Name()))
			listaTabelle.add(Const.MODULES_LIST);
		//Controllo sui dati numerici
		if(!Utility.isEmpty(mt.getNumericDataContent1Name()))
			listaTabelle.add(Const.MODULES_NUMERIC_DATA);
		return listaTabelle;

	}

	/**
	 * Carica i moduli type proprietari dell'utente
	 * @param user
	 * @return
	 */
	public ArrayList<ModuleType> getUserModuleType(User user){

		ModuleTypeDao dao = new ModuleTypeDao();
		ArrayList<ModuleType> moduliTypeList = dao.searchByUserId(user.getIdUser());

		return moduliTypeList;

	}

	/**
	 * Carica i moduli di default utilizzando i moduli dichiarati nella costante: Const.ARRAY_MODULI_DEFAULT
	 * @param moduleTypeList 
	 * @return
	 */
	public ArrayList<ModuleType> getDefaultModuleType(ArrayList<ModuleType> moduleTypeList) {
		ModuleTypeDao dao = new ModuleTypeDao();

		for (int idModuloType : Const.ARRAY_MODULI_DEFAULT){ 
			moduleTypeList.add(dao.selectById(idModuloType));
		}

		return moduleTypeList;
	}

	/**
	 * Salva moduloType sul db
	 * @param moduleType
	 */
	public void insertModuleType(ModuleType moduleType) {
		ModuleTypeDao dao = new ModuleTypeDao();
		dao.insert(moduleType);
	}

	/**
	 * Si occupa di sistemare i dati del modulo prima del salvataggio sul DB.
	 * Ad esempio se i campi listType non sono settati li setta lui.
	 * In futuro se serve, si pu� mettere qui il fatto di rendere null i campi con stringa vuota.
	 * @param moduleType
	 * @return
	 */
	public ModuleType cleanModuleType(ModuleType moduleType) {

		String listName1 = moduleType.getDatetimeContent1Name();
		if(!Utility.isEmpty(listName1))
			moduleType.setDatetimeContent1Type(listName1.toUpperCase().replace(" ", "_"));

		String listName2 = moduleType.getDatetimeContent2Name();
		if(!Utility.isEmpty(listName2))
			moduleType.setDatetimeContent2Type(listName2.toUpperCase().replace(" ", "_"));

		String listName3 = moduleType.getDatetimeContent3Name();
		if(!Utility.isEmpty(listName3))
			moduleType.setDatetimeContent3Type(listName3.toUpperCase().replace(" ", "_"));


		return moduleType;
	}

	/**
	 * Carica il modulo type invocando il dao, tramite id
	 * @param moduleType contenente l'id
	 * @return
	 */
	public ModuleType getModuleType(ModuleType moduleTypeIn) {
		ModuleTypeDao dao = new ModuleTypeDao();	
		ModuleType moduleTypeOut = dao.selectById(moduleTypeIn.getIdModuleType());
		return moduleTypeOut;
	}

	/**
	 * Costruisce un oggetto adatto per il dao arraggiandosi con i soli dati in arrivo. 
	 * Invoca il dao e restituisce un idModuleLCuster
	 * Controlla se � presente un dayHost
	 * @param moduleExtendedIn
	 * @return 0 se non trova niente, !0 se la data è già presente
	 */
	public int checkDayHostExist(ModuleExtended moduleExtendedIn){
		int idModuleCluster = 0;


		ModuleClusterDao dao = new ModuleClusterDao();
		ModuleExtended moduleExtendedProbe = new ModuleExtended();
		moduleExtendedProbe.setModuleHeader(moduleExtendedIn.getModuleHeader());
		moduleExtendedProbe.getModuleHeader().setIdModule(Const.ID_TYPE_DAY_HOST);

		ModuleDatetime moduleDatetimeToAdd = new ModuleDatetime();
		moduleDatetimeToAdd.setDatetime1Value(moduleExtendedIn.getModuleDayHost().getDateDayHost());
		moduleExtendedProbe.setModuleDatetime(moduleDatetimeToAdd);
		idModuleCluster = dao.searchIfExistClusterYet(moduleExtendedProbe);
		return idModuleCluster;
	}

	public ModuleExtended buildDayHostModuleExtended(ModuleExtended moduleExtended){

		ModuleClusterDao daoCluster = new ModuleClusterDao();
		int idModuleCluster = daoCluster.searchMaxIdCluster();


		ModuleExtended moduleMainDay = new ModuleExtended();
		ModuleHeader moduleHeaderMainDay = new ModuleHeader();
		moduleHeaderMainDay.setIdUser(moduleExtended.getModuleHeader().getIdUser());
		moduleHeaderMainDay.setIdModuleType(Const.ID_TYPE_DAY_HOST);
		moduleMainDay.setModuleHeader(moduleHeaderMainDay);


		ModuleCluster moduleClusterMainDay = new ModuleCluster();
		moduleClusterMainDay.setIdModuleType(Const.ID_TYPE_DAY_HOST);
		moduleClusterMainDay.setIdUser(moduleExtended.getModuleHeader().getIdUser());
		moduleClusterMainDay.setIdModuleCluster(idModuleCluster);
		moduleMainDay.setModuleCluster(moduleClusterMainDay);

		ModuleDatetime moduleDatetimeMainDay = new ModuleDatetime();
		moduleDatetimeMainDay.setDatetime1Value(moduleExtended.getModuleDayHost().getDateDayHost());
		moduleMainDay.setModuleDatetime(moduleDatetimeMainDay);
		log.debug("Sto per salvare il modulo MainDay: "+moduleMainDay.toString());

		return moduleMainDay;
	}


	/**
	 * Si occupa di salvare il modulo extended.
	 * Dappirma se non è presente si salva il modulo mainDay necessario al funzionamento del diario, successivamente
	 * si salva il modulo. I campi non presenti vengono annullati. Se già presente una mainDay viene usato quello per il salvataggio.
	 * @param moduleExtended
	 */
	public void insertModuleExtended(ModuleExtended moduleExtended) {

		ModuleExtendedDao dao = new ModuleExtendedDao();
		int idModuleCluster = checkDayHostExist(moduleExtended);
		//Vuol dire che non cè un cluster
		if(idModuleCluster == 0){
			ModuleExtended mainDay = buildDayHostModuleExtended(moduleExtended);
			idModuleCluster = mainDay.getModuleCluster().getIdModuleCluster();
			dao.saveModuleExtended(mainDay);

		}

		//Una volta salvati i dati della giornata principale (mainDay) ci si occupa di salvare la giornata
		ModuleCluster moduleClusterToAdd = new ModuleCluster();
		moduleClusterToAdd.setIdModuleCluster(idModuleCluster);
		moduleClusterToAdd.setIdUser(moduleExtended.getModuleHeader().getIdUser());
		moduleClusterToAdd.setIdModuleType(moduleExtended.getModuleHeader().getIdModuleType());
		moduleExtended.setModuleCluster(moduleClusterToAdd);
		dao.saveModuleExtended(moduleExtended);

	}

	/**
	 * Controlla se l'idModulo in input appartiene all'utente
	 * @param user
	 * @param moduleFinder
	 * @return
	 */
	public boolean checkModuleOwnership(User user, Integer idModule) {
		boolean allowView = false;
		ModuleHeaderDao dao = new ModuleHeaderDao();
		ModuleHeader moduleHeaderEstratto = dao.selectById(idModule);

		if(moduleHeaderEstratto!=null && moduleHeaderEstratto.getIdUser().equals(user.getIdUser()))
			allowView = true;

		return allowView;
	}

	/**
	 * Si occupa di caricare il modulo identificato dall'idModule all'interno del moduleFinder
	 * @param moduleFinder
	 * @return
	 */
	public ModuleExtended getModule(Integer idModule) {
		ModuleExtendedDao dao = new ModuleExtendedDao();
		ModuleHeaderDao headerDao = new ModuleHeaderDao();
		ModuleHeader moduloHeaderEstratto = headerDao.selectById(idModule);
		Integer idModuleType = moduloHeaderEstratto.getIdModuleType();
		ArrayList<String> tableNameList = buildTableNameListToLoad(idModuleType);
		//In questo modo ho gi� estratto il moduleHeader ma lo riestraggo,le cose corrette prevederebbero che eliminassi
		//il modulo header dalla tableNameList e settarlo poi da quello che mi sono estratto qua sopra(moduloHeaderEstratto)
		ModuleExtended moduleExtended = dao.getModuleExtended(idModule, tableNameList);
		return moduleExtended;
	}


	/**
	 * Carica il modulo dayhost sotto forma di modulo extended e poi lo casta in ModuleDayHost
	 * @param moduleExtendedDayHost
	 * @return
	 */
	public ModuleDayHost getDayHost(ModuleExtended moduleExtendedDayHost){
		ModuleDayHost dayHost = new ModuleDayHost();
		dayHost.setDateDayHost(moduleExtendedDayHost.getModuleDatetime().getDatetime1Value());
		dayHost.setIdModule(moduleExtendedDayHost.getModuleHeader().getIdModule());
		dayHost.setIdModuleType(Const.ID_TYPE_DAY_HOST);

		return dayHost;
	}

	/**
	 * Partendo dall'idCluster necessariamente presente in tutti i moduli lui va a cercarsi l'id del modulo 
	 * dayHost. Ovviamente � necessario conoscere l'idModuleType del modulo DayHost, e l'utente che possiede il modulo.
	 * @param idModuleCluster
	 * @param user
	 * @return
	 */
	public ModuleCluster getIdModuleDayHostFromIdCluster(Integer idModuleCluster,User user) {

		ModuleCluster moduleClusterIn = new ModuleCluster();
		moduleClusterIn.setIdModuleCluster(idModuleCluster);
		moduleClusterIn.setIdModuleType(Const.ID_TYPE_DAY_HOST);
		moduleClusterIn.setIdUser(user.getIdUser());

		ModuleClusterDao dao = new ModuleClusterDao();
		ModuleCluster moduleClusterOut = dao.searchByIdClusterAndModuleTypeAndUser(moduleClusterIn);
		return moduleClusterOut;
	}






}
