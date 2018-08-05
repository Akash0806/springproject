package com.billgenration.item.discount.impl;

import com.billgenration.item.discount.AbstractDiscountChain;
import com.billgenration.item.discount.DiscountChain;
import com.billgenration.meal.Meal;

public class TenPercentage extends AbstractDiscountChain {

	private DiscountChain chain;

	@Override
	public void setNextChain(DiscountChain nextChain) {
		// TODO Auto-generated method stub
		this.chain = nextChain;
	}

	@Override
	public void discountCal(Meal meal) {
		if (meal.getTotalCost() >= 100) {
			float perc_value = 10;
			calculateDiscountOnCost(meal, perc_value);
			if (meal.getRemainCostAfterDiscount() != 0 && this.chain != null)
				this.chain.discountCal(meal);
		} else {
			if (this.chain != null)
				this.chain.discountCal(meal);
		}
	}

}
