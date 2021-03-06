/*
 * Filename: OrderDetails.java
* Author: Mirunalini
* 03/10/2020 
 */
package com.guzzleIT.data;

import java.io.Serializable;
import java.lang.Integer;
import java.text.NumberFormat;
import java.util.List;

import javax.persistence.*;

import com.guzzleIT.exceptions.QuantityException;

/**
 * Entity implementation class for Entity: OrderProductDetails
 *
 */
@Entity
@NamedQueries({ @NamedQuery(query = "select o from OrderDetails o where o.id=:id", name = "FindOrderDetailsById"),
		@NamedQuery(query = "delete from OrderDetails o WHERE o.id=:id", name = "DeleteOrderDetailsById"),
		@NamedQuery(query = "delete from OrderDetails", name = "DeleteAllOrderDetails") })

public class OrderDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private int quantity;
	private double price;
	@OneToOne
	private Product product;

	public OrderDetails() {
		super();
	}

	/**
	 * @param id
	 * @param quantity
	 * @param price
	 * @throws QuantityException 
	 */
	public OrderDetails(int quantity, double price, Product product) throws QuantityException {
		super();
		this.setQuantity(quantity);
		this.setPrice(price);
		this.setProduct(product);

	}

	/**
	 * @return the id
	 */

	public Integer getId() {
		return this.id;
	}

	/**
	 * @param id the id to set
	 */

	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return this.quantity;
	}

	/**
	 * @param quantity the quantity to set
	 * @throws QuantityException 
	 */

	public void setQuantity(int quantity) throws QuantityException {
		if(quantity<0) {
			throw new QuantityException("Quantity muct be greater than 0");
		}else {
			this.quantity = quantity;
		}
		
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + quantity;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDetails other = (OrderDetails) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderDetails [id=");
		builder.append(id);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append(", price=");
		builder.append(price);
		builder.append(", product=");
		builder.append(product);
		builder.append("]");
		return builder.toString();
	}

}
