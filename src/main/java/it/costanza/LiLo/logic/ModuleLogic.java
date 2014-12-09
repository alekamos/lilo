/**
 * 
 */
package it.costanza.LiLo.logic;

import it.costanza.LiLo.dao.ModuleTypeDao;
import it.costanza.LiLo.mybatis.bean.ModuleType;
import it.costanza.LiLo.mybatis.bean.User;
import it.costanza.LiLo.util.Const;
import it.costanza.LiLo.util.Utility;

import java.util.ArrayList;

/**
 * @author costanza
 *La classe contiene i metodi e l'intelligenza per gestire i moduli
 */
public class ModuleLogic {

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
	 * In futuro se serve, si può mettere qui il fatto di rendere null i campi con stringa vuota.
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






}
