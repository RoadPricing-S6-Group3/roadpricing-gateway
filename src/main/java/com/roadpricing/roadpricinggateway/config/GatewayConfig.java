package com.roadpricing.roadpricinggateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("backend", r -> r.path("/api/**")
                        .uri("http://vehicle-service:8080"))
                .route("backend", r -> r.path("/api/**")
                        .uri("http://user-service:8084"))
                .route("backend", r -> r.path("/api/**")
                        .uri("http://invoice-service:8083"))
                .route("backend", r -> r.path("/api/**")
                        .uri("http://pricing-service:8081"))
                .route("backend", r -> r.path("/api/**")
                        .uri("http://tracking-service:8088"))
                .route("backend", r -> r.path("/api/**")
                        .uri("http://traveldata-service:8085"))
                .build();
    }
}
