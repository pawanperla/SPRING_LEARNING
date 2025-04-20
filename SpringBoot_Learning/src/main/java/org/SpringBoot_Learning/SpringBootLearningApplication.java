package org.SpringBoot_Learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;

// @SpringBootApplication(scanBasePackages = { "org.util", "org.SpringBoot_Learning" })
@SpringBootApplication
public class SpringBootLearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLearningApplication.class, args);
		System.out.println("Spring Boot Application Started");
	}

	@Bean
	public CommandLineRunner commandLineRunner(String[] aStrings) {
		return runner -> System.out.println("CommandLineRunner executed");
	}

}
