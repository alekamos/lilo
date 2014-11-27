/**
 * 
 */
package it.costanza.LiLo.logic;

import it.costanza.LiLo.dao.ModuleTypeDao;
import it.costanza.LiLo.mybatis.bean.ModuleType;
import it.costanza.LiLo.util.Const;

import java.util.ArrayList;

/**
 * @author costanza
 *La classe contiene i metodi e l'intelligenza per gestire i moduli
 */
public class ModuleLogic {

	/**
	 * Crea un arraylist con la lista di tabelle che il metodo getModuleExtended deve caricare.
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




}
