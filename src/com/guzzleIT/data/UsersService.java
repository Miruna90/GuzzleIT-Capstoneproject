/**
 * 
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
	// add
	public void add(Users user) {
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();

	}

	// find user by ID
	public Users findUserById(int id) {
		Query query = this.em.createNamedQuery("FindById");
		this.em.getTransaction().begin();
		Users user = em.find(Users.class, id);
		em.getTransaction().commit();
		System.out.println("\n" + user);
		return user;
	}
	//find user by email
	public Users findUserByEmail(String email) {
		Query query = this.em.createNamedQuery("FindByEmail");
		System.out.println("inside findUserByEmail method");
		//em.getTransaction().begin();
		List<Users> q = query
				.setParameter("email",email)
				.getResultList();
		System.out.println("query result is " + q);
		Users result = null;
		//Users user = em.find(Users.class, email);
		try {
            result = (Users) query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        } 
		//em.getTransaction().commit();
        System.out.println("result = "+ result);
        return result;
	}
	// check email exits
	public boolean emailExists(String email) {
//		em.getTransaction().begin();
        Users u = findUserByEmail(email); 
        System.out.println("user ="+u);
//        em.getTransaction().commit();
        if (u == null) {
        	return false;
        }else {
        	return true;
        }
    } 
	// find registered user
	public boolean loginUser(String email,String password ) {
		Query query = this.em.createNamedQuery("LoginUser");
	
		System.out.println(query);
		this.em.getTransaction().begin();
		List<Users> result = query
				.setParameter("email",email)
				.setParameter("password",password)
				.getResultList();
		System.out.println(result.toString());
		//System.out.println(em.toString());
		//System.out.println(result);
		//Boolean valid = em.contains(user);
		this.em.getTransaction().commit();
		if (result.isEmpty()) {
			
			return false;
			
		} else {
			return true;
		}
	}

	// delete user by ID
	public void deleteById(int id) {
		Query query = em.createNamedQuery("DeleteById");
		em.getTransaction().begin();
		Users foundUser = em.find(Users.class, id);
		em.remove(foundUser);
		em.getTransaction().commit();
		cleanup();
	}

	// update - user will be able to update any field of a record except the ID
	public boolean update(int id, String email, String password) {
		em.getTransaction().begin();
		Users foundUser = em.find(Users.class, id);
		foundUser.setEmail(email);
		foundUser.setPassword(password);
		em.getTransaction().commit();
		cleanup();
		return true;

	}

	// clearAll
	public void clearAll() {
		this.em.getTransaction().begin();
		em.createQuery("DELETE FROM Users").executeUpdate();
		Users user = new Users();
		em.remove(user);
		em.getTransaction().commit();
	}
	
	public void close() {
		cleanup();
	}

}
