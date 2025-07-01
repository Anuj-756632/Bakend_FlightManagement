package com.booking_service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class EurekaHealthCheck {

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostConstruct
    public void checkServices() {
        System.out.println("🔍 Services discovered by booking-service: " + discoveryClient.getServices());
    }
}
