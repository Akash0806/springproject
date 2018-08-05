package com.billgenration.meal;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.billgenration.item.Item;
import com.billgenration.item.categories.impl.Coke;
import com.billgenration.item.categories.impl.ColdCoffee;
import com.billgenration.item.categories.impl.Pepsi;

public class TestMeal {

	private Meal meal;
	
	@Before
	public void setUp() throws Exception {
		meal=new Meal();
	}

	@Test
	public void testAddItemWhenItemAdded() {
		Item item=new Coke();
		meal.addItem(item);
		assertTrue(meal.getitems().size()==1);
	}

	@Test
	public void testGetCost() {
		Item item1=new Coke();
		Item item2=new Pepsi();
		Item item3=new ColdCoffee();
		meal.addItem(item1);
		meal.addItem(item2);
		meal.addItem(item3);
		float cost=meal.getCost();
		assertTrue(meal.getitems().size()==3);
		assertTrue(cost==140.0);
	}

}
