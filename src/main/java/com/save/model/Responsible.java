package com.save.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Responsible {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="responsible_generator")
	@SequenceGenerator(name="responsible_generator", sequenceName="responsible_seq", allocationSize=1)
	private Long id;
	
	@NotNull
	@Size(min=2, max=30, message="{victim.firstname}")
	@Column
	private String firstname;
	
	@NotNull
	@Size(min=2, max=30, message="{victim.lastname}")
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
	@NotEmpty
	@Email
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
