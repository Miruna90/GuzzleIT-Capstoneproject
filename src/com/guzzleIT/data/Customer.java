/*
 * Filename: Customer.java
* Author: Mirunalini
* 03/10/2020 
 */
package com.guzzleIT.data;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.criteria.Order;

/**
 * Entity implementation class for Entity: Customer
 *
 */
 @Entity
@NamedQueries({ @NamedQuery(query = "select c from Customer c where c.id=:id", name = "FindCustomersById"),
	@NamedQuery(query = "delete from Customer c WHERE c.id=:id", name = "DeleteCustomersById"),
	@NamedQuery(query = "delete from Customer", name = "DeleteAllCustomers") })

public class Customer implements Serializable {

	private static final long serialVersionUID = 1L; 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	private String phone;
	private String address;
	private String city;
	private String state;
	private String zipcode;
	 @OneToOne
	private Users users;
	
	
	 @OneToMany(targetEntity = Orders.class)
	private List<Orders> orderList;
//	 @OneToMany(mappedBy = "Customer")
//		private List<Orders> orderList;

	public Customer() {
		super();
	}
	
	

	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param password
	 * @param phone
	 * @param address
	 * @param city
	 * @param state
	 * @param zipcode
	 * @param users
	 * @param orderList
	 */
	public Customer(String firstName, String lastName, String phone,
			String address, String city, String state, String zipcode, Users users, List<Orders> orderList) {
		super();
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setPhone(phone);
		this.setAddress(address);
		this.setCity(city);
		this.setState(state);
		this.setZipcode(zipcode);
		this.setUsers(users);
		this.setOrderList(orderList);
	}




	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	
	/**
	 * @return the users
	 */
	public Users getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(Users users) {
		this.users = users;
	}

	/**
	 * @return the zipcode
	 */
	public String getZipcode() {
		return zipcode;
	}



	/**
	 * @param zipcode the zipcode to set
	 */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}



	/**
	 * @return the orderList
	 */
	public List<Orders> getOrderList() {
		return orderList;
	}

	/**
	 * @param orderList the orderList to set
	 */
	public void setOrderList(List<Orders> orderList) {
		this.orderList = orderList;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((orderList == null) ? 0 : orderList.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((users == null) ? 0 : users.hashCode());
		result = prime * result + ((zipcode == null) ? 0 : zipcode.hashCode());
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
		Customer other = (Customer) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (orderList == null) {
			if (other.orderList != null)
				return false;
		} else if (!orderList.equals(other.orderList))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		if (zipcode == null) {
			if (other.zipcode != null)
				return false;
		} else if (!zipcode.equals(other.zipcode))
			return false;
		return true;
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Customer [id=");
		builder.append(id);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", address=");
		builder.append(address);
		builder.append(", city=");
		builder.append(city);
		builder.append(", state=");
		builder.append(state);
		builder.append(", zipcode=");
		builder.append(zipcode);
		builder.append(", users=");
		builder.append(users);
		builder.append(", orderList=");
		builder.append(orderList);
		builder.append("]");
		return builder.toString();
	} 
	
	
}
	
