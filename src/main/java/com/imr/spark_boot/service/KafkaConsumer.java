package com.imr.spark_boot.service;

import com.imr.spark_boot.configuration.StockChange;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "testTopic3", groupId = "testTopic", containerFactory = "stockChangeListener")
    public void consume(StockChange stockChange) {
        System.out.printf("Consumed message : %s%n", stockChange.getYyyymmdd());
    }
}