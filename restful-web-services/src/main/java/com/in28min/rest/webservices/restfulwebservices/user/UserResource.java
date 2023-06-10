package com.in28min.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
public class UserResource {

	private UserDaoService service;
	
	public UserResource(UserDaoService service) {
		this.service= service;
	}
	
//Get /users
@GetMapping("/users")
public List<User> retrieveAllUsers(){
	return service.findAll();
}

//Get /users
/*
 * HATEAOS : EntityModel
 * 			 WebMvcLinkBuilder    DO LATER
 */
@GetMapping("/users/{id}")
public User retrieveUser(@PathVariable int id){
	User user=  service.findOne(id);
	if(user == null) {
		throw new UserNotFoundException("id: " + id);
	}
	return user;
}

@PostMapping("/users")
public ResponseEntity<User> addUser(@Valid @RequestBody User user){
	User savedUser = service.addUser(user);
	// /users/4 ==> /users/{id} , user.getID
	URI location = ServletUriComponentsBuilder
			.fromCurrentRequest().path("/{id}")
			.buildAndExpand(savedUser.getId()).toUri();
	return ResponseEntity.created(location).build();
}

@PutMapping("/users/{id}")
public void updateUser(@RequestBody User user, @PathVariable int id) {
	service.updateUser(user);
}

@DeleteMapping("/users/{id}")
public void deleteUser(@PathVariable int id){
	User user=  service.findOne(id);
	if(user == null) {
		throw new UserNotFoundException("id: " + id);
	}
	service.deleteUser(id);
}
	
}
