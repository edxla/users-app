package com.amazarahi.devs.users.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.amazarahi.devs.users.entities.Profile;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Integer>{
	

}
