/*
 * Filename: OrderDetailsService.java
* Author: Mirunalini
* 03/10/2020 
 */
package com.guzzleIT.data;

import java.util.List;

import javax.persistence.Query;

/**
 * @author drmir
 *
 */
public class OrderDetailsService extends AbstractService {
	/**
	 * add
	 * 
	 * @param orderDetails
	 */
	public void add(OrderDetails orderDetails) {
		em.getTransaction().begin();
		em.persist(orderDetails);
		em.getTransaction().commit();

	}

	/**
	 * findUserById
	 * 
	 * @param id
	 * @return orderDetails
	 */
	public OrderDetails findUserById(int id) {
		Query query = this.em.createNamedQuery("FindOrderDetailsById");
		this.em.getTransaction().begin();
		OrderDetails orderDetails = em.find(OrderDetails.class, id);
		em.getTransaction().commit();
		System.out.println("\n" + orderDetails);
		return orderDetails;
	}

	/**
	 * deleteById
	 * 
	 * @param id
	 */
	public void deleteById(int id) {
		Query query = em.createNamedQuery("DeleteOrderDetailsById");
		em.getTransaction().begin();
		OrderDetails foundOrderDetails = em.find(OrderDetails.class, id);
		em.remove(foundOrderDetails);
		em.getTransaction().commit();
		cleanup();
	}

	/**
	 * update
	 * 
	 * @param id
	 * @param quantity
	 * @param price
	 * @param product
	 * 
	 */
	public boolean update(Integer id, int quantity, double price, Product product) {
		em.getTransaction().begin();
		OrderDetails foundOrderDetails = em.find(OrderDetails.class, id);
		foundOrderDetails.setId(id);
		foundOrderDetails.setQuantity(quantity);
		foundOrderDetails.setPrice(price);
		foundOrderDetails.setProduct(product);
		em.getTransaction().commit();
		cleanup();
		return true;

	}

	/**
	 * clearAll
	 */
	public void clearAll() {
		this.em.getTransaction().begin();
		em.createQuery("DeleteAllOrderDetails").executeUpdate();
		OrderDetails orderDetails = new OrderDetails();
		em.remove(orderDetails);
		em.getTransaction().commit();
	}

	/**
	 * close
	 */
	public void close() {
		cleanup();
	}

}
