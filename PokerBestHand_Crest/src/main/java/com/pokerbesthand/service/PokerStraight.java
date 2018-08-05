package com.pokerbesthand.service;

import com.pokerbesthand.enumconstant.PokerHandType;

public class PokerStraight implements PokerHandResultProducer {

	@Override
	public String resultProducer(Integer faceCount) {
		 return PokerHandType.STRAIGHT.toString();
	}

}
