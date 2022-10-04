package com.formacionbdi.springboot.app.item;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration                 //permite crear objetos, componentes beans y los podemos registrar en el contenedor utilizando metodos y la anotacion bean
public class AppConfig {
	
	@Bean("clienteRest")
	public RestTemplate registrarRestTemplate() {    //estrategia para comunicarme con otro microservicio
		return new RestTemplate();     //El objeto que se retorna se guarda en el contenedor gracias a la anotacion bean
	}

}
