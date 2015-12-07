package it.costanza.LiLo.test;

import it.costanza.LiLo.util.Utility;

import java.util.Date;

public class dateTest {

	
	
	
	public static void main(String[] args) {
		
		Date dataOdierna = new Date();
		Date data2 = Utility.aggiungiTogliGiorno(dataOdierna, 25);
		
		int calcolaDiffGiorni = Utility.calcolaDiffGiorni(dataOdierna, dataOdierna);
		
		System.out.println(calcolaDiffGiorni);
		
		
	}
}
