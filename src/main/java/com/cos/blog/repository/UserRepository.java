package com.cos.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.blog.model.User;


//jpa로 따지면 DAO
public interface UserRepository extends JpaRepository<User, Integer>{
	
}
