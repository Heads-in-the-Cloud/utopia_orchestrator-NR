package com.smoothstack.utopia.orchestrator.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class EnvConfig {

    @Value("${flights.port}")
    private String flightsPort;

    @Value("${users.port}")
    private String usersPort;

    @Value("${bookings.port}")
    private String bookingsPort;

    @Value("${auth.port}")
    private String authPort;

    @Value("${uri}")
    private String uri;

}
