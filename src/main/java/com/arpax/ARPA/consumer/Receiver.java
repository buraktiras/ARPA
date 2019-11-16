package com.arpax.ARPA.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class Receiver {

    private static final Logger LOG = LoggerFactory.getLogger(Receiver.class);
    Map<Integer,Integer> randomPrices = new HashMap();

    @KafkaListener(topics = "${app.topic.foo}")
    public void listen(@Payload String message) {
        LOG.info("received message='{}'", message);

        String[] randomValues = message.split("-");
        randomPrices.put(Integer.valueOf(randomValues[0]), Integer.valueOf(randomValues[1]));
    }

    public Map<Integer, Integer> getRandomPrices() {
        return randomPrices;
    }

    public void setRandomPrices(Map<Integer, Integer> randomPrices) {
        this.randomPrices = randomPrices;
    }
}
