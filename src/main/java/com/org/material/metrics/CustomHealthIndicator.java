/**
 * © 2024 JTino Inc. Author: Joseph Tino.
 * Redistribution permitted with attribution. Provided "as is" without warranty.
 * No liability for damages. See full license for details.
 */
package com.org.material.metrics;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        // Custom logic to determine the health of the application
        boolean isHealthy = checkHealth();

        if (isHealthy) {
            return Health.up().withDetail("Custom Health", "Everything is fine").build();
        } else {
            return Health.down().withDetail("Custom Health", "Something went wrong").build();
        }
    }

    private boolean checkHealth() {
        // todo  Implement your custom health check logic
        return true;  // Replace with actual health check result
    }
}
