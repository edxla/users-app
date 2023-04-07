package com.amazarahi.devs.users.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import com.amazarahi.devs.users.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

}
