package com.billgenration.item.categories.impl;

import com.billgenration.item.categories.ColdDrinks;

public class Pepsi extends ColdDrinks {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Pepsi";
	}

	@Override
	public float getDiscount() {
		// TODO Auto-generated method stub
		return 0.0f;
	}

	/* Story2# Discounts can be on individual items. */
	@Override
	public float getPrice() {
		// TODO Auto-generated method stub
		return 35.00f;
	}

}
