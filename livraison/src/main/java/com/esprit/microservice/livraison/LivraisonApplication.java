package com.esprit.microservice.livraison;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient  // Add this annotation
@SpringBootApplication
public class LivraisonApplication {

    public static void main(String[] args) {
        SpringApplication.run(LivraisonApplication.class, args);
    }

}
