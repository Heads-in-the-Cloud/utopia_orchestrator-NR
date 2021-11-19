package com.smoothstack.utopia.orchestrator.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class SpringCloudConfig {

    @Autowired
    private EnvConfig envConfig;

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {

        StringBuilder authUri = new StringBuilder("http://" + envConfig.getAuthUri());
        if (!envConfig.getAuthPort().equals("")) {
            authUri.append(":").append(envConfig.getAuthPort()).append("/");
        }
        StringBuilder flightUri = new StringBuilder("http://" + envConfig.getFlightUri());
        if (!envConfig.getFlightPort().equals("")) {
            flightUri.append(":").append(envConfig.getFlightPort()).append("/");
        }
        StringBuilder bookingUri = new StringBuilder("http://" + envConfig.getBookingUri());
        if (!envConfig.getBookingPort().equals("")) {
            bookingUri.append(":").append(envConfig.getBookingPort()).append("/");
        }
        StringBuilder userUri = new StringBuilder("http://" + envConfig.getUserUri());
        if (!envConfig.getUserPort().equals("")) {
            userUri.append(":").append(envConfig.getUserPort()).append("/");
        }

        log.info("authUri: {}", authUri);
        log.info("flightUri: {}", flightUri);
        log.info("bookingUri: {}", bookingUri);
        log.info("userUri: {}", userUri);

        return builder.routes()
                .route(r -> r.path("/api/flights/**")
                        .uri(flightUri.toString()))
                .route(r -> r.path("/api/users/**")
                        .uri(userUri.toString()))
                .route(r -> r.path("/api/bookings/**")
                        .uri(bookingUri.toString()))
                .route(r -> r.path("/api/auth/**")
                        .uri(authUri.toString()))
                .build();
    }
}
