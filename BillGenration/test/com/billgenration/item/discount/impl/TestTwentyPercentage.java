package com.billgenration.item.discount.impl;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.billgenration.item.discount.DiscountChain;
import com.billgenration.meal.Meal;
@RunWith(MockitoJUnitRunner.class)
public class TestTwentyPercentage {

	@Mock
	private DiscountChain chain;
	
	private TwentyPercentage twentyPercentage;
	
	@Before
	public void setUp() throws Exception {
		twentyPercentage=new TwentyPercentage();
	}
	@Test
	public void testDiscountCalWhenCostEquals200() {
		Meal meal=new Meal();
		meal.setTotalCost(200);
		meal.setRemainCostAfterDiscount(200);
		twentyPercentage.discountCal(meal);
		assertTrue(meal.getRemainCostAfterDiscount()==160);
	}
	@Test
	public void testDiscountCalWhenCostAbove225() {
		Meal meal=new Meal();
		meal.setTotalCost(225);
		meal.setRemainCostAfterDiscount(225);
		twentyPercentage.setNextChain(chain);
		Mockito.doNothing().when(chain).discountCal(meal);
		twentyPercentage.discountCal(meal);
		Mockito.verify(chain).discountCal(meal);
		Mockito.verify(chain, times(1)).discountCal(meal);
		assertTrue(meal.getRemainCostAfterDiscount()==180);
		
	}
	
	@Test
	public void testDiscountCalWhenCostLess200() {
		Meal meal=new Meal();
		meal.setTotalCost(50);
		meal.setRemainCostAfterDiscount(50);
		twentyPercentage.discountCal(meal);
		assertTrue(meal.getRemainCostAfterDiscount()==meal.getTotalCost());
		
	}

}
