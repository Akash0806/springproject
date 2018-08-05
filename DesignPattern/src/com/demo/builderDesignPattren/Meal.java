package com.demo.builderDesignPattren;

import java.util.ArrayList;
import java.util.List;

public class Meal {
	
	List<Item> itemList=new ArrayList<Item>();
	
	public void addItem(Item items){
		itemList.add(items);
		
	}
	public float getCost(){
	      float cost = 0.0f;
	      
	      for (Item item : itemList) {
	         cost += item.getPrice();
	      }		
	      return cost;
	   }

	   public void showItems(){
	   
	      for (Item item : itemList) {
	         System.out.print("Item : " + item.getName());
	         System.out.print(", Packing : " + item.getPacking().getPacking());
	         System.out.println(", Price : " + item.getPrice());
	      }		
	   }	

}
