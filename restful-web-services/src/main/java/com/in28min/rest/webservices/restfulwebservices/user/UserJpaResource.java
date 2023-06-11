package com.in28min.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in28min.rest.webservices.restfulwebservices.jpa.PostRepository;
import com.in28min.rest.webservices.restfulwebservices.jpa.UserRepository;

import jakarta.validation.Valid;

@RestController
public class UserJpaResource {

	private UserDaoService service;
	private UserRepository userRepository;
	private PostRepository postRepository;
	
	public UserJpaResource(UserDaoService service, UserRepository userRepository, PostRepository postRepository) {
		this.service= service;
		this.userRepository= userRepository;
		this.postRepository= postRepository;
	}
	
//Get /users
	@GetMapping("/jpa/users")
	public List<User> retrieveUsers(){
		List<User> users= userRepository.findAll();

		for(User user : users) {
			List<Post> posts = user.getPosts();
				}
		return users;
	}

	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> retrievePostsForAUser(@PathVariable int userId){
		//return service.findAll();
		Optional<User> user= userRepository.findById(userId);
		if(user.isEmpty()) {
			throw new UserNotFoundException("id: " + userId);
		}
		List<Post> posts = user.get().getPosts();
		return posts;
	}

//Get /users
/*
 * HATEAOS : EntityModel
 * 			 WebMvcLinkBuilder    DO LATER
 */
	@GetMapping("jpa/users/{id}")
	public Optional<User> retrieveUser(@PathVariable int id){
		//User user=  service.findOne(id);
		Optional<User> user= userRepository.findById(id);
		//if(user == null) {
		if(user.isEmpty()) {
			throw new UserNotFoundException("id: " + id);
		}
		return user;
	}
	
	@PostMapping("jpa/users")
	public ResponseEntity<User> addUser(@Valid @RequestBody User user){
		//User savedUser = service.addUser(user);
		User savedUser= userRepository.save(user);
		// /users/4 ==> /users/{id} , user.getID
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PostMapping("/jpa/users/{id}/posts")
	public void createPostForAUser(@Valid @RequestBody Post post, @PathVariable int userId){
	Optional<User> user=	userRepository.findById(userId);
		if(user.isEmpty()) {
			throw new UserNotFoundException("id: " + userId);
		}
		post.setUser(user.get());
		postRepository.save(post);
//		URI location = ServletUriComponentsBuilder ============> COmplete later
//				.fromCurrentRequest().path("/{id}")
//				.buildAndExpand(savedUser.getId()).toUri();
//		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("jpa/users/{id}")
	public void updateUser(@RequestBody User user, @PathVariable int id) {
		service.updateUser(user);
	}
	
	@DeleteMapping("jpa/users/{id}")
	public void deleteUser(@PathVariable int id){
		User user=  service.findOne(id);
		if(user == null) {
			throw new UserNotFoundException("id: " + id);
		}
		service.deleteUser(id);
	}
		
}
