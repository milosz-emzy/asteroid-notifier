package com.emzy.asteroid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;

@Service
public class AsteroidService {
    private static final Log log = LogFactory.getLog(AsteroidService.class);

    private final NasaAsteroidsClient nasaAsteroidsClient;
    private final String LOCAL_DATE_FORMAT = "yyyy-MM-dd";
    private final KafkaTemplate<String, Asteroid> kafkaTemplate;

    public AsteroidService(NasaAsteroidsClient nasaAsteroidsClient, KafkaTemplate<String, Asteroid> kafkaTemplate) {
        this.nasaAsteroidsClient = nasaAsteroidsClient;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendAlert() {
        Asteroid asteroid = getResponse().stream().findFirst().orElse(null);
        ProducerRecord<String, Asteroid> objectAsteroidProducerRecord = new ProducerRecord<>("asteroid-alert", asteroid);
        log.info("Sending...");
        log.info(asteroid);

        kafkaTemplate.send(objectAsteroidProducerRecord);
    }


    public List<Asteroid> getResponse() {
        var response = nasaAsteroidsClient.getResponse(
                LocalDate.now().format(DateTimeFormatter.ofPattern(LOCAL_DATE_FORMAT)),
                LocalDate.now().format(DateTimeFormatter.ofPattern(LOCAL_DATE_FORMAT)),
                "DEMO_KEY"
        );

        return response.nearEarthObjects().values().stream()
                .flatMap(Collection::stream)
                .toList();
    }
}
