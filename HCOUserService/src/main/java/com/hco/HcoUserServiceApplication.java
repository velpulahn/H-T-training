package com.hco;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableEurekaClient
@OpenAPIDefinition(
		info = @Info(
				title = "Health care Organization",
				version = "1.1",
				description = "This service is used in the Health Care application"
			)
		)
//@EnableFeignClients
public class HcoUserServiceApplication implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		SpringApplication.run(HcoUserServiceApplication.class, args);
	}

	

}
