package br.com.jansoftinfo.apiteste;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@EnableCaching
@SpringBootApplication
public class ApitesteApplication {
	public static void main(String[] args) {
		SpringApplication.run(ApitesteApplication.class, args);
	}
}