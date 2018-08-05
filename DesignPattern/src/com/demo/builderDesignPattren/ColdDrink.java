package com.demo.builderDesignPattren;

public abstract class ColdDrink implements Item {
	
	public Packing getPacking(){
		Packing bottelPack=new BottelPacking();
		  return bottelPack;
		}
	
	public abstract float getPrice();

}
