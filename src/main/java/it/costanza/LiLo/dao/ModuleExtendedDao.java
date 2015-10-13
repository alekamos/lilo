package it.costanza.LiLo.dao;

import it.costanza.LiLo.bean.ModuleExtended;
import it.costanza.LiLo.bean.ModuleListExtended;
import it.costanza.LiLo.mybatis.bean.ListElement;
import it.costanza.LiLo.mybatis.bean.ModuleList;
import it.costanza.LiLo.util.Const;

import java.util.ArrayList;


public class ModuleExtendedDao{

	/**
	 * DA UTILIZZARE PER IL CARICAMENTO ACCOPPIATO CON UN METODO DI LOGICA(creazione delle liste da caricare)
	 * Caricamento di un modulo a fronte di un idModulo e una lista di tabelle da caricare
	 * @param idModule
	 * @param tabelleDaCaricare
	 * @return
	 */
	
	
	public ModuleExtended getModuleExtended(Integer idModule, ArrayList<String> tabelleDaCaricare){

		ModuleExtended outModule = new ModuleExtended();

		for (String tabella : tabelleDaCaricare) {
			switch (tabella) {
			case Const.MODULE_HEADER:
				ModuleHeaderDao headerDao = new ModuleHeaderDao();
				outModule.setModuleHeader(headerDao.selectById(idModule));
				break;
			
			case Const.MODULES_CLUSTER:
				ModuleClusterDao clusterDao = new ModuleClusterDao();
				outModule.setModuleCluster(clusterDao.searchByIdModule(idModule));
				break;
			
			case Const.MODULES_DATETIME:
				ModuleDatetimeDao datetimeDao = new ModuleDatetimeDao();
				outModule.setModuleDatetime(datetimeDao.selectById(idModule));
				break;

			case Const.MODULES_TEXT:
				ModuleTextDao textDao = new ModuleTextDao();
				outModule.setModuleText(textDao.selectById(idModule));
				break;

			case Const.MODULES_NUMERIC_DATA:
				ModuleNumericDao numericDao = new ModuleNumericDao();
				outModule.setModuleNumeric(numericDao.selectById(idModule));
				break;
			case Const.MODULES_LIST:
				ModuleListDao moduleListdao = new ModuleListDao();
				ListElementDao listElementdao = new ListElementDao();
				ArrayList<ModuleListExtended> moduleListExtendedList = new ArrayList<ModuleListExtended>();
				/**ho caricato la lista dei moduliList ogni riga ha un idElement ed un idContent(1,2,3)*/
				ArrayList<ModuleList> listaModuliList = moduleListdao.selectListByIdModule(idModule);
				for (int idContentPrecedente = 0; idContentPrecedente < 3; idContentPrecedente++) {
					ArrayList<Integer> listaIdElement = new ArrayList<Integer>();
					/** gira finochè non cè spaccatura di idContent */
					for (int i = 0; i < listaModuliList.size() && listaModuliList.get(i).getIdListContent()==idContentPrecedente; i++) {
						listaIdElement.add(listaModuliList.get(i).getIdElement());
					}
					/**
					 * Quando l'ho riempita tutti gli idElement di quel idContent(1,2,3) carico l'oggetto
					 * id module e tutto l'array di ListElement
					 */
					ModuleListExtended mle = new ModuleListExtended();
					mle.setIdListContent(idContentPrecedente);
					mle.setListaElementi(listElementdao.searchByMultipleId(listaIdElement));
					moduleListExtendedList.add(mle);
				}
				outModule.setModuleListExtended(moduleListExtendedList);
				break;
			}

		}
		return outModule;
	}


	/**
	 * DA UTILIZZARE PER IL SALVATAGGIO ACCOPPIATO CON UN METODO DI LOGICA(arricchimento dei dati,
	 * annullamento delle tabelle non utilizzate, generazione del cluster se gia esistenti)
	 * Salvataggio di un modulo extended in tutte le sue tabelle, se un campo interno e null non verrà salvato
	 * @param idModule
	 * @param tabelleDaCaricare
	 * @return idModule appena salvato
	 */
	public Integer saveModuleExtended(ModuleExtended me){
		int idModule = 0;
		if (me.getModuleHeader()!=null) {
			ModuleHeaderDao dao = new ModuleHeaderDao();
			dao.insert(me.getModuleHeader());
			idModule = me.getModuleHeader().getIdModule();
		}
		if (me.getModuleCluster()!=null) {
			ModuleClusterDao dao = new ModuleClusterDao();
			me.getModuleCluster().setIdModule(idModule);
			dao.insert(me.getModuleCluster());
		}
		if (me.getModuleDatetime()!=null) {
			ModuleDatetimeDao dao = new ModuleDatetimeDao();
			me.getModuleDatetime().setIdModule(idModule);
			dao.insert(me.getModuleDatetime());
		}
		if (me.getModuleText()!=null) {
			ModuleTextDao dao = new ModuleTextDao();
			me.getModuleText().setIdModule(idModule);
			dao.insert(me.getModuleText());
		}
		if (me.getModuleNumeric()!=null) {
			ModuleNumericDao dao = new ModuleNumericDao();
			me.getModuleNumeric().setIdModule(idModule);
			dao.insert(me.getModuleNumeric());
		}
		if(me.getModuleListExtended()!= null && me.getModuleListExtended().size()>0){
			ModuleListDao dao = new ModuleListDao();
			for (ModuleListExtended mle : me.getModuleListExtended()) {
				for (ListElement le : mle.getListaElementi()) {
					ModuleList ml = new ModuleList();
					ml.setIdElement(le.getIdElement());
					ml.setIdListContent(mle.getIdListContent());
					ml.setIdModule(idModule);
					dao.insert(ml);
				}
			}
		}


		return idModule;

	}


/**
 * UPDATE modulo.
 * Il modulo viene aggiornato nelle sole componenti modificate
 * @param me
 * @return
 */
	public int updateModuleExtended(ModuleExtended me) {
		int idModule = 0;
		if (me.getModuleHeader()!=null) {
			ModuleHeaderDao dao = new ModuleHeaderDao();
			dao.insert(me.getModuleHeader());
			idModule = me.getModuleHeader().getIdModule();
		}
		if (me.getModuleCluster()!=null) {
			ModuleClusterDao dao = new ModuleClusterDao();
			me.getModuleCluster().setIdModule(idModule);
			dao.insert(me.getModuleCluster());
		}
		if (me.getModuleDatetime()!=null) {
			ModuleDatetimeDao dao = new ModuleDatetimeDao();
			me.getModuleDatetime().setIdModule(idModule);
			dao.insert(me.getModuleDatetime());
		}
		if (me.getModuleText()!=null) {
			ModuleTextDao dao = new ModuleTextDao();
			me.getModuleText().setIdModule(idModule);
			dao.insert(me.getModuleText());
		}
		if (me.getModuleNumeric()!=null) {
			ModuleNumericDao dao = new ModuleNumericDao();
			me.getModuleNumeric().setIdModule(idModule);
			dao.insert(me.getModuleNumeric());
		}
		if(me.getModuleListExtended()!= null && me.getModuleListExtended().size()>0){
			ModuleListDao dao = new ModuleListDao();
			for (ModuleListExtended mle : me.getModuleListExtended()) {
				for (ListElement le : mle.getListaElementi()) {
					ModuleList ml = new ModuleList();
					ml.setIdElement(le.getIdElement());
					ml.setIdListContent(mle.getIdListContent());
					ml.setIdModule(idModule);
					dao.insert(ml);
				}
			}
		}


		return idModule;

	}


}




