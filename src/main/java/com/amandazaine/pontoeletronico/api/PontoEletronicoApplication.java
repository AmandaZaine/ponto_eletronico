package com.amandazaine.pontoeletronico.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class PontoEletronicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PontoEletronicoApplication.class, args);
	}

}
