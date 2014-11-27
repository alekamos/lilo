package it.costanza.LiLo.bean;




import java.util.ArrayList;

import it.costanza.LiLo.mybatis.bean.ModuleCluster;
import it.costanza.LiLo.mybatis.bean.ModuleDatetime;
import it.costanza.LiLo.mybatis.bean.ModuleHeader;
import it.costanza.LiLo.mybatis.bean.ModuleNumeric;
import it.costanza.LiLo.mybatis.bean.ModuleText;
import it.costanza.LiLo.mybatis.bean.ModuleType;

public class ModuleExtended {

	private ModuleHeader moduleHeader;
	private ModuleDatetime moduleDatetime;
	private ModuleText moduleText;
	private ModuleNumeric moduleNumeric;
	private ModuleType moduleType;
	private ModuleCluster moduleCluster;
	private ArrayList<ModuleListExtended> moduleListExtended;

	public ModuleHeader getModuleHeader() {
		return moduleHeader;
	}
	public void setModuleHeader(ModuleHeader moduleHeader) {
		this.moduleHeader = moduleHeader;
	}
	public ModuleDatetime getModuleDatetime() {
		return moduleDatetime;
	}
	public void setModuleDatetime(ModuleDatetime moduleDatetime) {
		this.moduleDatetime = moduleDatetime;
	}
	public ModuleText getModuleText() {
		return moduleText;
	}
	public void setModuleText(ModuleText moduleText) {
		this.moduleText = moduleText;
	}
	public ModuleNumeric getModuleNumeric() {
		return moduleNumeric;
	}
	public void setModuleNumeric(ModuleNumeric moduleNumeric) {
		this.moduleNumeric = moduleNumeric;
	}
	public ModuleType getModuleType() {
		return moduleType;
	}
	public void setModuleType(ModuleType moduleType) {
		this.moduleType = moduleType;
	}
	public ArrayList<ModuleListExtended> getModuleListExtended() {
		return moduleListExtended;
	}
	public void setModuleListExtended(ArrayList<ModuleListExtended> moduleListExtended) {
		this.moduleListExtended = moduleListExtended;
	}
	public ModuleCluster getModuleCluster() {
		return moduleCluster;
	}
	public void setModuleCluster(ModuleCluster moduleCluster) {
		this.moduleCluster = moduleCluster;
	}
	
	
}
