package com.save.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity(name="victim")
public class Victim {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	@Size(min=2, max=30, message="le nom doit faire entre 2 et 30 caratères")
	@Column
	private String firstname;
	
	@NotNull
	@Size(min=2, max=30, message="le nom doit faire entre 2 et 30 caratères")
	@Column
	private String lastname;
	
	@NotNull
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Column
	private Date birthdate;
	
	@NotNull
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Column
	private Date accidentdate;
	
	@NotNull
	@Min(value=0)
	@Max(value=1)
	@Column
	private Integer sex;
	
	@ManyToOne
	@JoinColumn(name="FKLocation")
	private Location location;

	public Victim() {
		
	}

	public Victim(String firstname, String lastname, Date birthdate, Date accidentdate, Integer sex) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthdate = birthdate;
		this.accidentdate = accidentdate;
		this.sex = sex;
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

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public Date getAccidentdate() {
		return accidentdate;
	}

	public void setAccidentdate(Date accidentdate) {
		this.accidentdate = accidentdate;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	
	
	
	

}
