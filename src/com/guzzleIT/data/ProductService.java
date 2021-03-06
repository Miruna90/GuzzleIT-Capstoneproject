/*
 * Filename: ProductService.java
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
public class ProductService extends AbstractService {

	/**
	 * add
	 * 
	 * @param product
	 */
	public void add(Product product) {
		em.getTransaction().begin();
		em.persist(product);
		em.getTransaction().commit();

	}
//
//	/**
//	 * findUserById
//	 * 
//	 * @param id
//	 * @return product
//	 */
//	public Product findProductById(int id) {
//		Query query = this.em.createNamedQuery("FindProductsById");
//		this.em.getTransaction().begin();
//		Product product = em.find(Product.class, id);
//		em.getTransaction().commit();
//		System.out.println("\n" + product);
//		return product;
//	}
//
//	/**
//	 * deleteById
//	 * 
//	 * @param id
//	 */
//	public void deleteById(int id) {
//		Query query = em.createNamedQuery("DeleteProductsById");
//		em.getTransaction().begin();
//		Product foundProduct = em.find(Product.class, id);
//		em.remove(foundProduct);
//		em.getTransaction().commit();
//		cleanup();
//	}

	/**
	 * update
	 * 
	 * @param id
	 * @param productcode
	 * @return product
	 * 
	 */

	public Product selectProduct(String productCode) {
		Query query = em.createNamedQuery("SelectProductsByCode");
		em.getTransaction().begin();
		List<Product> result = query.setParameter("productCode", productCode).getResultList();
		System.out.println(result);

		Product foundProduct = new Product();
		foundProduct.setProductCode(result.get(0).getProductCode());
		foundProduct.setName(result.get(0).getName());
		foundProduct.setDescription(result.get(0).getDescription());
		foundProduct.setPrice(result.get(0).getPrice());
		//foundProduct.setSize(result.get(0).getSize());
		foundProduct.setId(result.get(0).getId());

		System.out.println(foundProduct);
		return foundProduct;
	}


	/**
	 * update
	 * 
	 * @param id
	 * @param name
	 * @param description
	 * @param size
	 * @param price
	 * 
	 */
	public boolean update(int id, String name, String description, double price) {
		em.getTransaction().begin();
		Product foundProduct = em.find(Product.class, id);
		foundProduct.setName(name);
		foundProduct.setDescription(description);
		foundProduct.setPrice(price);
		em.getTransaction().commit();
		cleanup();
		return true;

	}

	/**
	 * clearAll
	 */
	public void clearAll() {
		this.em.getTransaction().begin();
		em.createQuery("DELETE FROM Product").executeUpdate();
		Product product = new Product();
		em.remove(product);
		em.getTransaction().commit();
	}

	/**
	 * close
	 */
	public void close() {
		cleanup();
	}

}
