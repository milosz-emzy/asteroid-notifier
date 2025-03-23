package com.emzy.asteroid;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;


public record AsteroidResponse(
        @JsonProperty("near_earth_objects") Map<String, List<Asteroid>> nearEarthObjects,
        @JsonProperty("element_count") Integer elementCount
) {
}
