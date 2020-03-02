package com.guzzleIT.data;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.text.NumberFormat;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Product
 *
 */
@Entity
@NamedQueries({ @NamedQuery(query = "select p from Product p where p.id=:id", name = "FindProductsById"),
	@NamedQuery(query = "delete from Product p WHERE p.id=:id", name = "DeleteProductsById"),
	@NamedQuery(query = "delete from Product", name = "DELETE FROM Product"),
	@NamedQuery(query="SELECT p FROM Product p WHERE p.productCode = :productCode",name="SelectProductsByCode")})


public class Product implements Serializable {

	private static final long serialVersionUID = 1L;  
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String productCode;
	private String name;
	private String description;
	private String size;
	private double price;
	


	public Product() {
		super();
	} 



	/**
	 * @param id
	 * @param productCode
	 * @param name
	 * @param description
	 * @param size
	 * @param price
	 * @param odList
	 */
	public Product(String productCode, String name, String description, String size, double price) {
		super();
		this.setId(id);
		this.setProductCode(productCode);
		this.setName(name);
		this.setDescription(description);
		this.setSize(size);
		this.setPrice(price);
		
	}



	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	public String getSize() {
		return this.size;
	}

	public void setSize(String size) {
		this.size = size;
	}   
	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}


	/**
	 * @return the productCode
	 */
	public String getProductCode() {
		return productCode;
	}



	/**
	 * @param productCode the productCode to set
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}



	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String getPriceCurrencyformat() {
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		return currency.format(price);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((productCode == null) ? 0 : productCode.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
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
		Product other = (Product) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (productCode == null) {
			if (other.productCode != null)
				return false;
		} else if (!productCode.equals(other.productCode))
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [id=");
		builder.append(id);
		builder.append(", productCode=");
		builder.append(productCode);
		builder.append(", name=");
		builder.append(name);
		builder.append(", description=");
		builder.append(description);
		builder.append(", size=");
		builder.append(size);
		builder.append(", price=");
		builder.append(price);
		builder.append("]");
		return builder.toString();
	}



   
}
