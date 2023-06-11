package com.in28min.rest.webservices.restfulwebservices.jpa;
import java.util.List;

import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.jpa.repository.JpaRepository;


import com.in28min.rest.webservices.restfulwebservices.user.User;

public interface UserRepository extends JpaRepository<User, Integer>{






}
