package it.costanza.LiLo.util;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class ScriptDbCreator {
	//Start date 01-01-1980
	//End date 01-01-2080


	public static void main(String[] args) throws IOException {
		Calendar cal = Calendar.getInstance();
		String day = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		PrintWriter query = new PrintWriter(new BufferedWriter(new FileWriter("DB/calendarInsert.sql", true)));
		for (int i = -5000; i < 3000; i++) {
			cal.setTime(aggiungiTogliGiorno(new Date(), i));
			day = getDayOfTheWeekFromNumber(cal.get(Calendar.DAY_OF_WEEK));

			query.println(
					"INSERT INTO CALENDAR (DATE,DAY_OF_WEEK) VALUES (STR_TO_DATE('"+sdf.format(aggiungiTogliGiorno(new Date(), i))+"', '%Y%m%d'),'"+day+"');");	

		}

	}


	static String getDayOfTheWeekFromNumber(int number){
		String out = "";
		switch (number) {
		case 1:
			out = "SU";
			break;
		case 2:
			out = "MO";
			break;
		case 3:
			out = "TU";
			break;
		case 4:
			out = "WE";
			break;
		case 5:
			out = "TH";
			break;
		case 6:
			out = "FR";
			break;
		case 7:
			out = "SA";
			break;


		}
		return out;

	}


	static Date aggiungiTogliGiorno(Date date,int nGiorni) {
		if(nGiorni != 0){
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.DATE, 1*nGiorni);
			date = calendar.getTime();
		}
		return date;
	}


}
