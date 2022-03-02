package com.ty.wellness_care.util;

public class Demo {
	public static void main(String[] args) {

		// Create String variables
		String originalString = "Pradeepa";

		// Call encryption method
		String encryptedString = PasswordAES.encrypt(originalString);

		// Call decryption method
		String decryptedString = PasswordAES.decrypt(encryptedString);

		// Print all strings
		System.out.println(originalString);
		System.out.println(encryptedString);
		System.out.println(decryptedString);

	}
	
}