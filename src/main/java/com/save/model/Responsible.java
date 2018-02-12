package com.save.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Responsible {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	@Column
	private String firstname;
	
	@NotNull
	@Column
	private String lastname;
	
	@Column
	private Integer postCode;
	
	@Column
	private String city;
	
	@Column
	private String street;
	
	@Column
	private Integer number;
	
	@NotNull
	@Column
	private String email;
	
	@Column
	private String phone;
	
	@Column
	private String connection;
	
	
	
	
	public Responsible() {
		
	}


	public Responsible(String firstname, String lastname, Integer postCode, String city, String street, Integer number,
			String email, String phone) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.postCode = postCode;
		this.city = city;
		this.street = street;
		this.number = number;
		this.email = email;
		this.phone = phone;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public Integer getPostCode() {
		return postCode;
	}


	public void setPostCode(Integer postCode) {
		this.postCode = postCode;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public Integer getNumber() {
		return number;
	}


	public void setNumber(Integer number) {
		this.number = number;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getConnection() {
		return connection;
	}


	public void setConnection(String connection) {
		this.connection = connection;
	}
	
	


	
	
	
	
	

}
