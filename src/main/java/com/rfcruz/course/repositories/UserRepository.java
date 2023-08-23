package com.rfcruz.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rfcruz.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	
}
