package com.SCM.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.SCM.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	public User getUserByEmail(@Param ("email") String email);
}
