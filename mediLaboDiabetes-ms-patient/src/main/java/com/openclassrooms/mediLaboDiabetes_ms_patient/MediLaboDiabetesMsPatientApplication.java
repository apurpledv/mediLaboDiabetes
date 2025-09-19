package com.openclassrooms.mediLaboDiabetes_ms_patient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MediLaboDiabetesMsPatientApplication {
	public static void main(String[] args) {
		SpringApplication.run(MediLaboDiabetesMsPatientApplication.class, args);
	}
}
