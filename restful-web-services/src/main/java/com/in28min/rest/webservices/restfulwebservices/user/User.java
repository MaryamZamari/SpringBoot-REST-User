package com.in28min.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity(name="user_details")
public class User {
	
	@Id
	@GeneratedValue
	private Integer id; 
	
	@Size(min= 2, message="name should have atleast 2 characters")
	@JsonProperty("user_name")
	private String name; 
	@Past
	private LocalDate birdthday;
	
	@OneToMany(mappedBy= "user")
	@JsonIgnore //we dont want the posts to be part of the response
	private List<Post> posts; 
	
	public User(Integer id, String name, LocalDate birdthday, List<Post> posts) {
		super();
		this.id = id;
		this.name = name;
		this.birdthday = birdthday;
		this.posts = posts;
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

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birdthday=" + birdthday + " posts= " + posts+ "]";
	}
	
	
	
	
}
