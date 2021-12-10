package com.imr.spark_boot.configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KafkaProperty {

    @Value("${spring.kafka.consumer.bootstrap-servers}")
    private String bootstrapServerAddress;

    @Value("${spring.kafka.topic-name}")
    private String topicName;

    @Value("${spring.kafka.consumer.group-id}")
    private String groupId;
}
