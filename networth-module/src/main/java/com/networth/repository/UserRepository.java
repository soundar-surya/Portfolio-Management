package com.networth.repository;

import org.springframework.data.repository.CrudRepository;

import com.networth.model.User;

public interface UserRepository extends CrudRepository<User, Integer>{}
