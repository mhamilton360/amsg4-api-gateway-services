package com.coat.ams.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableConfigServer
@SpringBootApplication
public class AmsApiConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmsApiConfigServerApplication.class, args);
		log.info("*** AmsApiConfigServerApplication is up!");
	}
}
