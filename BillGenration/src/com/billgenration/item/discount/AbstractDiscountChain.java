package com.billgenration.item.discount;

import com.billgenration.meal.Meal;

public abstract class AbstractDiscountChain implements DiscountChain {

	public abstract void setNextChain(DiscountChain nextChain);

	public abstract void discountCal(Meal meal);

	protected void calculateDiscountOnCost(Meal meal, float perc_value) {
		float remainingCastAmount = meal.getRemainCostAfterDiscount();
		float rslt_value = percentageCal(perc_value, remainingCastAmount);
		remainingCastAmount = remainingCastAmount - rslt_value;
		meal.setDiscount(rslt_value);
		meal.setRemainCostAfterDiscount(remainingCastAmount);

	}

	protected float percentageCal(float perc_value, float remainingCastAmount) {
		float rslt_value = (perc_value * remainingCastAmount) / 100;
		return rslt_value;
	}
}
