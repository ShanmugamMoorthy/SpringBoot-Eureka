package com.equifax.eureka.microsvcs.config;

/**
 * 
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan("com.equifax.eureka.microsvcs")
@EnableEurekaClient
public class EurekaMicroSvcsApplication {
   public static void main(String[] args) {
      SpringApplication.run(EurekaMicroSvcsApplication.class, args);
   }
   
   @Bean 
   public RestTemplate  restTemplate() {
	   return new RestTemplate();
   }
}