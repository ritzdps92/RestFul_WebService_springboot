package com.ritesh.rest.webServices.restfulwebservices.user;

import java.util.List;


import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class UserResource {
	
	@Autowired
	private UserDaoService service;

	//GET /users
	//retrieve all users
	@GetMapping("/users")
	public MappingJacksonValue retrieveAllUsers(){
		
		List<User> user = service.findAll();
		//Implementing dynamic filtering to filter out some contents from end json.
		// If user.java class have 4 fields and you want to return field1,2 and 3 then we can do with filtering
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("name", "id");
		FilterProvider filters = new SimpleFilterProvider().addFilter("userfilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(user);
		mapping.setFilters(filters);
		return mapping;
		//filtering ends
		
		//return user;
	}
	
	
	//GET /user/{id}
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id) {
		User u = service.findOne(id);
		if(u == null) {
			throw new UserNotFoundException("id - " + id);
		}
		
		//I want to return a link to get all users so we can either hardcode it but then if url changes we will have to change this as well
		
		//We will use Hateoas to link controller methods and send it
		return u;
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		//HTTPHeaders responseHeaders = new HTTPHeaders();
		User usercreated = service.save(user);
		//return ResponseEntity.created(null).build();
		return new ResponseEntity<>(usercreated, null, HttpStatus.CREATED);
	}
	
	//delete user by id
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		User u = service.deleteByID(id);
		if(u == null) {
			throw new UserNotFoundException("id - " + id);
		}
	}
	
	
}
