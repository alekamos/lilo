package it.costanza.LiLo.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "listModuleExtended")
@XmlAccessorType (XmlAccessType.FIELD)
public class ListModuleExtended {



	@XmlElement(name = "moduleExtended")
	private List<ModuleExtended> moduleExtended = null;

	public List<ModuleExtended> getModuleExtended() {
		return moduleExtended;
	}

	public void setModuleExtended(List<ModuleExtended> moduleExtended) {
		this.moduleExtended = moduleExtended;
	}


}


