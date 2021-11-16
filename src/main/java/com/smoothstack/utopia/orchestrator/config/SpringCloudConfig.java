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
                        .uri("http://" + envConfig.getFlightUri() + ":" + envConfig.getFlightsPort() + "/"))
                .route(r -> r.path("/api/users/**")
                        .uri("http://" + envConfig.getUserUri() + ":" + envConfig.getUsersPort() + "/"))
                .route(r -> r.path("/api/bookings/**")
                        .uri("http://" + envConfig.getBookingUri() + ":" + envConfig.getBookingsPort() + "/"))
                .route(r -> r.path("/api/auth/**")
                        .uri("http://" + envConfig.getAuthUri() + ":" + envConfig.getAuthPort() + "/"))
                .build();
    }
}
