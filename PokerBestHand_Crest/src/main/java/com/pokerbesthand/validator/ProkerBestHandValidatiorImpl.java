package com.pokerbesthand.validator;
import java.util.Arrays;
import java.util.HashSet;

import com.pokerbesthand.util.PokerBestHandUtil;
import com.pokerbesthand.util.ProkerBestHandConstant;

public class ProkerBestHandValidatiorImpl implements ProkerBestHandValidatior {


	public String validation(String[] pokerInput) {
		if (isLengthMoreOrLessThenFive(pokerInput)) {
			return ProkerBestHandConstant.ERR_INVAILD_HANDS;
		} else if (isDuplicateElementsAreAvailable(pokerInput)) {
			return ProkerBestHandConstant.ERR_DUPLICATE_HANDS;
		} else {
			return isFacesAndSuitsAreValid(pokerInput);
		}

	}

	private boolean isDuplicateElementsAreAvailable(String[] pokerInput) {
		return new HashSet<>(Arrays.asList(pokerInput)).size() != PokerBestHandUtil.getInputArrayLength(pokerInput);
	}

	protected boolean isLengthMoreOrLessThenFive(String[] pokerInput) {
		return !ProkerBestHandConstant.INPUT_PARAM_SIZE.equals(PokerBestHandUtil.getInputArrayLength(pokerInput));
	}

	protected String isFacesAndSuitsAreValid(String[] pokerInput) {
		for (String card : pokerInput) {
			if (isVaildSuitsAndFaceArePresent(card, ProkerBestHandConstant.SUITS, ProkerBestHandConstant.ZERO)) {
				return ProkerBestHandConstant.ERR_NON_EXISTING_SUITS;
			} else {
				if (isVaildSuitsAndFaceArePresent(card, ProkerBestHandConstant.FACES, ProkerBestHandConstant.ONE)) {
					return ProkerBestHandConstant.ERR_NON_EXISTING_FACES;
				}
			}
		}
		return ProkerBestHandConstant.EMPTY_STRING;
	}

	private boolean isVaildSuitsAndFaceArePresent(String userCardInputs, String source, Integer position) {
		return ProkerBestHandConstant.MINUS_ONE.equals(PokerBestHandUtil.getPositionOfCharacter(userCardInputs, source, position));
	}

	

}
