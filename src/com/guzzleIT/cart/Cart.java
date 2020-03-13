/*
 * Filename: Cart.java
* Author: Mirunalini
* 03/10/2020 
 */
package com.guzzleIT.cart;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.guzzleIT.data.OrderDetails;

/**
 * @author drmir
 *
 */

/**
 * @author drmir
 *
 */
public class Cart implements Serializable {

	private List<OrderDetails> items;
	double cartTotal;

	public Cart() {
		items = new ArrayList<>();
	}

	/**
	 * @return the items
	 */
	public List<OrderDetails> getItems() {
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(List<OrderDetails> items) {
		this.items = items;
	}

	/**
	 * @return the items
	 */
	public int getCount() {
		return items.size();
	}

	/**
	 * setCartTotal
	 */
	public void setCartTotal() {

		double orderTotal = 0;
		for (int i = 0; i < items.size(); i++) {
			OrderDetails od = items.get(i);
			orderTotal += od.getPrice() * od.getQuantity();
		}

		this.cartTotal = orderTotal;

	}

	/**
	 * @return cartTotal
	 */
	public double getCartTotal() {
		return cartTotal;
	}

	/**
	 * addItems
	 * 
	 * @param item
	 */
	public void addItem(OrderDetails item) {
		// If the item already exists in the cart, only the quantity is changed.
		String code = item.getProduct().getProductCode();
		int quantity = item.getQuantity();
		System.out.println("quantity:" + quantity);
		for (int i = 0; i < items.size(); i++) {
			OrderDetails orderDetails = items.get(i);
			if (orderDetails.getProduct().getProductCode().equals(code)) {
				orderDetails.setQuantity(quantity);
				return;
			}
		}
		items.add(item);
	}

	/**
	 * removeItems
	 * 
	 * @param item
	 */

	public void removeItem(OrderDetails item) {
		String code = item.getProduct().getProductCode();
		for (int i = 0; i < items.size(); i++) {
			OrderDetails orderDetails = items.get(i);
			if (orderDetails.getProduct().getProductCode().equals(code)) {
				items.remove(i);
				return;
			}
		}
	}

}
