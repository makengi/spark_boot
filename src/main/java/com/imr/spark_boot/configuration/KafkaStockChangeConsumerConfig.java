package com.imr.spark_boot.configuration;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaStockChangeConsumerConfig {


    private KafkaProperty kafkaProperty;

    @Autowired
    public KafkaStockChangeConsumerConfig(KafkaProperty kafkaProperty) {
        this.kafkaProperty = kafkaProperty;
    }


    @Bean
    public ConsumerFactory<String, StockChange> stockChangeConsumer() {

        Map<String, Object> configs = new HashMap<>();
        configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperty.getBootstrapServerAddress());
        configs.put(ConsumerConfig.GROUP_ID_CONFIG, kafkaProperty.getGroupId());

        return new DefaultKafkaConsumerFactory<>(
                configs,
                new StringDeserializer(),
                new JsonDeserializer<>(StockChange.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, StockChange> stockChangeListener() {
        ConcurrentKafkaListenerContainerFactory<String, StockChange> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(stockChangeConsumer());
        return factory;
    }
}