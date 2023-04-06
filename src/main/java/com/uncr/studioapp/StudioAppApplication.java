package com.uncr.studioapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableConfigurationProperties
@EnableAspectJAutoProxy
public class StudioAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudioAppApplication.class, args);
	}

}
