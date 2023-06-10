package com.in28min.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
	
	@GetMapping("/v1/person")
		public PersonV1 getFirstVersionOfPerson() {
			return new PersonV1("Bob Marley");
		}
	
	@GetMapping("/v2/person")
	public PersonV2 getSecondVersionOfPerson() {
		return new PersonV2(new Name("Bob", "Marley"));
	}
	
	@GetMapping(path="/person", params="version=1" )
	public PersonV1 getFirstVersionOfPersonRequestParameter() {
		return new PersonV1("Bob Marley");
	}

	@GetMapping(path= "/person", params= "version=2")
	public PersonV2 getSecondVersionOfPersonRequestParameter() {
		Name name= new Name("Bob", "Marley");
		PersonV2 personV2= new PersonV2(name);
		
		return personV2;
		//return new PersonV2(new Name("Bob", "Marley"));
	}
	
	@GetMapping(path="/person/header", headers="X-API-Version=1" )
	public PersonV1 getFirstVersionOfPersonRequestHeader() {
		return new PersonV1("Bob Marley");
	}

	@GetMapping(path= "/person/header", params= "X-API-Version=2")
	public PersonV2 getSecondVersionOfPersonRequestHeader() {
		return new PersonV2(new Name("Bob", "Marley"));
	}
	
	@GetMapping(path="/person/accept", produces="application/vnd.company.app-v1+json" )
	public PersonV1 getFirstVersionOfPersonRequestAccept() {
		return new PersonV1("Bob Marley");
	}
}
