package it.costanza.LiLo.test;

import static org.junit.Assert.*;

import java.util.Date;


import it.costanza.LiLo.dao.UserDao;
import it.costanza.LiLo.mybatis.bean.User;

import org.junit.BeforeClass;
import org.junit.Test;

public class UserDaoTest {

	private final String nome = "Ermanno";
	private final String cognome = "Baffi";
	private final String password = "password";
	private final String username = "username";
	private final String mail = "abc@hotmail.it";
	static UserDao dao;
	
	
	@BeforeClass
	public static void creaConnessione(){
		dao = new UserDao();
	}
	
	@Test
	public void testUserInsert() {

		//Costruisco
		User utente = new User();
		
		//Trovo una stringa casuale
		String rand = (Math.random()+"").substring(1, 5);

		utente.setName(nome);
		utente.setSurname(cognome);
		utente.setPassword(password);
		utente.setUsername(username+rand);
		utente.setBirthDate(new Date());
		utente.setEmail(mail+rand);

		dao.insert(utente);
		assertTrue(utente.getIdUser()>1);
	}

	@Test
	public void testUserDelete(){
		User utente = new User();
		
		//Trovo una stringa casuale
		String rand = (Math.random()+"").substring(1, 5);

		utente.setName(nome);
		utente.setSurname(cognome);
		utente.setPassword(password);
		utente.setUsername(username+rand);
		utente.setBirthDate(new Date());
		utente.setEmail(mail+rand);

		dao.insert(utente);
		dao.delete(utente.getIdUser());
		User userExtracted = dao.selectById(utente.getIdUser());
		assertTrue(userExtracted == null);
	}

	@Test
	public void testUserSelect(){
		User utente = new User();
		
		//Trovo una stringa casuale
		String rand = (Math.random()+"").substring(1, 5);

		utente.setName(nome);
		utente.setSurname(cognome);
		utente.setPassword(password);
		utente.setUsername(username+rand);
		utente.setBirthDate(new Date());
		utente.setEmail(mail+rand);

		dao.insert(utente);
		User userExtracted = dao.selectById(utente.getIdUser());
		assertTrue(userExtracted.getIdUser().equals(utente.getIdUser()));
	}

	@Test
	public void testUserUpdate(){
		User utente = new User();
		
		String newSurname = "Modified";

		//Trovo una stringa casuale
		String rand = (Math.random()+"").substring(1, 5);

		utente.setName(nome);
		utente.setSurname(cognome);
		utente.setPassword(password);
		utente.setUsername(username+rand);
		utente.setBirthDate(new Date());
		utente.setEmail(mail+rand);

		dao.insert(utente);

		utente.setSurname(newSurname);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		dao.update(utente);
		User userExtracted = dao.selectById(utente.getIdUser());
		assertTrue(userExtracted.getSurname().equals(newSurname) && !userExtracted.getUpdateTimestamp().equals(userExtracted.getInsertTimestamp()));
	}

	@Test
	public void testUserUsernameAndPassword(){
		//Costruisco
		User utente = new User();
		
		//Trovo una stringa casuale
		String rand = (Math.random()+"").substring(1, 5);
		
		//username già completo
		String usernameComplete = username+rand;
		
		//inserimento
		utente.setName(nome);
		utente.setSurname(cognome);
		utente.setPassword(password);
		utente.setUsername(usernameComplete);
		utente.setBirthDate(new Date());
		utente.setEmail(mail+rand);
		dao.insert(utente);
		
		User utenteOk = new User();
		User utenteKo = new User();
		
		//costruisco utente Ok
		utenteOk.setUsername(usernameComplete);
		utenteOk.setPassword(password);
		
		//costruisco utente KO
		utenteKo.setUsername(usernameComplete);
		utenteKo.setPassword(password+"22");
		
		//estrazione userid e password giusta
		utenteOk = dao.searchByUsernameAndPassword(utenteOk);
		//estrazione userid e password sbagliata
		utenteKo = dao.searchByUsernameAndPassword(utenteKo);
		
		//condizione di successo: utenteOk estratto (!= null) utenteKo non estratto (==null)
		assertTrue(utenteOk!=null && utenteKo== null);
	}





}
