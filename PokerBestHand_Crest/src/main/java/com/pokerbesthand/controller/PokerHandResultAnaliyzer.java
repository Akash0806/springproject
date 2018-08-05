package com.pokerbesthand.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.pokerbesthand.service.PokerFlush;
import com.pokerbesthand.service.PokerHandResultProducer;
import com.pokerbesthand.service.PokerPair;
import com.pokerbesthand.service.PokerStraight;
import com.pokerbesthand.util.PokerBestHandUtil;
import com.pokerbesthand.util.ProkerBestHandConstant;
import com.pokerbesthand.validator.ProkerBestHandValidatior;
import com.pokerbesthand.validator.ProkerBestHandValidatiorImpl;

public class PokerHandResultAnaliyzer {

	ProkerBestHandValidatior prokerBestHandValidatior = new ProkerBestHandValidatiorImpl();

	PokerHandResultProducer pokerHandResultProducer;

	public PokerHandResultAnaliyzer() {

	}

	@SuppressWarnings("rawtypes")
	public String pokerBestHandResultAnaliyzer(String inputCard) {
		String inputCards[] = inputCard.split(ProkerBestHandConstant.REGEX_EMPTY_STRING);
		String isErrorMsgPresnt = prokerBestHandValidatior.validation(inputCards);
		if (isErrorMsgPresnt.isEmpty()) {
				Map faceCount_StragihtAndFlushMap = getFaceCountAndStraightFlushResult(inputCards);
				int[] faceCount = (int[]) faceCount_StragihtAndFlushMap.get(ProkerBestHandConstant.FACE_COUNT);
				int total = getPokerRankCount(faceCount);
				pokerHandResultProducer = new PokerPair();
				if ((Boolean) faceCount_StragihtAndFlushMap.get(ProkerBestHandConstant.IS_FLUSH)) {
					pokerHandResultProducer = new PokerFlush();
				} else if ((Boolean) faceCount_StragihtAndFlushMap.get(ProkerBestHandConstant.IS_STRAIGHT)) {
					pokerHandResultProducer = new PokerStraight();
				}

				String bestPokerHand  = pokerHandResultProducer.resultProducer(total);
				return bestPokerHand;
			}

		
		return isErrorMsgPresnt;
	}

	/** Below Method are used to identify the Flush,Straight and other pairs */

	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected Map getFaceCountAndStraightFlushResult(String[] inputCards) {
		long straight = 0;
		Map rankResultMap = new HashMap<>();
		Set<Character> flushSet = new HashSet<Character>();
		int[] faceCount = new int[PokerBestHandUtil.getStringLength()];
		for (String cards : inputCards) {
			flushSet.add(cards.charAt(0));
			Integer rankIndex = PokerBestHandUtil.getPositionOfCharacter(cards, ProkerBestHandConstant.FACES,
					ProkerBestHandConstant.ONE);
			straight |= (1 << rankIndex);
			faceCount[rankIndex]++;
		}
		// shift the bit pattern to the right as far as possible
		while (straight % 2 == 0) {
			straight >>= 1;
		}
		// straight is 00011111; A-2-3-4-5 is 1111000000001
		boolean isStraight = straight == 0b11111 || straight == 0b1111000000001;
		rankResultMap.put(ProkerBestHandConstant.FACE_COUNT, faceCount);
		rankResultMap.put(ProkerBestHandConstant.IS_STRAIGHT, isStraight);
		rankResultMap.put(ProkerBestHandConstant.IS_FLUSH, flushSet.size() == ProkerBestHandConstant.ONE);
		return rankResultMap;

	}

	/** Below method is used to distinguish of pair type */
	private int getPokerRankCount(int[] faceCount) {
		int rankCount = 0;

		for (int count : faceCount) {
			switch (count) {
			case ProkerBestHandConstant.THREE:
				rankCount += ProkerBestHandConstant.THREE;
				continue;
			case ProkerBestHandConstant.TWO:
				 rankCount += ProkerBestHandConstant.TWO;
				continue;
			case ProkerBestHandConstant.FOUR:
				rankCount = ProkerBestHandConstant.FOUR_KIND;
				break;
			default:
				break;
			}
		}
		return rankCount;
	}

	

}
