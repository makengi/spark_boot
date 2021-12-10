package com.imr.spark_boot.service;

import com.imr.spark_boot.configuration.StockChange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private static Logger Log = LoggerFactory.getLogger(KafkaProducer.class);
    private static final String TOPIC = "testTopic3";
    private final KafkaTemplate<String, StockChange> kafkaTemplate;

    @Autowired
    public KafkaProducer(KafkaTemplate<String, StockChange> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public StockChange sendMessage(StockChange sc) {

        StockChange stockChange = StockChange.builder()
                .yyyymmdd("2021-01-01")
                .skuCd("10300000033")
                .fieldName("ipgoNo")
                .diff(100)
                .build();

        // Send a message
        Log.info("stockChangeMessage: {}", stockChange.toString());
        kafkaTemplate.send(TOPIC, stockChange);
        return sc;
    }
}