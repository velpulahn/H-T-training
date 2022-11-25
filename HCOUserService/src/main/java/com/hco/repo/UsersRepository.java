package com.hco.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hco.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {

	//Users getRoleByUserId(int userId);
	@Query(value ="SELECT * FROM Users WHERE user_id= :userId", nativeQuery = true)
	Users getRoleByUserId(int userId);

	@Query(value ="SELECT * FROM Users WHERE user_name= :username", nativeQuery = true)
	Users findByUserName(String username);

}
