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


//add
	public void add(Product product) {
		em.getTransaction().begin();
		em.persist(product);
		em.getTransaction().commit();

	}

//find user by ID
	public Product findProductById(int id) {
		Query query = this.em.createNamedQuery("FindProductsById");
		this.em.getTransaction().begin();
		Product product = em.find(Product.class, id);
		em.getTransaction().commit();
		System.out.println("\n" + product);
		return product;
	}

//delete user by ID
	public void deleteById(int id) {
		Query query = em.createNamedQuery("DeleteProductsById");
		em.getTransaction().begin();
		Product foundProduct = em.find(Product.class, id);
		em.remove(foundProduct);
		em.getTransaction().commit();
		cleanup();
	}
	
	public Product selectProduct(String productCode) {
       Query query =em.createNamedQuery("SelectProductsByCode");
       em.getTransaction().begin();
        List<Product> result= query.setParameter("productCode", productCode).getResultList();
        System.out.println(result);

        Product foundProduct = new Product();
        foundProduct.setProductCode(result.get(0).getProductCode());
        foundProduct.setName(result.get(0).getName());
        foundProduct.setDescription(result.get(0).getDescription());
        foundProduct.setPrice(result.get(0).getPrice());
        foundProduct.setSize(result.get(0).getSize());
        foundProduct.setId(result.get(0).getId());
        
        System.out.println(foundProduct);
        return foundProduct;
    }
	
	public Product selectPrice(double price) {
		return null;
		
	}

	// update - user will be able to update any field of a record except the ID
	public boolean update(int id, String name, String description, String size, double price) {
		em.getTransaction().begin();
		Product foundProduct = em.find(Product.class, id);
		foundProduct.setName(name);
		foundProduct.setDescription(description);
		foundProduct.setSize(size);
		foundProduct.setPrice(price);
		em.getTransaction().commit();
		cleanup();
		return true;

	}

//clearAll
	public void clearAll() {
	  this.em.getTransaction().begin();
	  em.createQuery("DELETE FROM Product").executeUpdate();
	  Product product = new Product();
	  em.remove(product);
	  em.getTransaction().commit();
	  }
	public void close() {
		cleanup();
	}

	
	
}
