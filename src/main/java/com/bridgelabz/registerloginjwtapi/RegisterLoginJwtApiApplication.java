package com.bridgelabz.registerloginjwtapi;

import com.bridgelabz.registerloginjwtapi.entity.User;
import com.bridgelabz.registerloginjwtapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class RegisterLoginJwtApiApplication {

	@Autowired
	private UserRepository repository;

	@PostConstruct
	public void initUsers() {
		List<User> users = Stream.of(
				new User(101, "Nikhil", "1234", "deshmukhnikhil81@gmail.com"),
				new User(102, "Amol", "pwd1", "user1@gmail.com"),
				new User(103, "Sushant", "pwd2", "user2@gmail.com"),
				new User(104, "Mayur", "pwd3", "user3@gmail.com")
		).collect(Collectors.toList());
		repository.saveAll(users);
	}

	public static void main(String[] args) {
		SpringApplication.run(RegisterLoginJwtApiApplication.class, args);
		System.out.println("Welcome to Register and Login Api");
	}

}