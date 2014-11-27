package it.costanza.LiLo.bean;

import java.util.ArrayList;

import it.costanza.LiLo.mybatis.bean.ListElement;

public class ModuleListExtended {

	private int idListContent;
	private ArrayList<ListElement> listaElementi;

	public ArrayList<ListElement> getListaElementi() {
		return listaElementi;
	}
	public void setListaElementi(ArrayList<ListElement> listaElementi) {
		this.listaElementi = listaElementi;
	}
	public int getIdListContent() {
		return idListContent;
	}
	public void setIdListContent(int idListContent) {
		this.idListContent = idListContent;
	}




}