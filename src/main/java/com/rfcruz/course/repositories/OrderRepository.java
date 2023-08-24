package com.rfcruz.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rfcruz.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

	
}
