/**
 * 
 */
package com.amazarahi.devs.users.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Amazarashi
 *
 */
@RestController //Steorotyppe
@RequestMapping("/hello")
public class DevsController {
	
	@GetMapping
	public String helloWorld()
	{
		return "Hello World !";
	}

}
