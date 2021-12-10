//package com.imr.spark_boot.configuration;
//
//import org.apache.kafka.clients.admin.AdminClientConfig;
//import org.apache.kafka.clients.admin.KafkaAdminClient;
//import org.apache.kafka.clients.admin.NewTopic;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.kafka.core.KafkaAdmin;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Configuration
//@PropertySource(value = "classpath:application.yml")
//public class KafkaTopicConfiguration {
//
//    private KafkaProperty kafkaProperty;
//
//    @Autowired
//    public KafkaTopicConfiguration(KafkaProperty kafkaProperty) {
//        this.kafkaProperty = kafkaProperty;
//    }
//
//    @Bean
//    public KafkaAdmin kafkaAdmin(){
//        Map<String, Object> configs = new HashMap<>();
//        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperty.getBootstrapServerAddress());
//        return new KafkaAdmin(configs);
//    }
//
//    @Bean
//    public NewTopic newTopic(){
//        return new NewTopic(kafkaProperty.getTopicName(), 3, (short) 3);
//    }
//
//}
