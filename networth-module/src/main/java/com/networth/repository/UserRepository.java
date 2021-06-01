package com.networth.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.networth.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
	User findByUsername(String username);

}
