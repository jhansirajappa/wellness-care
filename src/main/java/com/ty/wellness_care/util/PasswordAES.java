package com.ty.wellness_care.util;


import java.security.Key;

import javax.crypto.spec.SecretKeySpec;

import  org.apache.commons.codec.binary.Base64;

public class PasswordAES {

	private static final String ALGORITHM ="AES";
	private static final byte[] keyValue= "1234567891234567".getBytes();
	
	private static Key generateKey() {
		Key key=new SecretKeySpec(keyValue, ALGORITHM);
		return key;
	}
	public static String encrypt(String valueToEnc, Key key) throws Exception {
		 
	       
	       Cipher cipher = Cipher.getInstance(ALGORITHM);
	       cipher.init(Cipher.ENCRYPT_MODE, key);
	 
	       byte[] encValue = cipher.doFinal(valueToEnc.getBytes());
	       byte[] encryptedByteValue = new Base64().encode(encValue);
	       System.out.println("Encrypted Value :: " + new String(encryptedByteValue));
	 
	       return new String(encryptedByteValue);
	   }
}