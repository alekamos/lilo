package it.costanza.LiLo.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import it.costanza.LiLo.dao.ListElementDao;
import it.costanza.LiLo.mybatis.bean.ListElement;


import org.junit.Test;

public class ModuleListElementDaoTest {

	@Test
	public void testListElementFinderByUserAndType(){
		ListElement ricercaElementBean = new ListElement();
		ListElementDao dao = new ListElementDao();
		int idUserIniziale = 1;
		String typeIniziale = "LOCALI";
		boolean controlloOk = false;

		//definizione della ricerca
		ricercaElementBean.setIdUser(idUserIniziale);
		ricercaElementBean.setType(typeIniziale);

		//ricerca
		ArrayList<ListElement> le = dao.searchByUserAndType(ricercaElementBean);

		//controllo che tutti gli elementi siano dell'user 1 e
		if(le.size() > 0){
			controlloOk = true;
			for (int i = 0; i < le.size() && controlloOk == true; i++) {
				if(!le.get(i).getIdUser().equals(idUserIniziale) || !le.get(i).getType().equals(typeIniziale))
					controlloOk  = false;
			}
		}

		assertTrue(controlloOk);
	}

	@Test
	public void testListElementFinderByMultipleIn(){
		ListElement ricercaElementBean = new ListElement();
		ListElementDao dao = new ListElementDao();
		boolean controlloOk = false;

		/**
		 * Mi carico tutti gli elementi dell'utente1 e LOCALI
		 */
		int idUserIniziale = 1;
		String typeIniziale = "LOCALI";

		//definizione della ricerca
		ricercaElementBean.setIdUser(idUserIniziale);
		ricercaElementBean.setType(typeIniziale);


		//ricerca
		ArrayList<ListElement> le1 = dao.searchByUserAndType(ricercaElementBean);


		//Mi prendo tutti gli id e faccio una ricerca per id con la clausula IN, i due oggetti devono poi essere uguali

		ArrayList<Integer> listaId = new ArrayList<Integer>();
		for (ListElement element : le1) {
			listaId.add(element.getIdElement());
		}
		ArrayList<ListElement> le2 = dao.searchByMultipleId(listaId);

		if(le1.size() == le2.size()){
			controlloOk = true;
			for (int i = 0; i < le1.size() && controlloOk == true; i++) {
				if(le1.get(i).getIdElement() != le2.get(i).getIdElement())
					controlloOk  = false;
			}
		}
		
		assertTrue(controlloOk);
	}




}
