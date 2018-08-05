package com.billgenration.item;

public interface Item {
	public String getName();

	public float getPrice();

	/* Story2# Discounts can be on individual items. */
	public float getDiscount();
}
