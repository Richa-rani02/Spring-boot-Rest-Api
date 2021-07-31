package com.example.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TodoRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoRestApiApplication.class, args);
	}

}
