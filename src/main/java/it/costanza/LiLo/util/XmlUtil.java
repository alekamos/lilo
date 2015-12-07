package it.costanza.LiLo.util;

import it.costanza.LiLo.bean.ListModuleExtended;
import it.costanza.LiLo.bean.ModuleDayHost;
import it.costanza.LiLo.bean.ModuleExtended;
import it.costanza.LiLo.mybatis.bean.ModuleDatetime;
import it.costanza.LiLo.mybatis.bean.ModuleHeader;
import it.costanza.LiLo.mybatis.bean.ModuleNumeric;
import it.costanza.LiLo.mybatis.bean.ModuleText;
import it.costanza.LiLo.mybatis.bean.User;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;

public class XmlUtil {

	public String marshalling(User user) throws JAXBException, ParseException{
		// Step 1 - Create the Domain Model
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		StringWriter sw = new StringWriter();

		ModuleExtended me = new ModuleExtended();
		ModuleDatetime mdt = new ModuleDatetime();
		ModuleText mt = new ModuleText();
		ModuleHeader mh = new ModuleHeader();
		ModuleDayHost mdh = new ModuleDayHost();
		ModuleNumeric mn = new ModuleNumeric();


		mt.setText1Value("Test Inserimento massivo Stringa1");
		mt.setText2Value("Test Inserimento massivo Stringa2");
		mt.setText3Value("Test Inserimento massivo Stringa3");
		mh.setIdModuleType(12);
		mdh.setDateDayHost(sdf.parse("20151103"));
		mh.setIdUser(user.getIdUser());


		me.setModuleDatetime(mdt);
		me.setModuleText(mt);
		me.setModuleDayHost(mdh);
		me.setModuleHeader(mh);
		me.setModuleNumeric(mn);

		// Step 2 - Convert the Domain Model to XML

		JAXBContext jaxbContext = JAXBContext.newInstance(ModuleExtended.class);

		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		JAXBElement<ModuleExtended> jaxbElement = new JAXBElement<ModuleExtended>(new QName(null, "moduleExtended"), ModuleExtended.class, me);
		marshaller.marshal(jaxbElement, sw);


		return sw.toString();
	}


	public ArrayList<ModuleExtended> unMarshaling2ModuleExtended(String xmlIn) throws JAXBException, IOException
	{
		JAXBContext jaxbContext = JAXBContext.newInstance(ListModuleExtended.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

		//We had written this file in marshalling example
		ListModuleExtended lme = (ListModuleExtended) jaxbUnmarshaller.unmarshal(new ByteArrayInputStream(xmlIn.getBytes()));

				List<ModuleExtended> list = lme.getModuleExtended();

		return (ArrayList<ModuleExtended>) list;


		//Vedi esempio:
		//http://howtodoinjava.com/2013/07/30/jaxb-exmaple-marshalling-and-unmarshalling-list-or-set-of-objects/
	}

}



