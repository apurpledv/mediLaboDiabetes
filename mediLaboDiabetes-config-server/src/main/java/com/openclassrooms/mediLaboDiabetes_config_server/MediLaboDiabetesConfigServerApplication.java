package com.openclassrooms.mediLaboDiabetes_config_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * ConfigServer is used to allow other microservices to fetch their configuration files from a distant git repository
 */
@SpringBootApplication
@EnableConfigServer
public class MediLaboDiabetesConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MediLaboDiabetesConfigServerApplication.class, args);
	}

}
