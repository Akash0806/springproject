package com.demo.builderDesignPattren;

public abstract class Burger implements Item {
	
	public Packing getPacking(){
		Packing packing=new WrapperPacking();
	return packing;
	}
	
	public abstract float getPrice();

}
