package com.hiveit.pe.eai.encryptdecrypt.util;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

import java.util.Base64;


public class TripleDESEncryption {

//	private static Logger logger =  Logger.getLogger(TripleDESEncryption.class);
	
	public static DESedeKeySpec generateKey() throws NoSuchAlgorithmException,
			InvalidKeySpecException {
		KeyGenerator keygen = KeyGenerator.getInstance(Constantes.DE_SEDE);
		
		SecretKeyFactory keyfactory = SecretKeyFactory.getInstance(Constantes.DE_SEDE);

		return (DESedeKeySpec) keyfactory.getKeySpec(keygen.generateKey(),
				DESedeKeySpec.class);
	}

	public static DESedeKeySpec loadKey(byte[] rawKey)
			throws InvalidKeyException {
		return new DESedeKeySpec(rawKey);
	}

	
	public static String encrypt(String clearText, DESedeKeySpec keySpec)
			throws NoSuchAlgorithmException, InvalidKeySpecException,
			NoSuchPaddingException, InvalidKeyException,
			IllegalBlockSizeException, BadPaddingException {

		String cipherTextB64 = null;
		SecretKeyFactory keyfactory = SecretKeyFactory.getInstance(Constantes.DE_SEDE);
		SecretKey key = keyfactory.generateSecret(keySpec);
		
		Cipher cipher = Cipher.getInstance(Constantes.DE_SEDE);
		
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] cipherText = cipher.doFinal(clearText.getBytes());
		
		Base64.Encoder base64encoder = Base64.getEncoder().withoutPadding();
		cipherTextB64 = base64encoder.encodeToString(cipherText);
		
		return cipherTextB64;
	}
	
	public static String decrypt(String cipherTextB64, DESedeKeySpec keySpec)
			throws NoSuchAlgorithmException, InvalidKeySpecException,
			NoSuchPaddingException, InvalidKeyException,
			IllegalBlockSizeException, BadPaddingException, IOException {
//		logger.info( "[---------------- Inicio de decrypt   ----------------]");	
		String clearText = null;
		SecretKeyFactory keyfactory = SecretKeyFactory.getInstance(Constantes.DE_SEDE);
		SecretKey key = keyfactory.generateSecret(keySpec);
		
		Cipher cipher = Cipher.getInstance(Constantes.DE_SEDE);
		
		byte[] cipherText = Base64.getDecoder().decode(cipherTextB64);
		
		cipher.init(Cipher.DECRYPT_MODE, key);
		byte[] bclearText = cipher.doFinal(cipherText);
		clearText = new String(bclearText);

		return clearText;
	}

}
