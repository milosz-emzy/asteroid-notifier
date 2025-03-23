package com.emzy.asteroid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class AsteroidService {

    private static final Log log = LogFactory.getLog(AsteroidService.class);

    @KafkaListener(topics = "asteroid-alert", groupId = "asteroid-alert")
    public void alertEvent(Asteroid asteroidEvent) {
        log.info(asteroidEvent);
    }
}
