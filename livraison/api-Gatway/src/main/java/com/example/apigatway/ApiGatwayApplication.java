package com.example.apigatway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatwayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatwayApplication.class, args);
    }

    @Bean
    public RouteLocator gatewayRoute(RouteLocatorBuilder builder){
        return builder.routes()
                .route("CouponGestion",r->r.path("/api/coupons/**")
                .uri("http://gestionCoupon:8081"))
                .route("Livraison",r->r.path("/api/deliveries/**")
                        .uri("http://livraison:8089"))
                .build();
    }



}
