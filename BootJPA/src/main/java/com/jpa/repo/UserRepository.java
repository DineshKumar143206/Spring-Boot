package com.jpa.repo;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.jpa.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	
	public List<User> findByName(String name);
}
