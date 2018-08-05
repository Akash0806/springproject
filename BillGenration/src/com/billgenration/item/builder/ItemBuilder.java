package com.billgenration.item.builder;

import java.util.List;

import com.billgenration.constant.BillGenrationConstant;
import com.billgenration.item.Item;
import com.billgenration.item.discount.builder.DiscountChainBuilder;
import com.billgenration.item.helper.InputUtil;
import com.billgenration.item.helper.PropertyUtil;
import com.billgenration.meal.Meal;

public class ItemBuilder {

	private DiscountChainBuilder discountChainBuilder;
	private String inputPath;

	public ItemBuilder(DiscountChainBuilder discountChainBuilder, String inputPath) {
		this.discountChainBuilder = discountChainBuilder;
		this.inputPath = inputPath;
	}

	public Meal createItemizedBill()  {
		List<String> inputs = new InputUtil().getInputStrintsFromCSV(inputPath);
		Meal meal = new Meal();
		if (inputs != null && inputs.size() > 0) {
			PropertyUtil propertyUtil = loadPropertyUtil();
			setItemListFromInput(propertyUtil, inputs, meal);
			if (meal.getitems().size() > 0) {
				float totalCost = meal.getCost();
				meal.setRemainCostAfterDiscount(totalCost);
				meal.setTotalCost(totalCost);
				discountChainBuilder.getDiscountChain().discountCal(meal);
			}
		}
		return meal;
	}

	private void setItemListFromInput(PropertyUtil propertyUtil, List<String> inputs, Meal meal) {
		for (String inputKey : inputs) {
			String inputValue = propertyUtil.getPropertyValue(inputKey);
			if (inputValue != null && !inputValue.isEmpty()) {
				Item newItemIntacne = loadItemClass(inputValue);
				if(newItemIntacne!=null){
				meal.addItem(newItemIntacne);
				}
			}
		}
	}

	private PropertyUtil loadPropertyUtil() {
		PropertyUtil propertyUtil = new PropertyUtil();
		propertyUtil.getProperties(BillGenrationConstant.CONFIG_ITEMANDCODEMAPPING_PROPERTIES);
		return propertyUtil;
	}

	private Item loadItemClass(String inputValue) {
		Item newItemIntacne = null;
		try {
			newItemIntacne = (Item) Class.forName(inputValue).newInstance();

		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return newItemIntacne;
	}

}
