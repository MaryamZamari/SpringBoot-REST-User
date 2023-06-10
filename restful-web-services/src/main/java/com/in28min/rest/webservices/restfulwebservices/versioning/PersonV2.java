package com.in28min.rest.webservices.restfulwebservices.versioning;

public class PersonV2  {

	private Name name;
	
	public PersonV2(Name name2) {
		// TODO Auto-generated constructor stub
		this.name= name2;
	}

	public Name getName() {
		return name;
	}
	
	public Name setName() {
		return name;
	}

	@Override
	public String toString() {
		return "PersonV2 [name=" + name + "]";
	}

}
