package com.billgenration.meal;

import java.util.ArrayList;
import java.util.List;

import com.billgenration.item.Item;

public class Meal {
	private List<Item> items = new ArrayList<Item>();
	private float totalCost;
	private float remainCostAfterDiscount;
	private float discount;

	public void addItem(Item item) {
		items.add(item);
	}

	public float getCost() {
		float cost = 0.0f;
		for (Item item : items) {
			cost += item.getPrice();
		}
		return cost;
	}

	public void showItems() {
		System.out.println("Item Name" + "        " + "Price (INR)");
		for (Item item : items) {
			System.out.println(item.getName() + "        " + item.getPrice());
		}
		System.out.println("Total Cost: " + "        " + totalCost);
		if(totalCost!=getRemainCostAfterDiscount())
		System.out.println("Discounted Cost: " + "        " + getRemainCostAfterDiscount());
	}

	public float getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(float totalCost) {
		this.totalCost = totalCost;
	}

	public float getRemainCostAfterDiscount() {
		return remainCostAfterDiscount;
	}

	public void setRemainCostAfterDiscount(float remainCostAfterDiscount) {
		this.remainCostAfterDiscount = remainCostAfterDiscount;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public List<Item> getitems() {
		return this.items;
	}
}
