package com.coat.ams.api.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableEurekaServer
@SpringBootApplication
public class AmsApiDiscoveryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmsApiDiscoveryServiceApplication.class, args);
		log.info("*** AmsApiDiscoveryServiceApplication is up!");
	}

}
