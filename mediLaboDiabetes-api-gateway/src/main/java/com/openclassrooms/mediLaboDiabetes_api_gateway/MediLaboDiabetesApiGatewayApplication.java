package com.openclassrooms.mediLaboDiabetes_api_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * ApiGateway is a single entrypoint into our app, leading access to every other microservice (using their service names instead of urls)
 */
@EnableDiscoveryClient
@SpringBootApplication
public class MediLaboDiabetesApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MediLaboDiabetesApiGatewayApplication.class, args);
	}

}
