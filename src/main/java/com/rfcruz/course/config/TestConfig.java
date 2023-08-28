package com.rfcruz.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.rfcruz.course.entities.Category;
import com.rfcruz.course.entities.Order;
import com.rfcruz.course.entities.Product;
import com.rfcruz.course.entities.User;
import com.rfcruz.course.entities.enums.OrderStatus;
import com.rfcruz.course.repositories.CategoryRepository;
import com.rfcruz.course.repositories.OrderRepository;
import com.rfcruz.course.repositories.ProductRepository;
import com.rfcruz.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, ""); 
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, ""); 
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, ""); 
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, ""); 
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
	
		User u1 = new User(null, "Maria", "maria@gmail.com", "999999999", "1234567");
		User u2 = new User(null, "Joao", "joao@gmail.com", "888888888", "1234567");
		
		Order o1 = new Order(null, Instant.parse("2023-08-24T12:50:55Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2023-08-25T12:50:55Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2023-08-26T12:50:55Z"), OrderStatus.WAITING_PAYMENT, u1);
		
		userRepository.saveAll(Arrays.asList(u1,u2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
	}	
}
