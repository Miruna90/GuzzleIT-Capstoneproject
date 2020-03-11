/*
 * Filename: AbstractService.java
* Author: Mirunalini
* 03/10/2020 
 */
package com.guzzleIT.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author drmir
 *
 */
public class AbstractService {
	protected EntityManagerFactory emf;
	protected EntityManager em;
	
	public AbstractService() {
		emf = Persistence.createEntityManagerFactory("CapstoneProject");
		em = emf.createEntityManager();
	}
	
	protected void cleanup() {
		em.close();
		emf.close();
	}

}
