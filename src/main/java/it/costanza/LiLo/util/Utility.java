package it.costanza.LiLo.util;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;



public class Utility {


	/**
	 * Il metodo aggiunge o toglie n giorni, se il ngiorno ha il segno '+' aggiunge se '-' toglie.
	 * @param date
	 * @param nSettimane
	 * @return
	 */
	public static Date aggiungiTogliGiorno(Date date,int nGiorni) {
		if(nGiorni != 0){
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.DATE, 1*nGiorni);
			date = calendar.getTime();
		}
		return date;
	}



	/**
	 * Il metodo aggiunge all'ora la data della giornata
	 * @param data
	 * @param ora
	 * @return
	 */
	public static Date aggiungiDataAdOra(Date data, Date ora) {

		DateTime dataDt = new DateTime(data);
		DateTime oraDt = new DateTime(ora);

		LocalDate localDate = dataDt.toLocalDate();
		LocalTime localTime = oraDt.toLocalTime();
		DateTimeZone zone = DateTimeZone.forID("Europe/Rome");
		DateTime res = localDate.toDateTime(localTime, zone);
		Date output = res.toDate();
		return output;
	}

	/**
	 * Il metodo prende in input delle stringhe e le formatta in modo leggibile e chiaro in questo modo
	 * [NomeCampo : valore]
	 */
	public static String toStringPerBean(ArrayList<String> chiavi,ArrayList<String> valori){
		String out = "\n";
		for (int i = 0; i < chiavi.size(); i++) {
			if(valori.get(i)==null)
				out += "["+ chiavi.get(i) + " : " + "{NULL STRING}" + "}]\n";
			else if (valori.get(i).equals("")) 
				out += "["+ chiavi.get(i) + " : " + "{EMPTY STRING}" + "]\n";	
			else
				out += "["+ chiavi.get(i) + " : {" + valori.get(i) + "}]\n";
		}

		return out;
	}

	/**
	 * 
	 * isEmpty se  nulla
	 * isEmpty se  vuota
	 * @param string
	 * @return
	 */
	public static boolean isEmpty(String string){

		if(string!=null && !string.equals(""))
			return false;
		else
			return true;

	}


	/**
	 * Il metodo calcola la differenza in giorni tra due date
	 * @param dateStart
	 * @param dateDayHost
	 * @return
	 */
	public static int calcolaDiffGiorni(Date dateStart, Date dateEnd) {


		long diffInMillies = dateEnd.getTime() - dateStart.getTime();
		Double ris = (double) (diffInMillies/(1000*60*60*24));
		return ris.intValue();
	}






}
