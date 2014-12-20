/**
 * 
 */
package it.costanza.LiLo.logic;

import it.costanza.LiLo.bean.ModuleExtended;
import it.costanza.LiLo.dao.ModuleClusterDao;
import it.costanza.LiLo.dao.ModuleExtendedDao;
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
	public ArrayList<String> creaListaModuliDaCaricare(Integer idModuleType){
		ArrayList<String> listaTabelle = new ArrayList<String>();
		ModuleTypeDao dao = new ModuleTypeDao();
		ModuleType mt = dao.selectById(idModuleType);
		//Controllo sui testi
		if(mt.getTextContent1Name()!=null || mt.getTextContent2Name()!=null || mt.getTextContent3Name()!=null)
			listaTabelle.add(Const.MODULES_TEXT);
		//Controllo sulle date
		if(mt.getDatetimeContent1Name()!=null)
			listaTabelle.add(Const.MODULES_DATETIME);
		//Controllo sulle liste
		if(mt.getListContent1Name()!=null)
			listaTabelle.add(Const.MODULES_LIST);
		//Controllo sui dati numerici
		if(mt.getNumericDataContent1Name()!=null)
			listaTabelle.add(Const.MODULES_NUMERIC_DATA);
		return listaTabelle;

	}

	/**
	 * Carica i moduli type proprietari dell'utente
	 * @param user
	 * @return
	 */
	public ArrayList<ModuleType> getListaModuliTypeUtente(User user){

		ModuleTypeDao dao = new ModuleTypeDao();
		ArrayList<ModuleType> moduliTypeList = dao.searchByUserId(user.getIdUser());

		return moduliTypeList;

	}

	/**
	 * Carica i moduli di default utilizzando i moduli dichiarati nella costante: Const.ARRAY_MODULI_DEFAULT
	 * @param moduleTypeList 
	 * @return
	 */
	public ArrayList<ModuleType> getModuliDefault(ArrayList<ModuleType> moduleTypeList) {
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
	public void salvaModuloType(ModuleType moduleType) {
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
	public ModuleType normalizzaCampi(ModuleType moduleType) {

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
	 * Carica il modulo type invocando il dao
	 * @param moduleType
	 * @return
	 */
	public ModuleType getModuleType(ModuleType moduleTypeIn) {
		ModuleTypeDao dao = new ModuleTypeDao();	
		ModuleType moduleTypeOut = dao.selectById(moduleTypeIn.getIdModuleType());
		return moduleTypeOut;
	}


	public int checkIfDateExistYet(ModuleExtended moduleExtendedIn){
		ModuleClusterDao dao = new ModuleClusterDao();
		ModuleExtended moduleExtendedProbe = moduleExtendedIn;
		moduleExtendedProbe.getModuleHeader().setIdModule(Const.ID_MAIN_DAY_MODULE);
		int idModuleCluster = dao.searchIfExistClusterYet(moduleExtendedProbe);
		return idModuleCluster;
	}

	public ModuleExtended creaModuleExtenderPerMainDay(ModuleExtended moduleExtended){

		ModuleClusterDao daoCluster = new ModuleClusterDao();
		int idModuleCluster = daoCluster.searchMaxIdCluster();


		ModuleExtended moduleMainDay = new ModuleExtended();
		ModuleHeader moduleHeaderMainDay = new ModuleHeader();
		moduleHeaderMainDay.setIdUser(moduleExtended.getModuleHeader().getIdUser());
		moduleHeaderMainDay.setIdModuleType(Const.ID_MAIN_DAY_MODULE);
		moduleMainDay.setModuleHeader(moduleHeaderMainDay);


		ModuleCluster moduleClusterMainDay = new ModuleCluster();
		moduleClusterMainDay.setIdModuleType(Const.ID_MAIN_DAY_MODULE);
		moduleClusterMainDay.setIdUser(moduleExtended.getModuleHeader().getIdUser());
		moduleClusterMainDay.setIdModuleCluster(idModuleCluster);
		moduleMainDay.setModuleCluster(moduleClusterMainDay);

		ModuleDatetime moduleDatetimeMainDay = new ModuleDatetime();
		moduleDatetimeMainDay.setDatetime1Value(moduleExtended.getDataMainDay());
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
	public void salvaModuloExtended(ModuleExtended moduleExtended) {

		ModuleExtendedDao dao = new ModuleExtendedDao();
		int idModuleCluster = checkIfDateExistYet(moduleExtended);
		//Vuol dire che non cè un cluster
		if(idModuleCluster == 0){
			ModuleExtended mainDay = creaModuleExtenderPerMainDay(moduleExtended);
			idModuleCluster = mainDay.getModuleCluster().getIdModuleCluster();
			dao.saveModuleExtended(mainDay);
			
		}

		//Una volta salvati i dati della giornata principale (mainDay) ci si occupa di salvare la giornata
		ModuleCluster moduleClusterToAdd = new ModuleCluster();
		moduleClusterToAdd.setIdModuleCluster(idModuleCluster);
		moduleClusterToAdd.setIdUser(moduleExtended.getModuleHeader().getIdUser());
		moduleExtended.setModuleCluster(moduleClusterToAdd);
		dao.saveModuleExtended(moduleExtended);

	}






}
