package com.wz.payroll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/*Criando um componente apartir de uma chamada de metodo.
Uma chamada unica de um objeto RestTemplate para ser consumido.*/

@Configuration
public class AppConfig {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
