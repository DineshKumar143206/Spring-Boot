package com.SBUP.repository;

import org.springframework.data.repository.CrudRepository;

import com.SBUP.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
