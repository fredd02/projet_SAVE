package com.save.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity(name="victim")
public class Victim {
	
	public static enum LANGUAGE {
		DEUTSCH,ENGLISH,FRANCAIS,VLAAMS
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="victim_generator")
	@SequenceGenerator(name="victim_generator", sequenceName="victim_seq", allocationSize=1)
	private Long id;
	
	
	//@Size(min=2, max=30, message="{victim.firstname}")
	@Column
	private String firstname;
	
	@NotEmpty
	@Size(min=2, max=30, message="{victim.lastname}")
	@Column
	private String lastname;
	
	@Min(value=0, message="{victim.age}")
	@Max(value=99, message="{victim.age}")
	@Column
	private Integer age;
	
	@Column
	private Integer month;
	
	//@NotNull
	//@Pattern(regexp="^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$", message="{date.valid}")
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Column
	private Date birthdate;
	
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Column
	private Date accidentdate;
	
	
	@Min(value=0) //for M
	@Max(value=1) // for F
	@Column
	private Integer sex;
	
	@Column
	private LANGUAGE language;
	
	@ManyToOne
	@JoinColumn(name="FKLocation")
	private Location location;
	
	@Column
	private Integer virtualPanel;
	
	@ManyToMany
	@JoinTable(name="victimeResponsible", joinColumns= @JoinColumn(name="FKVictim"),
			inverseJoinColumns= @JoinColumn(name="FKResponsible"))
	private  Set<Responsible> responsibles = new HashSet<Responsible>();

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
	
	

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
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
	
	
	
	public Set<Responsible> getResponsibles() {
		return responsibles;
	}

	public void setResponsibles(Set<Responsible> responsibles) {
		this.responsibles = responsibles;
	}

	public void addResponsible(Responsible responsible) {
		responsibles.add(responsible);
	}
	
	public void deleteResponsible(Responsible responsible) {
		responsibles.remove(responsible);
	}

	public LANGUAGE getLanguage() {
		return language;
	}

	public void setLanguage(LANGUAGE language) {
		this.language = language;
	}

	public Integer getVirtualPanel() {
		return virtualPanel;
	}

	public void setVirtualPanel(Integer virtualPanel) {
		this.virtualPanel = virtualPanel;
	}

	
	
	
	
	
	
	

}
