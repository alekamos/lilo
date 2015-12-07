package it.costanza.LiLo.test;
import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import it.costanza.LiLo.action.ModuleAction;
import it.costanza.LiLo.bean.ListModuleExtended;
import it.costanza.LiLo.bean.ModuleDayHost;
import it.costanza.LiLo.bean.ModuleExtended;
import it.costanza.LiLo.logic.ModuleLogic;
import it.costanza.LiLo.mybatis.bean.ModuleDatetime;
import it.costanza.LiLo.mybatis.bean.ModuleHeader;
import it.costanza.LiLo.mybatis.bean.ModuleNumeric;
import it.costanza.LiLo.mybatis.bean.ModuleText;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;

public class XmlTest {

	private static void unMarshalingExample() throws JAXBException
	{
		JAXBContext jaxbContext = JAXBContext.newInstance(ListModuleExtended.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

		//We had written this file in marshalling example
		ListModuleExtended lme = (ListModuleExtended) jaxbUnmarshaller.unmarshal( new File("E:/temp/emp.xml") );

		List<ModuleExtended> list = lme.getModuleExtended();

		for (ModuleExtended moduleExtended : list) {
			System.out.println(moduleExtended);
		}


		//Vedi esempio:
		//http://howtodoinjava.com/2013/07/30/jaxb-exmaple-marshalling-and-unmarshalling-list-or-set-of-objects/
	}


	private static void marshallingExample() throws ParseException, JAXBException{
		// Step 1 - Create the Domain Model
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

		ModuleExtended me = new ModuleExtended();
		ModuleDatetime mdt = new ModuleDatetime();
		ModuleText mt = new ModuleText();
		ModuleHeader mh = new ModuleHeader();
		ModuleDayHost mdh = new ModuleDayHost();
		ModuleNumeric mn = new ModuleNumeric();


		mt.setText1Value("test inserimento remoto");
		mh.setIdModuleType(12);
		mdh.setDateDayHost(sdf.parse("20151103"));
		mh.setIdUser(41);


		me.setModuleDatetime(mdt);
		me.setModuleText(mt);
		me.setModuleDayHost(mdh);
		me.setModuleHeader(mh);

		// Step 2 - Convert the Domain Model to XML

		JAXBContext jaxbContext = JAXBContext.newInstance(ModuleExtended.class);

		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		JAXBElement<ModuleExtended> jaxbElement = new JAXBElement<ModuleExtended>(new QName(null, "moduleExtended"), ModuleExtended.class, me);
		marshaller.marshal(jaxbElement, System.out);

	}




	public static void main(String[] args) throws JAXBException, ParseException {

		unMarshalingExample();
		//marshallingExample();


	}
}




