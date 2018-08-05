package com.billgenration.item.discount;

import com.billgenration.meal.Meal;

public interface DiscountChain {
	void setNextChain(DiscountChain nextChain);

	void discountCal(Meal meal);
}
