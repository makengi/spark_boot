package com.imr.spark_boot.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfiguration {

    @Value("${kafka.bootstrapAddress}")
    private String bootstrapServers;

    @Value("${kafka.my.")

}
