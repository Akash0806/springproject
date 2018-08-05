package com.demo.builderDesignPattren;

public class Pepsi extends ColdDrink {
	
	private float price=23.5f;
	
	private String name="Pepsi";

	
  public float getPrice(){
		
		return price;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	
	

}
