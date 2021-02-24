package com.ritesh.rest.webServices.restfulwebservices.user;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private int usersCount = 3;

	private static List<User> users = new ArrayList<User>();
	
	static {
		users.add(new User("Ritesh", 1, new Date(0)));
		users.add(new User("Rachel", 2, new Date(0)));
		users.add(new User("Joey", 3, new Date(0)));
	}
	
	public List<User> findAll() {
		return users;
	}
	
	public User save(User user){
		if(user.getId() == null) {
			user.setId(++usersCount);
		}
		users.add(user);
		return user;
	}
	
	public User findOne(int id) {
		for(User u : users) {
			if(u.getId() == id) {
				return u;
			}
		}
		return null;
	}
	
	public User deleteByID(int id) {
		Iterator<User> it= users.iterator();
		while(it.hasNext()) {
			User user = it.next();
			if(user.getId() == id) {
				it.remove();
				return user;
			}
		}	
		return null;
	}
	
}
