package com.javainuse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import brave.sampler.Sampler;

@SpringBootApplication
public class Microservice3Application {

	public static void main(String[] args) {
		SpringApplication.run(Microservice3Application.class, args);
	}

}

@RestController
@RequestMapping("/microservice3")
class MicroService3Controller {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Bean
	public Sampler sampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
	
	@GetMapping
	public String sendMessage() {
		logger.info("Microservice3 get starts");
		logger.info("Microservice3 get ends");
		return "Simple Distributed Logging Example after commenting property spring.zipkin.enabled=false";
	}
}