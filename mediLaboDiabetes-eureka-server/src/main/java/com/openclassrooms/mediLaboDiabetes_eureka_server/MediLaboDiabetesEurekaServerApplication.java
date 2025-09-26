package com.openclassrooms.mediLaboDiabetes_eureka_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * EurekaServer lists every active instance of our microservices
 */
@EnableEurekaServer
@SpringBootApplication
public class MediLaboDiabetesEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MediLaboDiabetesEurekaServerApplication.class, args);
	}

}
