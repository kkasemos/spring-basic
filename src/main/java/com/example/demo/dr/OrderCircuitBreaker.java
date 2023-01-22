package com.example.demo.dr;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.springframework.stereotype.Component;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;

@Component
public class OrderCircuitBreaker {
	public OrderCircuitBreaker() {
		// Create a custom configuration for a CircuitBreaker
		CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
		    .failureRateThreshold(50)
		    .waitDurationInOpenState(Duration.ofMillis(1000))
		    .permittedNumberOfCallsInHalfOpenState(2)
		    .slidingWindowSize(2)
		    .recordExceptions(IOException.class, TimeoutException.class)
//		    .ignoreExceptions(BusinessException.class, OtherBusinessException.class)
		    .build();

		// Create a CircuitBreakerRegistry with a custom global configuration
		CircuitBreakerRegistry circuitBreakerRegistry =
		  CircuitBreakerRegistry.of(circuitBreakerConfig);
	}
}
