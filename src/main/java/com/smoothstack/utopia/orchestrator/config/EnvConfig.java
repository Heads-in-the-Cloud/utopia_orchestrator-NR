package com.smoothstack.utopia.orchestrator.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class EnvConfig {

    @Value("${flight.port}")
    private String flightPort;

    @Value("${user.port}")
    private String userPort;

    @Value("${booking.port}")
    private String bookingPort;

    @Value("${auth.port}")
    private String authPort;

    @Value("${auth.uri}")
    private String authUri;

    @Value("${booking.uri}")
    private String bookingUri;

    @Value("${flight.uri}")
    private String flightUri;

    @Value("${user.uri}")
    private String userUri;
}
