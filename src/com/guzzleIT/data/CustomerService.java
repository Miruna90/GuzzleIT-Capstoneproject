/*
 * Filename: CustomerService.java
* Author: Mirunalini
* 03/10/2020 
 */
package com.guzzleIT.data;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

/**
 * @author drmir
 *
 */
public class CustomerService extends AbstractService {

	// add
		public void add(Customer customer) {
			em.getTransaction().begin();
			em.persist(customer);
			em.getTransaction().commit();

		}

		// find user by ID
		public Customer findUserById(int id) {
			Query query = this.em.createNamedQuery("FindCustomersById");
			this.em.getTransaction().begin();
			Customer customer = em.find(Customer.class, id);
			em.getTransaction().commit();
			System.out.println("\n" + customer);
			return customer;
		}

		// delete user by ID
		public void deleteById(int id) {
			Query query = em.createNamedQuery("DeleteCustomersById");
			em.getTransaction().begin();
			Customer foundCustomer = em.find(Customer.class, id);
			em.remove(foundCustomer);
			em.getTransaction().commit();
			cleanup();
		}

		// update - user will be able to update any field of a record except the ID
		public boolean update(int id, String firstName, String lastName,
				String password, String phone, String address, String city,String state,String zipcode,Users users, List<Orders> orderList) {
			em.getTransaction().begin();
			Customer foundCustomer = em.find(Customer.class, id);
			foundCustomer.setFirstName(firstName);
			foundCustomer.setLastName(lastName);
			
			foundCustomer.setPhone(phone);
			foundCustomer.setAddress(address);
			foundCustomer.setCity(city);
			foundCustomer.setState(state);
			foundCustomer.setZipcode(zipcode);
			foundCustomer.setUsers(users);
			em.getTransaction().commit();
			//cleanup();
			return true;

		}

		// clearAll
		public void clearAll() {
			this.em.getTransaction().begin();
			em.createQuery("DeleteAllCustomers").executeUpdate();
			Customer customer = new Customer();
			em.remove(customer);
			em.getTransaction().commit();
		}
		public void close() {
			cleanup();
		}

}
