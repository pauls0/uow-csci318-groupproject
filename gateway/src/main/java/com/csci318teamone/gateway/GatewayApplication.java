package com.csci318teamone.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {

  public static void main(String[] args) {
    SpringApplication.run(GatewayApplication.class, args);
  }

  @Bean
  public RouteLocator myRoutes(RouteLocatorBuilder builder) {
    return builder
      .routes()
      .route(p -> p.path("/customers").uri("http://localhost:8081/customers"))
      .route(p -> p.path("/products").uri("http://localhost:8082/products"))
      .route(p -> p.path("/purchases").uri("http://localhost:8083/purchases"))
      .build();
  }
}
