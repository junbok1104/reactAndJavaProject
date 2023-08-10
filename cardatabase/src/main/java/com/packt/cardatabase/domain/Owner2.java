package com.packt.cardatabase.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Owner2 {
// 다대다 관게용
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ownerid;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "car_owner",
			joinColumns = {@JoinColumn(name="ownerid")},
			inverseJoinColumns = {@JoinColumn(name = "id")})
	private Set<Car2> cars =  new HashSet<Car2>();
	
	private String firstname, lastname;
	
	public Owner2() {}

	public Owner2(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}
	

	public Long getOwnerid() {
		return ownerid;
	}

	public void setOwnerid(Long ownerid) {
		this.ownerid = ownerid;
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
	};
	
	
}
