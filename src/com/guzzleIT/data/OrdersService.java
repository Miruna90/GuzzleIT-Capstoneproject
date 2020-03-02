/**
 * 
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
	// add
	public void add(Orders orders) {
		em.getTransaction().begin();
		em.persist(orders);
		em.getTransaction().commit();

	}

	// find user by ID
	public Orders findUserById(int id) {
		Query query = this.em.createNamedQuery("FindOrdersById");
		this.em.getTransaction().begin();
		Orders orders = em.find(Orders.class, id);
		em.getTransaction().commit();
		System.out.println("\n" + orders);
		return orders;
	}

	// delete user by ID
	public void deleteById(int id) {
		Query query = em.createNamedQuery("DeleteOrdersById");
		em.getTransaction().begin();
		Orders foundOrders = em.find(Orders.class, id);
		em.remove(foundOrders);
		em.getTransaction().commit();
		cleanup();
	}

	// update - user will be able to update any field of a record except the ID
	public boolean update(int id, Date orderDate, String orderStatus, String splInstructions,List<OrderDetails> odList) {
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

	// clearAll
	public void clearAll() {
		this.em.getTransaction().begin();
		em.createQuery("DeleteAllOrders").executeUpdate();
		Orders orders = new Orders();
		em.remove(orders);
		em.getTransaction().commit();
	}
	public void close() {
		cleanup();
	}

}
