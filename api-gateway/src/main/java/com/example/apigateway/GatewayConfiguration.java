package com.example.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()

                // Movie info Service
                .route(p -> p.path("/api/movies/**")
                        .uri("lb://MOVIE-INFO-SERVICE"))

                // Rating data Service
                .route(p -> p.path("/api/ratings**")
                        .uri("lb://RATINGS-DATA-SERVICE"))
                .route(p -> p.path("/api/users/**")
                        .uri("lb://RATINGS-DATA-SERVICE"))

                // Movie catalog Service
                .route(p -> p.path("/api/catalogs/**")
                        .uri("lb://MOVIE-CATALOG-SERVICE"))

                .build();
    }
}
