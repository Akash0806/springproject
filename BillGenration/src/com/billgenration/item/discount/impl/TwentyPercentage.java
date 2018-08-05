package com.billgenration.item.discount.impl;

import com.billgenration.item.discount.AbstractDiscountChain;
import com.billgenration.item.discount.DiscountChain;
import com.billgenration.meal.Meal;

public class TwentyPercentage extends AbstractDiscountChain {

	private DiscountChain chain;

	@Override
	public void setNextChain(DiscountChain nextChain) {
		this.chain = nextChain;
	}

	@Override
	public void discountCal(Meal meal) {
		if (meal.getTotalCost() >= 200) {
			float perc_value = 20;
			calculateDiscountOnCost(meal, perc_value);
			if (meal.getRemainCostAfterDiscount() != 0 && this.chain != null)
				this.chain.discountCal(meal);
		} else {
			if (this.chain != null)
				this.chain.discountCal(meal);
		}
	}

}
