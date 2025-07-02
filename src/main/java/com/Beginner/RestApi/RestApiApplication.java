package com.Beginner.RestApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class RestApiApplication {

	public static void main(String[] args) {
		System.out.println("Spring application loaded");
		SpringApplication.run(RestApiApplication.class, args);
	}


}
