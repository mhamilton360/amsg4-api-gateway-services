package com.coat.ams.api.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
public class AmsApiAccountManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmsApiAccountManagementApplication.class, args);	
		log.info("*** AmsApiAccountManagementApplication is up!");
	}

}
