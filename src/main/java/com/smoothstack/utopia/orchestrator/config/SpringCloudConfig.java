package com.smoothstack.utopia.orchestrator.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {

    @Autowired
    private EnvConfig envConfig;

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/api/flights/**")
                        .uri("http://" + envConfig.getUri() + ":" + envConfig.getFlightsPort() + "/"))
                .route(r -> r.path("/api/user/**")
                        .uri("http://" + envConfig.getUri() + ":" + envConfig.getUsersPort() + "/"))
                .route(r -> r.path("/api/booking/**")
                        .uri("http://" + envConfig.getUri() + ":" + envConfig.getBookingsPort() + "/"))
                .route(r -> r.path("/api/auth/**")
                        .uri("http://" + envConfig.getUri() + ":" + envConfig.getAuthPort() + "/"))
                .build();
    }
}
