package com.stage.footballEventApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"Controller","Model","Service"})
public class FootballEventAppApplication  extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(FootballEventAppApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(FootballEventAppApplication.class);
	}
}
