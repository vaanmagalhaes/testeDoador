package com.senac.doador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DoadorApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoadorApplication.class, args);
	}

}
