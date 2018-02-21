package com.save.model;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.joda.time.DateTime;
import org.joda.time.Years;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Star {
	
	private String firstname;
	
	private String lastname;
	
	private Integer age;
	
	private Date accidentDate;
	
	private String Language;
	
	private Double latitude;
	
	private Double longitude;
	
	private Integer virtualPanel;
	
	

	public Star() {
		
	}



	public Star(String lastname, Integer age, Date accidentDate, Double latitude, Double longitude,String language, Integer virtualPanel) {
		super();
		
		this.lastname = lastname;
		this.age = age;
		this.accidentDate = accidentDate;
		this.latitude = latitude;
		this.longitude = longitude;
		this.Language = language;
		this.virtualPanel = virtualPanel;
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



	public Integer getAge() {
		return age;
	}



	public void setAge(Integer age) {
		this.age = age;
	}

	@Temporal(TemporalType.DATE)
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd/MM/yyyy", timezone="IST")
	public Date getAccidentDate() {
		return accidentDate;
	}



	public void setAccidentDate(Date accidentDate) {
		this.accidentDate = accidentDate;
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
	
	
	
	public String getLanguage() {
		return Language;
	}



	public void setLanguage(String language) {
		Language = language;
	}



	public Integer getVirtualPanel() {
		return virtualPanel;
	}



	public void setVirtualPanel(Integer virtualPanel) {
		this.virtualPanel = virtualPanel;
	}



	public Star(Victim victim) {
		//this.firstname = victim.getFirstname();
		this.lastname = victim.getLastname();
		this.age = getAge(victim.getBirthdate(), victim.getAccidentdate());
		//this.accidentDate = victim.getAccidentdate();
		this.latitude = victim.getLocation().getLatitude();
		this.longitude = victim.getLocation().getLongitude();
		this.Language = (victim.getLanguage() == null ? "ENGLISH" : victim.getLanguage().toString());
		this.virtualPanel = victim.getVirtualPanel();
	}
	
	public Integer getAge(Date d1, Date d2) {
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTime d1_new = new DateTime(d1.getTime());
		DateTime d2_new = new DateTime(d2.getTime());
		Years years = Years.yearsBetween(d1_new, d2_new);
		return years.getYears();
	
	}



	@Override
	public String toString() {
		return "Star [firstname=" + firstname + ", lastname=" + lastname + ", age=" + age + ", accidentDate="
				+ accidentDate + ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}
	
	
	
	

}
