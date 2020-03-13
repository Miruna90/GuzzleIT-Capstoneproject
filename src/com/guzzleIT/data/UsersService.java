/*
 * Filename: UsersService.java
* Author: Mirunalini
* 03/10/2020 
 */
package com.guzzleIT.data;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 * @author drmir
 *
 */
public class UsersService extends AbstractService {
	/**
	 * add
	 * 
	 * @param user
	 */
	public void add(Users user) {
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();

	}

	/**
	 * findUserById
	 * 
	 * @param id
	 * @return user
	 */
	public Users findUserById(int id) {
		Query query = this.em.createNamedQuery("FindById");
		this.em.getTransaction().begin();
		Users user = em.find(Users.class, id);
		em.getTransaction().commit();
		System.out.println("\n" + user);
		return user;
	}

	/**
	 * findUserByEmail
	 * 
	 * @param email
	 * @return user
	 */
	@SuppressWarnings("unchecked")
	public Users findUserByEmail(String email) {
		Query query = this.em.createNamedQuery("FindByEmail");
		System.out.println("inside findUserByEmail method");
		List<Users> q = query.setParameter("email", email).getResultList();
		System.out.println("query result is " + q);
		Users result = null;
		try {
			result = (Users) query.getSingleResult();
		} catch (NoResultException ex) {
			return null;
		}
		System.out.println("result = " + result);
		return result;
	}

	/**
	 * emailExists
	 * 
	 * @param email
	 */
	public boolean emailExists(String email) {
		Users u = findUserByEmail(email);
		System.out.println("user =" + u);
		if (u == null) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * loginUser
	 * 
	 * @param email
	 * @param password
	 */
	@SuppressWarnings("unchecked")
	public boolean loginUser(String email, String password) {
		Query query = this.em.createNamedQuery("LoginUser");

		System.out.println(query);
		this.em.getTransaction().begin();
		List<Users> result = query.setParameter("email", email).setParameter("password", password).getResultList();
		System.out.println(result.toString());
		this.em.getTransaction().commit();
		if (result.isEmpty()) {

			return false;

		} else {
			return true;
		}
	}

	/**
	 * deleteById
	 * 
	 * @param id
	 */
	public void deleteById(int id) {
		Query query = em.createNamedQuery("DeleteById");
		em.getTransaction().begin();
		Users foundUser = em.find(Users.class, id);
		em.remove(foundUser);
		em.getTransaction().commit();
		cleanup();
	}

	/**
	 * update
	 * 
	 * @param id
	 * @param email
	 * @return password
	 * 
	 */
	public boolean update(int id, String email, String password) {
		em.getTransaction().begin();
		Users foundUser = em.find(Users.class, id);
		foundUser.setEmail(email);
		foundUser.setPassword(password);
		em.getTransaction().commit();
		cleanup();
		return true;

	}

	/**
	 * clearAll
	 */
	public void clearAll() {
		this.em.getTransaction().begin();
		em.createQuery("DELETE FROM Users").executeUpdate();
		Users user = new Users();
		em.remove(user);
		em.getTransaction().commit();
	}

	/**
	 * close
	 */
	public void close() {
		cleanup();
	}

}
