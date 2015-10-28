/**
 * 
 */
package it.costanza.LiLo.logic;

import it.costanza.LiLo.bean.ModuleDayHost;
import it.costanza.LiLo.bean.ModuleExtended;
import it.costanza.LiLo.bean.NavigatorElement;
import it.costanza.LiLo.bean.NavigatorSearch;
import it.costanza.LiLo.dao.ModuleClusterDao;
import it.costanza.LiLo.dao.ModuleDayHostDao;
import it.costanza.LiLo.dao.ModuleExtendedDao;
import it.costanza.LiLo.dao.ModuleHeaderDao;
import it.costanza.LiLo.dao.ModuleTypeDao;
import it.costanza.LiLo.dao.ModuleTypeSettingsDao;
import it.costanza.LiLo.dao.PropertyDao;
import it.costanza.LiLo.exception.UnauthorizedContent;
import it.costanza.LiLo.mybatis.bean.ModuleCluster;
import it.costanza.LiLo.mybatis.bean.ModuleDatetime;
import it.costanza.LiLo.mybatis.bean.ModuleHeader;
import it.costanza.LiLo.mybatis.bean.ModuleType;
import it.costanza.LiLo.mybatis.bean.ModuleTypeSettings;
import it.costanza.LiLo.mybatis.bean.User;
import it.costanza.LiLo.util.Const;
import it.costanza.LiLo.util.Utility;

import java.util.ArrayList;
import java.util.Date;

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
	 * @param operation puo' valere LOAD, o UPDATE. Nel caso load carica anche moduleHeader e cluster nel caso update solo cluster
	 * @return lista di tabelle da caricare
	 */
	private ArrayList<String> buildTableNameListToLoad(Integer idModuleType,String operation){
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
	 * Carica i moduli di default utilizzando cercando sul DB i moduli con proprieta ALL
	 * @param moduleTypeList se passata nulla viene istanziato, se presente li aggiunge a quelli gia presenti nella lista;
	 * @return
	 */
	public ArrayList<ModuleType> getDefaultModuleType(ArrayList<ModuleType> moduleTypeList) {
		ModuleTypeDao dao = new ModuleTypeDao();

		if(moduleTypeList==null)
			moduleTypeList = new ArrayList<ModuleType>();

		ModuleTypeSettings moduleTypeSettings = new ModuleTypeSettings();
		moduleTypeSettings.setIdProperty(Const.ID_PROPERTY_VISIBILITY);
		moduleTypeSettings.setValue(Const.PROPERTY_VALUE_ALL);
		ModuleTypeSettingsDao moduleTypeSettingsdao = new ModuleTypeSettingsDao();
		ArrayList<ModuleTypeSettings> publicModuleList = moduleTypeSettingsdao.searchByIdPropertyAndValue(moduleTypeSettings);

		for (ModuleTypeSettings elem : publicModuleList) {
			moduleTypeList.add(dao.selectById(elem.getIdModuleType()));
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

		String listName1 = moduleType.getListContent1Name();
		if(!Utility.isEmpty(listName1))
			moduleType.setListContent1Type(listName1.toUpperCase().replace(" ", "_"));

		String listName2 = moduleType.getListContent2Name();
		if(!Utility.isEmpty(listName2))
			moduleType.setListContent2Type(listName2.toUpperCase().replace(" ", "_"));

		String listName3 = moduleType.getListContent3Name();
		if(!Utility.isEmpty(listName3))
			moduleType.setListContent3Type(listName3.toUpperCase().replace(" ", "_"));


		return moduleType;
	}

	/**
	 * Carica il modulo type invocando il dao, tramite idModuleType
	 * @param moduleType contenente l'id
	 * @return
	 */
	public ModuleType getModuleType(ModuleType moduleTypeIn) {
		ModuleTypeDao dao = new ModuleTypeDao();	
		ModuleType moduleTypeOut = dao.selectById(moduleTypeIn.getIdModuleType());
		return moduleTypeOut;
	}

	/**
	 * Invoca il dao e restituisce un idModuleLCuster se trova gia un cluster per la giornata in questione
	 * Controlla se ce gia presente un dayHost dunque
	 * @param mextdIn che deve contenere la data
	 * @return 0 se non trova niente, !0 se la data è già presente
	 */
	public int checkDayHostExist(Integer idUser,Date dateDayHost){
		ModuleClusterDao dao = new ModuleClusterDao();
		ModuleExtended moduleExtendedProbe = new ModuleExtended();
		ModuleHeader mh = new ModuleHeader();
		ModuleDatetime mdt = new ModuleDatetime();

		mh.setIdUser(idUser);
		mh.setIdModuleType(Const.ID_TYPE_DAY_HOST);
		mdt.setDatetime1Value(dateDayHost);

		moduleExtendedProbe.setModuleHeader(mh);
		moduleExtendedProbe.setModuleDatetime(mdt);

		return dao.searchIdClusterByDate(moduleExtendedProbe);
	}

	/**
	 * Il metodo si occupa di costruire un moduloExtended per il MainDay, dunque un modulo extended
	 * formato da Header,Cluster,e un modulo datetime
	 * @param moduleExtended serve per l'utente e la data della giornata
	 * @return modulo extended gia costrutito
	 */
	public ModuleExtended buildDayHostModuleExtended(ModuleExtended moduleExtended){

		ModuleClusterDao daoCluster = new ModuleClusterDao();
		int idModuleCluster = daoCluster.searchMaxIdCluster();

		//Creazione del modulo Header ed aggiunta al modulo extended
		ModuleExtended moduleMainDay = new ModuleExtended();
		ModuleHeader moduleHeaderMainDay = new ModuleHeader();
		moduleHeaderMainDay.setIdUser(moduleExtended.getModuleHeader().getIdUser());
		moduleHeaderMainDay.setIdModuleType(Const.ID_TYPE_DAY_HOST);
		moduleMainDay.setModuleHeader(moduleHeaderMainDay);

		//Creazione del modulo Cluster e aggiunta al modulo extended
		ModuleCluster moduleClusterMainDay = new ModuleCluster();
		moduleClusterMainDay.setIdModuleType(Const.ID_TYPE_DAY_HOST);
		moduleClusterMainDay.setIdUser(moduleExtended.getModuleHeader().getIdUser());
		moduleClusterMainDay.setIdModuleCluster(idModuleCluster);
		moduleMainDay.setModuleCluster(moduleClusterMainDay);

		//Creazione del modulo datetime ed aggiunta al modulo extended
		ModuleDatetime moduleDatetimeMainDay = new ModuleDatetime();
		moduleDatetimeMainDay.setDatetime1Value(moduleExtended.getModuleDayHost().getDateDayHost());
		moduleMainDay.setModuleDatetime(moduleDatetimeMainDay);
		log.debug("Creato modulo MainDay con le seguenti caratteristiche: "+moduleMainDay.toString());

		return moduleMainDay;
	}


	/**
	 * Si occupa di salvare il modulo extended.
	 * Dappirma se non e' presente si salva il modulo dayHost necessario al funzionamento del diario, successivamente
	 * si salva il modulo. I campi non presenti vengono annullati. Se già presente una dayHost viene usato quello per il salvataggio.
	 * @param moduleExtended
	 */
	public void insertModuleExtended(ModuleExtended moduleExtended) {

		ModuleExtendedDao dao = new ModuleExtendedDao();
		int idModuleCluster = checkDayHostExist(moduleExtended.getModuleHeader().getIdUser(),moduleExtended.getModuleDayHost().getDateDayHost());
		//Vuol dire che non ce' un cluster
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
	 * Controlla se l'idModulo esiste ed � dell'utente che vuole visualizzarlo.
	 * Se il modulo non � visualizzabile per l'utente in questione viene lanciata un eccezione	
	 * @param user utente che ambisce a visualizzare il modulo
	 * @param idModule id del modulo che si deve visualizzare
	 * @throws UnauthorizedContent
	 */
	public void checkModuleOwnership(User user, Integer idModule) throws UnauthorizedContent{

		ModuleHeaderDao dao = new ModuleHeaderDao();
		ModuleHeader moduleHeaderEstratto = dao.selectById(idModule);

		if(moduleHeaderEstratto==null || !moduleHeaderEstratto.getIdUser().equals(user.getIdUser()))
			throw new UnauthorizedContent();

	}

	/**
	 * Il metodo cerca se il modulo type ha la proprieta di essere visibile a tutti gli utenti
	 * @param idModule
	 * @return true se e' un modulo con visibilita per tutti false se e' un modulo che non ha visibilita all
	 */
	private boolean isDefaultModuleType(Integer idModule){

		ArrayList<ModuleType> publicModuleList = getDefaultModuleType(null);

		for (ModuleType element : publicModuleList) {
			if(element.getIdModuleType().equals(idModule))
				return true;
		}

		return false;
	}


	/**
	 * Il metodo estrae il moduloExtended con tutto quello che c'� da estrarre basandosi solo sul idModule.
	 * @param idModule
	 * @return
	 */
	public ModuleExtended getModule(Integer idModule) {
		ModuleExtendedDao dao = new ModuleExtendedDao();
		ModuleHeaderDao headerDao = new ModuleHeaderDao();
		ModuleHeader moduloHeaderEstratto = headerDao.selectById(idModule);
		Integer idModuleType = moduloHeaderEstratto.getIdModuleType();
		ArrayList<String> tableNameList = buildTableNameListToLoad(idModuleType,Const.LOAD);
		//In questo modo ho gi� estratto il moduleHeader ma lo riestraggo,le cose corrette prevederebbero che eliminassi
		//il modulo header dalla tableNameList e settarlo poi da quello che mi sono estratto qua sopra(moduloHeaderEstratto)
		ModuleExtended moduleExtended = dao.getModuleExtended(idModule, tableNameList);
		return moduleExtended;
	}

	/**
	 * Costruisce il bean dayhost. 
	 * Riceve in input i dati "raw" sotto forma di modulo extended da qui parte per costruire ModuleDayHost
	 * @param moduleExtendedDayHost
	 * @return
	 */
	public ModuleDayHost buildDayHostFromModuleExtended(ModuleExtended moduleExtendedDayHost){
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

	/**
	 *  Il metodo estrae in modo totalmente esaustivo un modulo in tutte le sue componenti compreso  il moduleType
	 * @param idModule e' l'id del modulo che occorre estrarre
	 * @param user e'l'user che possiede il modulo
	 *  se != null viene impostato al moduloExtended in uscita quello passato al metodo
	 * @return
	 */
	public ModuleExtended getModuleExtended(Integer idModule, User user){

		ModuleExtended moduleExtended = getModule(idModule);	


		ModuleType moduleType = getModuleType(new ModuleType(moduleExtended.getModuleHeader().getIdModuleType()));
		moduleExtended.setModuleType(moduleType);

		//Qui viene estratto il dayHost
		ModuleCluster moduleClusterDayHost = getIdModuleDayHostFromIdCluster(moduleExtended.getModuleCluster().getIdModuleCluster(),user);
		Integer idModuleDayHost = moduleClusterDayHost.getIdModule();
		ModuleExtended moduleExtendedDayHost = getModule(idModuleDayHost);//TODO in questo punto occorre creare un metodo che estrae il dayHost semplificando il reperimento ed utilizzando la vista
		ModuleDayHost dayHost = buildDayHostFromModuleExtended(moduleExtendedDayHost);
		moduleExtended.setModuleDayHost(dayHost);

		return moduleExtended; 
	}

	/**
	 * Carica tutto il dayHost, tutti i moduli appartenenti al dayHost identificato dal idModuleCluster
	 * @param idModuleCluster � il cluster che accomuna tutti i moduli del dayHost
	 * @param user � l'utente che possiede il cluster
	 * @return La lista di tutti i moduli appartenenti al dayHost completo (La giornata)
	 */
	public ArrayList<ModuleExtended> getModuleExtendList(Integer idModuleCluster, User user){
		ArrayList<ModuleExtended> moduleExtendedList = new ArrayList<ModuleExtended>();
		ModuleClusterDao mcDao = new ModuleClusterDao();

		ArrayList<ModuleCluster> moduleClusterList = mcDao.searchByUserAndIdCluster(new ModuleCluster(idModuleCluster,user.getIdUser()));
		for (ModuleCluster moduleCluster : moduleClusterList) {
			moduleExtendedList.add(getModuleExtended(moduleCluster.getIdModule(), user));
		}

		return moduleExtendedList;
	}


	/**
	 * Il metodo restituisce l'idCluster(dayHost) partendo da una data e dall'user che ambisce a vedere il cluster
	 * Avendo cercato successivamente al metodo non occorre autenticazione del cluster
	 * @param date la data che dovrebbe contenere un dayHost o cluster
	 * @param user l'user che ambisce a visualizzare questo dayHost
	 * @return ilCluster 0 se non ha trovato niente, != 0 se trova qualcosa
	 */
	public Integer getIdClusterFromDate(Date date,User user){
		ModuleExtended moduleExtended = new ModuleExtended();
		ModuleHeader moduleHeader = new ModuleHeader();
		ModuleDatetime moduleDatetime = new ModuleDatetime();
		ModuleClusterDao mcDao = new ModuleClusterDao();

		moduleHeader.setIdUser(user.getIdUser());
		moduleHeader.setIdModuleType(Const.ID_TYPE_DAY_HOST);
		moduleExtended.setModuleHeader(moduleHeader);
		moduleDatetime.setDatetime1Value(date);
		moduleExtended.setModuleDatetime(moduleDatetime);

		return mcDao.searchIdClusterByDate(moduleExtended);
	}

	/**
	 * Il metodo restituisce l'oggetto navigatore
	 * @param user
	 * @return
	 */
	public ArrayList<NavigatorElement> buildNavigator(User user,Date startDate,Date endDate) {
		ModuleDayHostDao dhdao = new ModuleDayHostDao();
		NavigatorSearch navigatorSearch = new NavigatorSearch();
		navigatorSearch.setIdUser(user.getIdUser());
		navigatorSearch.setDateStart(startDate);
		navigatorSearch.setDateEnd(endDate);
		ArrayList<NavigatorElement> dayHostList = dhdao.searchDayHostList(navigatorSearch);
		return dayHostList;
	}


	/**
	 * Il metodo restituisce un idCluster dell'utente casuale
	 * @param user
	 * @return
	 */
	public Integer getRandomIdCluster(User user) {
		ModuleDayHostDao dayHostdao = new ModuleDayHostDao();
		ModuleDayHost dayHost = new ModuleDayHost();
		dayHost.setIdUser(user.getIdUser());

		ModuleDayHost moduleDayHost = dayHostdao.searchRandomDayHost(dayHost);
		Integer idModuleCluster = (int) moduleDayHost.getIdModuleCluster();

		return idModuleCluster; 
	}


	/**
	 * Controlla se l'idModuloType esiste ed e' dell'utente che vuole visualizzarlo.
	 * Se il moduloType non e' visualizzabile per l'utente in questione viene lanciata un eccezione	
	 * @param user utente che ambisce a visualizzare il modulo
	 * @param idModuleType id del moduloType che si deve visualizzare
	 * @throws UnauthorizedContent
	 */
	public void checkModuleTypeOwnership(User user, Integer idModuleType) throws UnauthorizedContent{

		ModuleTypeDao dao = new ModuleTypeDao();
		ModuleType moduleTypeExtracted = dao.selectById(idModuleType);

		//Se oltre le condizioni non appartiene nemmeno ai moduli di defoult (AND) lancio eccezione
		if((moduleTypeExtracted==null || !moduleTypeExtracted.getIdUser().equals(user.getIdUser())) && !isDefaultModuleType(idModuleType))
			throw new UnauthorizedContent();

	}


	/**
	 * Il metodo fa update del modulo extended. Se viene cambiato il giorno e si crea una nuovo dayHost viene creato
	 * @param user 
	 * @param moduleExtended del modulo appena modificato
	 */
	public void updateModuleExtend(User user, ModuleExtended moduleExtended) {
		//set idUser
		moduleExtended.getModuleHeader().setIdUser(user.getIdUser());
		boolean foundDayHost = false;


		ModuleExtendedDao dao = new ModuleExtendedDao();
		int idModuleCluster = checkDayHostExist(moduleExtended.getModuleHeader().getIdUser(),moduleExtended.getModuleDayHost().getDateDayHost());
		//Vuol dire che non ce un cluster, cioe' viene modificato il giorno e non era ancora presente.
		if(idModuleCluster == 0){
			ModuleExtended mainDay = buildDayHostModuleExtended(moduleExtended);
			idModuleCluster = mainDay.getModuleCluster().getIdModuleCluster();
			dao.saveModuleExtended(mainDay);
		}else
			foundDayHost = true;

		//TODO
		//Una volta salvati i dati della giornata principale (mainDay) ci si occupa di salvare i moduli che la compongono

		if(!foundDayHost){//In questo caso e' necessario creare un modulo cluster e salvarlo
			ModuleCluster moduleClusterToAdd = new ModuleCluster();
			moduleClusterToAdd.setIdModuleCluster(idModuleCluster);
			moduleClusterToAdd.setIdUser(moduleExtended.getModuleHeader().getIdUser());
			moduleClusterToAdd.setIdModuleType(moduleExtended.getModuleHeader().getIdModuleType());
			moduleExtended.setModuleCluster(moduleClusterToAdd);
		}else
			moduleExtended.setModuleCluster(null);
		
		ArrayList<String> listaTabelle = buildTableNameListToLoad(moduleExtended.getModuleType().getIdModuleType(),Const.UPDATE);
		dao.updateModuleExtended(moduleExtended,listaTabelle);

	}
}
