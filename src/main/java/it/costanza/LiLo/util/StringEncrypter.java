package it.costanza.LiLo.util;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.KeySpec;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.DESedeKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * This class can be used to encrypt and decrypt using DES and a given key
 *
 * @author Javid Jamae
 * @see http://www.devx.com/Java/10MinuteSolution/21385/0/page/1
 */

public class StringEncrypter {

	public static final String DESEDE_ENCRYPTION_SCHEME = "DESede";
	public static final String DES_ENCRYPTION_SCHEME = "DES";
	public static final String DEFAULT_ENCRYPTION_KEY = "This is a fairly long phrase used to encrypt";
	private final Charset UTF8_CHARSET = Charset.forName("UTF-8");


	private KeySpec                    keySpec;
	private SecretKeyFactory     	   keyFactory;
	private Cipher                    cipher;

	private static final String     UNICODE_FORMAT               = "UTF8";

	public StringEncrypter( String encryptionScheme ) throws EncryptionException
	{
		this( encryptionScheme, DES_ENCRYPTION_SCHEME );
	}

	/**
	 * costruttore
	 * @param encryptionScheme
	 * @param encryptionKey
	 * @throws EncryptionException
	 */
	public StringEncrypter( String encryptionScheme, String encryptionKey )
			throws EncryptionException
			{

		if ( encryptionKey == null )
			throw new IllegalArgumentException( "encryption key was null" );
		if ( encryptionKey.trim().length() < 24 )
			throw new IllegalArgumentException(
					"encryption key was less than 24 characters" );

		try
		{
			byte[] keyAsBytes = encryptionKey.getBytes( UNICODE_FORMAT );

			if ( encryptionScheme.equals( DESEDE_ENCRYPTION_SCHEME) )
			{
				keySpec = new DESedeKeySpec( keyAsBytes );
			}
			else if ( encryptionScheme.equals( DES_ENCRYPTION_SCHEME ) )
			{
				keySpec = new DESKeySpec( keyAsBytes );
			}
			else
			{
				throw new IllegalArgumentException( "Encryption scheme not supported: "
						+ encryptionScheme );
			}

			keyFactory = SecretKeyFactory.getInstance( encryptionScheme );
			cipher = Cipher.getInstance( encryptionScheme );

		}
		catch (InvalidKeyException e)
		{
			throw new EncryptionException( e );
		}
		catch (UnsupportedEncodingException e)
		{
			throw new EncryptionException( e );
		}
		catch (NoSuchAlgorithmException e)
		{
			throw new EncryptionException( e );
		}
		catch (NoSuchPaddingException e)
		{
			throw new EncryptionException( e );
		}

			}

	
	/**
	 * Il metodo encripta una stringa utilizzando una chiave
	 * @param unencryptedString
	 * @return
	 * @throws EncryptionException
	 */
	public String encrypt( String unencryptedString ) throws EncryptionException
	{
		if ( unencryptedString == null || unencryptedString.trim().length() == 0 )
			throw new IllegalArgumentException(
					"unencrypted string was null or empty" );

		try
		{
			SecretKey key = keyFactory.generateSecret( keySpec );
			cipher.init( Cipher.ENCRYPT_MODE, key );
			byte[] cleartext = unencryptedString.getBytes( UNICODE_FORMAT );
			byte[] ciphertext = cipher.doFinal( cleartext );

			BASE64Encoder base64encoder = new BASE64Encoder();
			return  base64encoder.encode( ciphertext );

		}
		catch (Exception e)
		{
			throw new EncryptionException( e );
		}
	}

	
	/**
	 * Il metodo decripta utilizando una stringa
	 * @param encryptedString
	 * @return
	 * @throws EncryptionException
	 */
	public String decrypt( String encryptedString ) throws EncryptionException
	{
		if ( encryptedString == null || encryptedString.trim().length() <= 0 )
			throw new IllegalArgumentException( "encrypted string was null or empty" );

		try
		{
			SecretKey key = keyFactory.generateSecret( keySpec );
			cipher.init( Cipher.DECRYPT_MODE, key );
			BASE64Decoder base64decoder = new BASE64Decoder();
			byte[] cleartext = base64decoder.decodeBuffer( encryptedString );
			byte[] ciphertext = cipher.doFinal( cleartext );

			return decodeUTF8( ciphertext );
		}
		catch (Exception e)
		{
			throw new EncryptionException( e );
		}
	}

	/**
	 * Metodo che converte un bitearray in string (problemi sulla codifica UTF8)
	 * @param bytes
	 * @return
	 */
	private static String bytes2String( byte[] bytes )
	{
		StringBuffer stringBuffer = new StringBuffer();
		String s = new String();


		for (int i = 0; i < bytes.length; i++)
		{
			stringBuffer.append( (char) bytes[i] );
		}
		return stringBuffer.toString();
	}


/**
 * Metodo che converte un bitearray in string (UTF8 safe)
 * @param bytes
 * @return
 */
	private String decodeUTF8(byte[] bytes) {
		return new String(bytes, UTF8_CHARSET);
	}




	@SuppressWarnings("serial")
	public static class EncryptionException extends Exception
	{
		public EncryptionException( Throwable t )
		{
			super( t );
		}
	}
}
