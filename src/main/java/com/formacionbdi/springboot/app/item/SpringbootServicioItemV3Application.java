package com.formacionbdi.springboot.app.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@EnableFeignClients  //habilita nuestro cliente feign que tengamos implementado en nuestro proyecto. y permite inyectar clientes en nuestros controladores
@SpringBootApplication
public class SpringbootServicioItemV3Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServicioItemV3Application.class, args);
	}

}
