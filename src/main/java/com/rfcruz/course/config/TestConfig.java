package com.rfcruz.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.rfcruz.course.entities.Order;
import com.rfcruz.course.entities.User;
import com.rfcruz.course.repositories.OrderRepository;
import com.rfcruz.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public void run(String... args) throws Exception {
	
		User u1 = new User(null, "Maria", "maria@gmail.com", "999999999", "1234567");
		User u2 = new User(null, "Joao", "joao@gmail.com", "888888888", "1234567");
		
		Order o1 = new Order(null, Instant.parse("2023-08-24T12:50:55Z"), u1);
		Order o2 = new Order(null, Instant.parse("2023-08-25T12:50:55Z"), u2);
		Order o3 = new Order(null, Instant.parse("2023-08-26T12:50:55Z"), u1);
		
		userRepository.saveAll(Arrays.asList(u1,u2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
	}	
}
