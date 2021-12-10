package com.imr.spark_boot.configuration;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaStockChangeProducerConfig {

    private KafkaProperty kafkaProperty;

    @Autowired
    public KafkaStockChangeProducerConfig(KafkaProperty kafkaProperty) {
        this.kafkaProperty = kafkaProperty;
    }

    @Bean
    public ProducerFactory<String, StockChange> producerFactory() {

        Map<String,Object> configs = new HashMap<>();
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperty.getBootstrapServerAddress());
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory(configs);
    }

    @Bean
    public KafkaTemplate<String, StockChange> kafkaTemplate() {

        return new KafkaTemplate<>(producerFactory());
    }
}