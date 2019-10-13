package com.regis.cachenamemoria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CacheNaMemoriaApplication<K, V> {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(CacheNaMemoriaApplication.class, args);
	}

}