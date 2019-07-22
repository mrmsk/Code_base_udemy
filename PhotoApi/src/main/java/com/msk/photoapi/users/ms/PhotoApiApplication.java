package com.msk.photoapi.users.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PhotoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoApiApplication.class, args);
	}

}
