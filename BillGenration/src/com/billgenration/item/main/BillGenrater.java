package com.billgenration.item.main;

import com.billgenration.constant.BillGenrationConstant;
import com.billgenration.item.builder.ItemBuilder;
import com.billgenration.item.discount.builder.DiscountChainBuilder;
import com.billgenration.meal.Meal;

public class BillGenrater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Meal meal = new ItemBuilder(new DiscountChainBuilder(), BillGenrationConstant.INPUT_INPUT_ORDER_CSV)
				.createItemizedBill();
		meal.showItems();
	}

}
