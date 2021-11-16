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

    @Value("#{'${uri}'.equals('null') ? 'auth' : '${uri}'}")
    private String authUri;

    @Value("#{'${uri}'.equals('null') ? 'booking' : '${uri}'}")
    private String bookingUri;

    @Value("#{'${uri}'.equals('null') ? 'flight' : '${uri}'}")
    private String flightUri;

    @Value("#{'${uri}'.equals('null') ? 'user' : '${uri}'}")
    private String userUri;
}
