package com.in28min.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class User {

	private Integer id; 
	@Size(min= 2, message="name should have atleast 2 characters")
	private String name; 
	@Past
	private LocalDate birdthday;
	
	public User(Integer id, String name, LocalDate birdthday) {
		super();
		this.id = id;
		this.name = name;
		this.birdthday = birdthday;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirdthday() {
		return birdthday;
	}

	public void setBirdthday(LocalDate birdthday) {
		this.birdthday = birdthday;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birdthday=" + birdthday + "]";
	}
	
	
	
	
}
