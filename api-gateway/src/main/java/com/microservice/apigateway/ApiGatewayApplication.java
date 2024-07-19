package com.microservice.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("employee_service", r -> r.path("/sv-emp/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://EMPLOYEE-SERVICE"))
                .route("department_service", r -> r.path("/sv-dep/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://DEPARTMENT-SERVICE"))
                .build();
    }

}
