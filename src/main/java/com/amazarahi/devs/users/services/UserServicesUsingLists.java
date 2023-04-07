/**
 * 
 */
package com.amazarahi.devs.users.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.server.ResponseStatusException;

import com.amazarahi.devs.users.models.User;
import com.github.javafaker.Faker;

import jakarta.annotation.PostConstruct;

/**
 * @author Amazarashi
 *
 */
@SuppressWarnings("unused")
@Service
public class UserServicesUsingLists {
	@Autowired
	private Faker faker;
	
	private List<User> users = new ArrayList<>();

	//private User User users;
	//inicializar
	@PostConstruct
	public void init() 
	{
		for (int i = 0; i < 100; i++) {
			users.add(new User(faker.funnyName().name(), faker.name().username(), faker.dragonBall().character()));
			
		}	
	}
	
	//public List<User> getUsers()
	public List<User> getUsers(String startWith) {
		if(startWith!=null) 
		{
			return users.stream().filter(u->u.getUsername().startsWith(startWith)).collect(Collectors.toList());
		}else 
		{
			return users;
			
		}
		
	}
	
	public User getUserByUsername(String username) 
	{
		return users.stream().filter(u->u.getUsername().equals(username)).findAny()
		.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,String.
				format("User %s not found", username)));
		
	}
	
	public User createUser (User user) 
	{
		if(users.stream().anyMatch(u->u.getUsername().
				equals(user.getUsername()))) 
		{
			throw new ResponseStatusException(HttpStatus.CONFLICT,
					String.format("User %s already exixist", user.getUsername()));
		}
		
		users.add(user);
		return user;
		
	}
	
	public User updateUser(User user,String username) 
	{
		User userToBeUpdate = getUserByUsername(username);
		userToBeUpdate.setNickname(user.getNickname());
		userToBeUpdate.setPassword(user.getPassword());
		
		return userToBeUpdate;
		
	}
	
	
	public void deleteUser(String username) 
	{
		User userByUsername = getUserByUsername(username);
		users.remove(userByUsername);
		
	}

	
	

}
