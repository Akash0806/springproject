package com.pokerbesthand.service;

import com.pokerbesthand.enumconstant.PokerHandType;
import com.pokerbesthand.util.ProkerBestHandConstant;

public class PokerPair implements PokerHandResultProducer {

	

	@Override
	public String resultProducer(Integer faceCounts) {

		String result = ProkerBestHandConstant.EMPTY_STRING;
		switch (faceCounts) {
		case ProkerBestHandConstant.TWO:
			result = PokerHandType.PAIR.toString();
			break;
		case ProkerBestHandConstant.FOUR:
			result = PokerHandType.TWO_PAIR.toString();
			break;
		case ProkerBestHandConstant.THREE:
			result = PokerHandType.THREE_OF_A_KIND.toString();
			break;
		case ProkerBestHandConstant.FIVE:
			result = PokerHandType.FULL_HOUSE.toString();
			break;
		case ProkerBestHandConstant.FOUR_KIND:
			result = PokerHandType.FOUR_OF_A_KIND.toString();
			break;
		default:
			result = PokerHandType.HIGH_CARD.toString();
			break;

		}
		return result;
	}

	
}
