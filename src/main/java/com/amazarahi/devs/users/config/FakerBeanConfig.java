/**
 * 
 */
package com.amazarahi.devs.users.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.javafaker.Faker;

/**
 * @author Amazarashi
 *
 */
@Configuration
public class FakerBeanConfig {
	//Definiciion forma explicita
	@Bean
	public Faker getFaker() 
	{
		return new Faker();
	}

}
