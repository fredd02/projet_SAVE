package com.save.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Location {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int Long;
	
	@Column
	private Integer postCode;
	
	@Column
	private String City;
	
	@Column
	private Double latitude;
	
	@Column
	private Double longitude;

	
	
	
	public Location() {
		
	}




	public Location(Integer postCode, String city, Double latitude, Double longitude) {
		super();
		this.postCode = postCode;
		City = city;
		this.latitude = latitude;
		this.longitude = longitude;
	}




	public Location(Integer postCode, String city) {
		super();
		this.postCode = postCode;
		City = city;
	}




	public int getLong() {
		return Long;
	}




	public void setLong(int l) {
		Long = l;
	}




	public Integer getPostCode() {
		return postCode;
	}




	public void setPostCode(Integer postCode) {
		this.postCode = postCode;
	}




	public String getCity() {
		return City;
	}




	public void setCity(String city) {
		City = city;
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
