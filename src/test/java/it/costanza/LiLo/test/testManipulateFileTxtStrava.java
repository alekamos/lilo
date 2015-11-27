package it.costanza.LiLo.test;

import it.costanza.LiLo.bean.ModuleDayHost;
import it.costanza.LiLo.bean.ModuleExtended;
import it.costanza.LiLo.mybatis.bean.ModuleDatetime;
import it.costanza.LiLo.mybatis.bean.ModuleHeader;
import it.costanza.LiLo.mybatis.bean.ModuleNumeric;
import it.costanza.LiLo.mybatis.bean.ModuleText;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;


public class testManipulateFileTxtStrava {


	public static void main(String[] args) throws IOException, ParseException, JAXBException {


		final String filepath = "cycling/";
		final String fileName = "DatiStrava.dat";
		int count = 0;

		final String semicolon = ";";
		String date = "";
		String desc = "";
		String timeStr = "";
		Double distance = (double) 0;
		Double dislivello = (double) 0;
		String residuo = "";
		
		

		BufferedReader in = new BufferedReader(new FileReader(filepath+fileName));
		String line;
		System.out.println("<listModuleExtended>");
		while((line = in.readLine()) != null)
		{

			//System.out.println("Original "+line);
			date = line.substring(3,line.indexOf(semicolon));
			residuo = line.substring(line.indexOf(semicolon)+1);
			desc = residuo.substring(0,residuo.indexOf(semicolon));
			residuo = residuo.substring(residuo.indexOf(semicolon)+1);
			timeStr = residuo.substring(0,residuo.indexOf(semicolon));			
			
			
			
			residuo = residuo.substring(residuo.indexOf(semicolon)+1);
			distance = Double.parseDouble(residuo.substring(0,residuo.indexOf(semicolon)));
			residuo = residuo.substring(residuo.indexOf(semicolon)+1);
			dislivello = Double.parseDouble(residuo.substring(0,residuo.indexOf(semicolon)));
			/*
			System.out.println("Date :\t"+date);
			System.out.println("Desc :\t"+desc);
			System.out.println("Time :\t"+timeStr);
			System.out.println("Distance :\t"+distance);
			System.out.println("Dislivello :\t"+dislivello);
			*/
			SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
			Date time = sdf.parse(timeStr);
			SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
			Date data = sdf2.parse(date);
			

//			riga xml
			
			ModuleExtended me = new ModuleExtended();
			ModuleDatetime mdt = new ModuleDatetime();
			ModuleText mt = new ModuleText();
			ModuleHeader mh = new ModuleHeader();
			ModuleDayHost mdh = new ModuleDayHost();
			ModuleNumeric mn = new ModuleNumeric();


			mt.setText1Value(desc);
			mh.setIdModuleType(12);
			mdh.setDateDayHost(data);
			mh.setIdUser(41);
			mdt.setDatetime1Value(time);
			mn.setNumericData1Value(distance);
			mn.setNumericData2Value(dislivello);
			


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
			
			
			marshaller.marshal(jaxbElement, System.out);
			
			

		}
		System.out.println("</listModuleExtended>");
		in.close();




	}
}
