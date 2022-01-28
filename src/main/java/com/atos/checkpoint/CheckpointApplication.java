package com.atos.checkpoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication()
public class CheckpointApplication {

    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(CheckpointApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(CheckpointApplication.class);
		System.out.println("Running...");
    }
}
