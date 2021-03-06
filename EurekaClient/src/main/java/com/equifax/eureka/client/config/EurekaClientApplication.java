/**
 * 
 */
package com.equifax.eureka.client.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan("com.equifax.eureka.client")
@EnableEurekaClient
public class EurekaClientApplication {
   public static void main(String[] args) {
      SpringApplication.run(EurekaClientApplication.class, args);
  }
   
   @Bean 
   public RestTemplate  restTemplate() {
	   return new RestTemplate();
   }
}