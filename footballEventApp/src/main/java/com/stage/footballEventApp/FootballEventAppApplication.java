package com.stage.footballEventApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "./")
public class FootballEventAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FootballEventAppApplication.class, args);
	}
}
