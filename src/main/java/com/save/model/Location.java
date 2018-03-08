package com.save.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="location")
public class Location {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	@Column
	private Integer postCode;
	
	@Column
	private String city;
	
	@Column
	private String street;
	
	@Column
	private Integer number;
	
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




	@Column
	private Double latitude;
	
	@Column
	private Double longitude;

	
	
	
	public Location() {
		
	}




	public Location(Integer postCode, String city, String street, Integer number, Double latitude, Double longitude) {
		super();
		this.postCode = postCode;
		this.city = city;
		this.street = street;
		this.number = number;
		this.latitude = latitude;
		this.longitude = longitude;
	}




	public Location(Integer postCode, String city) {
		super();
		this.postCode = postCode;
		this.city = city;
	}




	public Long getId() {
		return id;
	}




	public void setId(Long l) {
		id = l;
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




	public Double getLatitude() {
		return latitude;
	}




	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}




	public Double getLongitude() {
		return longitude;
	}




	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
	

}
