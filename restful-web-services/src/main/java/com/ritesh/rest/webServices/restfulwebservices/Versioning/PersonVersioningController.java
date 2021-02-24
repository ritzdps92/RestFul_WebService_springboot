package com.ritesh.rest.webServices.restfulwebservices.Versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

	@GetMapping("v1/person")
	public PersonV1 personv1() {
		return new PersonV1("Rachel Green");
	}
	
	@GetMapping("v2/person")
	public PersonV2 personv2() {
		Name n = new Name("Rachel", "Green");
		PersonV2 person = new PersonV2(n);
		return person;		
		//return new PersonV2(new Name("Rachel", "Green"));
	}
	
	//param Versioning
	@GetMapping(value = "person/param", params = "version=1")
	public PersonV1 paramv1() {
		return new PersonV1("Joey Tribiaani");
	}
	
	@GetMapping(value="person/param", params = "version=2" )
	public PersonV2 paramv2() {
		Name n = new Name("Joey", "Tribiaani");
		PersonV2 person = new PersonV2(n);
		return person;		
		//return new PersonV2(new Name("Rachel", "Green"));
	}
	
	//header Versioning
	@GetMapping(value = "person/header", headers = "X-API-VERSION=1")
	public PersonV1 headerv1() {
		return new PersonV1("Phoebe Buffay");
	}
	
	@GetMapping(value="person/header", headers = "X-API-VERSION=2" )
	public PersonV2 headerv2() {
		Name n = new Name("Phoebe", "Buffay");
		PersonV2 person = new PersonV2(n);
		return person;		
		//return new PersonV2(new Name("Rachel", "Green"));
	}
	
	//producer versioning
	@GetMapping(value = "person/producer", produces = "application/sapLabs_v1+json")
	public PersonV1 producerv1() {
		return new PersonV1("Phoebe Buffay");
	}
	
	@GetMapping(value="person/producer", produces = "application/sapLabs_v2+json" )
	public PersonV2 producerv2() {
		Name n = new Name("Phoebe", "Buffay");
		PersonV2 person = new PersonV2(n);
		return person;		
		//return new PersonV2(new Name("Rachel", "Green"));
	}
	
	
}
