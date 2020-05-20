package com.promineotech.qAEngine.repository;

import org.springframework.data.repository.CrudRepository;

import com.promineotech.qAEngine.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
		
		public User findByUsername(String username);

}
