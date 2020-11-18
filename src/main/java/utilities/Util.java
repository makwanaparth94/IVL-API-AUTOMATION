package utilities;

import java.util.Random;

import extentreports.ExtentTestManager;

public class Util {
	
	
	public static void setUP_TC_Description(String arg) {
		ExtentTestManager.getTest().setDescription(arg);
	}
	
	
	public static StringBuilder getRandomAlphanumericString() 	// This will pick random string within below mentions ALPHABET
	{
		final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz@_/%+-$#*!()";
		int length=9;
		Random random = new Random();
		StringBuilder randomname = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
				randomname.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
			}
		return randomname;	
	}
	
}
