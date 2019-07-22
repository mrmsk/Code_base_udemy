package com.example.photoapi.acctmgt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PhotoApiAccountManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoApiAccountManagementApplication.class, args);
	}

}
