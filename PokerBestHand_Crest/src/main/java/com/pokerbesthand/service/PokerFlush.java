package com.pokerbesthand.service;

import com.pokerbesthand.enumconstant.PokerHandType;

public class PokerFlush implements PokerHandResultProducer  {

	@Override
	public String resultProducer(Integer faceCount) {
		return PokerHandType.FLUSH.toString();
	}

}
