package com.backend.webproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication()
public class WebprojectApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(WebprojectApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(WebprojectApplication.class);
		System.out.println("Running...");
	}
<<<<<<< HEAD
}
=======

	// public static void main(String[] args) {
	// SpringApplication.run(WebprojectApplication.class, args);
	// }

}
>>>>>>> d371606c4ec9583c50afa8970f0b1de23a57ed85
