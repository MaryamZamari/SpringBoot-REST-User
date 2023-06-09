package com.in28min.rest.webservices.restfulwebservices.user;

import java.util.List;
import java.util.function.Predicate;

import javax.management.RuntimeErrorException;

import java.time.LocalDate;
import java.util.ArrayList;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;


@Component  //business logic 
public class UserDaoService {
	
	private static List<User> users = new ArrayList<>(); 

static {
	users.add(new User(1, "Ranga", LocalDate.now().minusYears(30)));
	users.add(new User(2, "heidi",LocalDate.now().minusYears(25)));
	users.add(new User(3, "Guilda", LocalDate.now().minusYears(7)));
	users.add(new User(4, "Ray", LocalDate.now().minusYears(40)));
}
	/*
	 * JPA/Hibernate -> Database
	 * UserStaticDaoService -> Static List
	 * 1.public List<User> findAll(){
	 * 2.Public User save(User user){
	 * 3.public User findOne(int id){
	 */
	

	public List<User> findAll(){
		return users;	
	}
	
	public User findOne(int id) {
		
//		for(User user: users) {
//			if(!user.getId().equals(id)) {
//				return user;	
//			}
//			throw new RuntimeErrorException(null, "User not found!");
//		}
//		return user;
		Predicate<? super User> predicateSpecificUser = u -> u.getId().equals(id);
		return users.stream().filter(predicateSpecificUser).findFirst().orElse(null);//.get();
	}
	
	public User addUser(User user) {
		users.add(user);
		return user;
	}
	
	public void updateUser(User user) {
		user.setName(user.getName());
		user.setBirdthday(user.getBirdthday());
	}
	
	public void deleteUser(int id) {
		Predicate<? super User> predicateSpecificUser = u -> u.getId().equals(id);
		users.removeIf(predicateSpecificUser);
	}
}
