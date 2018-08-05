package com.pokerbesthand.enumconstant;

public enum PokerHandType {
	
	HIGH_CARD("High card"), PAIR("Pair"), TWO_PAIR("Two Pair"), THREE_OF_A_KIND("Three of a kind"), STRAIGHT("Straight"), FLUSH("Flush"), FULL_HOUSE("Full House"), FOUR_OF_A_KIND("Four of a kind");

	PokerHandType(String pokerType) {
        this.pokerType = pokerType;
    }
	private String pokerType;
	
	@Override 
    public String toString(){ 
        return pokerType; 
    } 
}
