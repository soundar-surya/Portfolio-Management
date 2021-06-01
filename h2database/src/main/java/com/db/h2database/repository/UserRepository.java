package com.db.h2database.repository;

import org.springframework.data.repository.CrudRepository;
import com.db.h2database.model.User;

public interface UserRepository extends CrudRepository<User, Integer>{}
