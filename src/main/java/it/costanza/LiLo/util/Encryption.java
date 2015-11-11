package it.costanza.LiLo.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;



public class Encryption {

	public static final String DESEDE_ENCRYPTION_SCHEME = "DESede";
	public static final String DES_ENCRYPTION_SCHEME = "DES";
	public static final String DEFAULT_ENCRYPTION_KEY = "This is a fairly long phrase used to encrypt";
	
	
/**
 * Il metodo converte una stringa in HASH
 * @param stringToHash
 * @return
 */
	public static String toMD5(String stringToHash){

		String output = null;
		try {
			// Create MessageDigest instance for MD5
			MessageDigest md = MessageDigest.getInstance("MD5");
			//Add stringToHash bytes to digest
			md.update(stringToHash.getBytes());
			//Get the hash's bytes 
			byte[] bytes = md.digest();
			//This bytes[] has bytes in decimal format;
			//Convert it to hexadecimal format
			StringBuilder sb = new StringBuilder();
			for(int i=0; i< bytes.length ;i++)
			{
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			//Get complete outputin hex format
			output = sb.toString();
		} 
		catch (NoSuchAlgorithmException e) 
		{
			e.printStackTrace();
		}
		return output;
	}

	/**
	 * Il metodo encripta una stringa usando una chiave, 
	 * se la chiave � troppo corta la moltiplica fino ad ottenere 24 caratteri
	 *
	 * @param str
	 * @param resourcemap
	 * @return
	 */
	public static String encrypt(String str, String encryptionKey) {
		try {


			StringEncrypter encrypter =  new StringEncrypter(StringEncrypter.DES_ENCRYPTION_SCHEME, encryptionKey );
			String encryptedString = encrypter.encrypt( str );

			return encryptedString;
		}
		catch (Exception e) {
			e.printStackTrace();
			// do nothing
		}

		return null;
	}

	/**
	 * Il metodo encripta una stringa usando una chiave, 
	 * se la chiave � troppo corta la moltiplica fino ad ottenere 24 caratteri
	 *
	 * @param str
	 * @param resourcemap
	 * @return
	 */
	public static String decrypt(String str, String resourcemap) {
		try {


			StringEncrypter decrypter =  new StringEncrypter(StringEncrypter.DES_ENCRYPTION_SCHEME, resourcemap );
			String decryptedString = decrypter.decrypt(str);

			return decryptedString;
		}
		catch (Exception e) {
			// do nothing
		}

		return null;
	}









}
