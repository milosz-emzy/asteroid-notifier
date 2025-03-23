package com.emzy.asteroid;

import com.fasterxml.jackson.annotation.JsonProperty;

public record EstimatedDiameter(
        EstimatedDiameterValues meters,
        EstimatedDiameterValues feet
) {
    record EstimatedDiameterValues(
            @JsonProperty("estimated_diameter_min") Double min,
            @JsonProperty("estimated_diameter_max") Double max
    ) {
    }
}
