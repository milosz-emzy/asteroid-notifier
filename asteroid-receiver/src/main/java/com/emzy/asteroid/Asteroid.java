package com.emzy.asteroid;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Asteroid(
        String id,
        String name,
        @JsonProperty("absolute_magnitude_h") Float absoluteMagnitude,
        @JsonProperty("is_potentially_hazardous_asteroid") boolean isPotentiallyHazardous,
        @JsonProperty("estimated_diameter") EstimatedDiameter estimatedDiameter
) {
}
