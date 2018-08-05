package com.billgenration.item.builder;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.billgenration.item.discount.builder.DiscountChainBuilder;
import com.billgenration.item.discount.impl.TenPercentage;
import com.billgenration.meal.Meal;
@RunWith(MockitoJUnitRunner.class)
public class ItemBuilderTest {
    @Mock
    Meal meal;
    @Mock
    DiscountChainBuilder discountChainBuilder;
    
    ItemBuilder itemBuilder=null;
	    
    @Before
	public void setUp() throws Exception {
    	itemBuilder=new ItemBuilder(discountChainBuilder,"input/input_order_blank.csv");
	}

	
	@Test
	public void createItemizedBillWhenInputFileIsBlank() {
		Meal meal=itemBuilder.createItemizedBill();
		assertTrue(meal.getitems().size()==0);
	}
	
	@Test
	public void createItemizedBillWhenInputParitialPresent() {
		ItemBuilder itemBuilderParital=new ItemBuilder(discountChainBuilder,"input/input_order_parital.csv");
		Mockito.when(discountChainBuilder.getDiscountChain()).thenReturn(new TenPercentage());
		Meal meal=itemBuilderParital.createItemizedBill();
		Mockito.verify(discountChainBuilder).getDiscountChain();
		Mockito.verify(discountChainBuilder, times(1)).getDiscountChain();
		assertTrue(meal.getitems().size()==5);
	}

	@Test
	public void createItemizedBillWhenKeyNotPresent() {
		ItemBuilder itemBuilderParital=new ItemBuilder(discountChainBuilder,"input/input_order_keyNotPresent.csv");
		Meal meal=itemBuilderParital.createItemizedBill();
		assertTrue(meal.getitems().size()==0);
	}

	
	@Test(expected=ClassNotFoundException.class)
	public void createItemizedBillWhenClassNotPresntExpectedExeption() {
		ItemBuilder itemBuilderParital=new ItemBuilder(discountChainBuilder,"input/input_order_keyNotPresent.csv");
		Meal meal=itemBuilderParital.createItemizedBill();
		assertTrue(meal.getitems().size()==0);
	}

	
	

}
