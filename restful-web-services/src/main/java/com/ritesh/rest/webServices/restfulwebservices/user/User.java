package com.ritesh.rest.webServices.restfulwebservices.user;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;

//@JsonFilter("userfilter")
@Entity
public class User {

	@Size(min=2 , message="Name atlest should have 2 characters")
	private String name;
	@Id
	private Integer id;
	
	@Past
	//@JsonIgnore
	private Date birthdate;
	
	
	public User(String name, Integer id, Date birthdate) {
		super();
		this.name = name;
		this.id = id;
		this.birthdate = birthdate;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	
}
