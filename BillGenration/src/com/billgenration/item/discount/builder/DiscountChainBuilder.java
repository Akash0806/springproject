package com.billgenration.item.discount.builder;

import com.billgenration.item.discount.DiscountChain;
import com.billgenration.item.discount.impl.TenPercentage;
import com.billgenration.item.discount.impl.TwentyPercentage;

public class DiscountChainBuilder {
	private DiscountChain discountChain;

	public DiscountChain getDiscountChain() {
		return discountChain;
	}

	public void setDiscountChain(DiscountChain discountChain) {
		this.discountChain = discountChain;
	}

	public DiscountChainBuilder() {
		// initialize the chain
		this.discountChain = new TenPercentage();
		DiscountChain discountChain_2 = new TwentyPercentage();
		discountChain.setNextChain(discountChain_2);
	}

}
