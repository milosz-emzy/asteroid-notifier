package com.emzy.asteroid.config;

import com.emzy.asteroid.NasaAsteroidsClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class AppConfig {

    private final String NASA_ASTEROIDS_URL = "https://api.nasa.gov/neo/rest/v1/feed";

    @Bean
    public NasaAsteroidsClient nasaAsteroidsClient() {
        WebClient webClient = WebClient.builder()
                .baseUrl(NASA_ASTEROIDS_URL)
                .build();

        HttpServiceProxyFactory serviceProxyFactory = HttpServiceProxyFactory
                .builderFor(WebClientAdapter.create(webClient))
                .build();

        return serviceProxyFactory.createClient(NasaAsteroidsClient.class);
    }
}
