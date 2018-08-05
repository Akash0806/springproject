package com.demo.builderDesignPattren;

public class MealBuilder {
	
	
	
	public void createVegMeal(){
		Meal meal=new Meal();
		Item vegBurger=new VegBurger();
		Item coke=new Coke();
		meal.addItem(vegBurger);
		meal.addItem(coke);
		meal.showItems();
		meal.getCost();
		
	}
	
	public void createNonVegMeal(){
		Meal meal=new Meal();
		Item nonVegBurger=new NonVegBurger();
		Item pepsi=new Pepsi();
		meal.addItem(nonVegBurger);
		meal.addItem(pepsi);
		meal.showItems();
		meal.getCost();
		
	}

}
