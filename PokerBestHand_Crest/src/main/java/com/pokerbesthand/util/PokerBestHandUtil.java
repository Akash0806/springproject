package com.pokerbesthand.util;

public class PokerBestHandUtil {
	
	public static Integer getInputArrayLength(String[] elementArray) {
		return elementArray.length;
	}

	public static int getStringLength() {
		return ProkerBestHandConstant.FACES.length();
	}
	
	public static int getPositionOfCharacter(String userCardInputs, String source, Integer position) {
		return source.indexOf(userCardInputs.charAt(position));
	}
		

}
