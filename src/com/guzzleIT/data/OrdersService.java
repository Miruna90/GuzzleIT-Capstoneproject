/*
 * Filename: OrdersService.java
* Author: Mirunalini
* 03/10/2020 
 */
package com.guzzleIT.data;

import java.sql.Date;
import java.util.List;

import javax.persistence.Query;

/**
 * @author drmir
 *
 */
public class OrdersService extends AbstractService {
	/**
	 * add
	 * 
	 * @param orders
	 */
	public void add(Orders orders) {
		em.getTransaction().begin();
		em.persist(orders);
		em.getTransaction().commit();

	}

	/**
	 * findUserById
	 * 
	 * @param id
	 * @return orders
	 */
	public Orders findUserById(int id) {
		Query query = this.em.createNamedQuery("FindOrdersById");
		this.em.getTransaction().begin();
		Orders orders = em.find(Orders.class, id);
		em.getTransaction().commit();
		System.out.println("\n" + orders);
		return orders;
	}

	/**
	 * deleteById
	 * 
	 * @param id
	 */
	public void deleteById(int id) {
		Query query = em.createNamedQuery("DeleteOrdersById");
		em.getTransaction().begin();
		Orders foundOrders = em.find(Orders.class, id);
		em.remove(foundOrders);
		em.getTransaction().commit();
		cleanup();
	}

	/**
	 * update
	 * 
	 * @param id
	 * @param orderdate
	 * @param orderstatus
	 * @param splInstructions
	 * @param List            of odList
	 * 
	 */
	public boolean update(int id, Date orderDate, String orderStatus, String splInstructions,
			List<OrderDetails> odList) {
		em.getTransaction().begin();
		Orders foundOrders = em.find(Orders.class, id);
		foundOrders.setOrderDate(orderDate);
		foundOrders.setOrderStatus(orderStatus);
		foundOrders.setSplInstructions(splInstructions);
		foundOrders.setOdList(odList);
		em.getTransaction().commit();
		cleanup();
		return true;

	}

	/**
	 * clearAll
	 */
	public void clearAll() {
		this.em.getTransaction().begin();
		em.createQuery("DeleteAllOrders").executeUpdate();
		Orders orders = new Orders();
		em.remove(orders);
		em.getTransaction().commit();
	}

	/**
	 * close
	 */
	public void close() {
		cleanup();
	}

}
