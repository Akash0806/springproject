package com.demo.builderDesignPattren;

public class VegBurger extends Burger {

	private float price = 23.5f;
	
	private String name="VegBurger";

	public float getPrice() {
		return price;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

}
