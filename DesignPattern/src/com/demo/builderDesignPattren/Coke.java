package com.demo.builderDesignPattren;

public class Coke extends ColdDrink {
	
private float price=23.5f;
	
	private String name="Coke";

	
    public float getPrice(){
		return price;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

}
