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
                .route("vehicle", r -> r.path("/api/vehicle/**")
                        .uri("http://vehicle-service:8080"))
                .route("user", r -> r.path("/api/user/**")
                        .uri("http://user-service:8084"))
                .route("invoice", r -> r.path("/api/invoice/**")
                        .uri("http://invoice-service:8083"))
                .route("pricing", r -> r.path("/api/pricing/**")
                        .uri("http://pricing-service:8081"))
                .route("tracking", r -> r.path("/api/tracking/**")
                        .uri("http://tracking-service:8088"))
                .route("traveldata", r -> r.path("/api/traveldata/**")
                        .uri("http://traveldata-service:8085"))
                .route("traveldata", r -> r.path("/api/route/**")
                        .uri("http://traveldata-service:8085"))
                .build();
    }
}
