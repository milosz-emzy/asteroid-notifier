package com.emzy.asteroid;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange
public interface NasaAsteroidsClient {

    @GetExchange()
    AsteroidResponse getResponse(@RequestParam(name = "start_date") String startDate,
                                 @RequestParam(name = "end_date") String endDate,
                                 @RequestParam(name = "api_key") String apiKey);
}
