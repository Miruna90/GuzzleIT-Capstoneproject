/*
 * Filename: Users.java
* Author: Mirunalini
* 03/10/2020 
 */
package com.guzzleIT.data;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Users
 *
 */
@Entity
@NamedQueries({ @NamedQuery(query = "select u from Users u where u.id=:id", name = "FindById"),
	 @NamedQuery(query = "select u from Users u where u.email=:email", name = "FindByEmail"),
	@NamedQuery(query = "delete from Users u WHERE u.id=:id", name = "DeleteById"),
	@NamedQuery(query = "delete from Users", name = "DeleteAllUsers"),
	@NamedQuery(query ="select u from Users u where u.email =:email", name ="FindUser"),
	@NamedQuery(query ="select u.email,u.password from Users u where u.email =:email AND u.password=:password", name ="LoginUser")})


public class Users implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String email;
	private String password;
	

	public Users() {
		super();
	} 
	/**
	 * @param id
	 * @param userName
	 * @param email
	 * @param password
	 */
	public Users(String email, String password) {
		super();
		this.setEmail(email);
		this.setPassword(password);
	}
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}     
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		Users other = (Users) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Users [id=");
		builder.append(id);
		builder.append(", email=");
		builder.append(email);
		builder.append(", password=");
		builder.append(password);
		builder.append("]");
		return builder.toString();
	}
	
   
}
