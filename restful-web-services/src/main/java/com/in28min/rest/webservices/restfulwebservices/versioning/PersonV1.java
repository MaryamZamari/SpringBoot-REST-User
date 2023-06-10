package com.in28min.rest.webservices.restfulwebservices.versioning;

public class PersonV1 {

	private String name;

	public PersonV1(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public String setName() {
		return name;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}
	
	
}
