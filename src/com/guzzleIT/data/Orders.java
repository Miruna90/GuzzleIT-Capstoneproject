/*
 * Filename: Orders.java
* Author: Mirunalini
* 03/10/2020 
 */
package com.guzzleIT.data;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import java.util.List;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Order
 *
 */
@Entity
@NamedQueries({ @NamedQuery(query = "select o from Orders o where o.id=:id", name = "FindOrdersById"),
	@NamedQuery(query = "delete from Orders o WHERE o.id=:id", name = "DeleteOrdersById"),
	@NamedQuery(query = "delete from Orders", name = "DeleteAllOrders") })


public class Orders implements Serializable {
	
	private static final long serialVersionUID = 1L;
	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
//	@Column(name = "order_date")
//	private String orderDate;
	   @Temporal(TemporalType.DATE)
	    private Date orderDate;

	@Column(name = "order_status")
	private String orderStatus;
	@Column(name = "spl_instructions")
	private String splInstructions;
	
	@OneToMany(targetEntity = OrderDetails.class)
		private List<OrderDetails> odList;


	/**
	 * @param id
	 * @param orderDate
	 * @param orderStatus
	 * @param splInstructions
	 * @param odList
	 */
	public Orders(Integer id, Date orderDate, String orderStatus, String splInstructions,
			List<OrderDetails> odList) {
		super();
		this.id = id;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
		this.splInstructions = splInstructions;
		this.odList = odList;
	}

	public Orders() {
		super();
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the orderDate
	 */
	public Date getOrderDate() {
		return orderDate;
	}

	/**
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 * @return the orderStatus
	 */
	public String getOrderStatus() {
		return orderStatus;
	}

	/**
	 * @param orderStatus the orderStatus to set
	 */
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	/**
	 * @return the splInstructions
	 */
	public String getSplInstructions() {
		return splInstructions;
	}

	/**
	 * @param splInstructions the splInstructions to set
	 */
	public void setSplInstructions(String splInstructions) {
		this.splInstructions = splInstructions;
	}

	/**
	 * @return the opdList
	 */
	public List<OrderDetails> getOdList() {
		return odList;
	}

	/**
	 * @param opdList the opdList to set
	 */
	public void setOdList(List<OrderDetails> odList) {
		this.odList = odList;
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((odList == null) ? 0 : odList.hashCode());
		result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
		result = prime * result + ((orderStatus == null) ? 0 : orderStatus.hashCode());
		result = prime * result + ((splInstructions == null) ? 0 : splInstructions.hashCode());
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
		Orders other = (Orders) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (odList == null) {
			if (other.odList != null)
				return false;
		} else if (!odList.equals(other.odList))
			return false;
		if (orderDate == null) {
			if (other.orderDate != null)
				return false;
		} else if (!orderDate.equals(other.orderDate))
			return false;
		if (orderStatus == null) {
			if (other.orderStatus != null)
				return false;
		} else if (!orderStatus.equals(other.orderStatus))
			return false;
		if (splInstructions == null) {
			if (other.splInstructions != null)
				return false;
		} else if (!splInstructions.equals(other.splInstructions))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Orders [id=");
		builder.append(id);
		builder.append(", orderDate=");
		builder.append(orderDate);
		builder.append(", orderStatus=");
		builder.append(orderStatus);
		builder.append(", splInstructions=");
		builder.append(splInstructions);
		builder.append(", odList=");
		builder.append(odList);
		builder.append("]");
		return builder.toString();
	}


	

	
   
}
