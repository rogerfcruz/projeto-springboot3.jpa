package com.rfcruz.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rfcruz.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
}
