package com.msk.PhotoApp.EurekaServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class PhotoAppEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoAppEurekaServerApplication.class, args);
	}

}
