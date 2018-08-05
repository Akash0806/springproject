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
public class TestTenPercentage {

	@Mock
	private DiscountChain chain;
	
	private TenPercentage tenPercentage;
	
	@Before
	public void setUp() throws Exception {
		tenPercentage=new TenPercentage();
	}

	@Test
	public void testDiscountCalWhenCostAbove100() {
		Meal meal=new Meal();
		meal.setTotalCost(110);
		meal.setRemainCostAfterDiscount(110);
		tenPercentage.discountCal(meal);
		assertTrue(meal.getRemainCostAfterDiscount()==99);
	}
	@Test
	public void testDiscountCalWhenCostAbove225() {
		Meal meal=new Meal();
		meal.setTotalCost(225);
		meal.setRemainCostAfterDiscount(225);
		tenPercentage.setNextChain(chain);
		Mockito.doNothing().when(chain).discountCal(meal);
		tenPercentage.discountCal(meal);
		Mockito.verify(chain).discountCal(meal);
		Mockito.verify(chain, times(1)).discountCal(meal);
		assertTrue(meal.getRemainCostAfterDiscount()==202.5);
		
	}
	
	@Test
	public void testDiscountCalWhenCostLess100() {
		Meal meal=new Meal();
		meal.setTotalCost(50);
		meal.setRemainCostAfterDiscount(50);
		tenPercentage.setNextChain(chain);
		tenPercentage.discountCal(meal);
		assertTrue(meal.getRemainCostAfterDiscount()==meal.getTotalCost());
		
	}

}
