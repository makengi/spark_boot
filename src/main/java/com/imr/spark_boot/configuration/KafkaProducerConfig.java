//package com.imr.spark_boot.configuration;
//
//import com.imr.spark_boot.model.CustomMessage;
//import org.apache.kafka.clients.producer.ProducerConfig;
//import org.codehaus.jackson.map.JsonSerializer;
//import org.codehaus.jackson.map.ser.std.StringSerializer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.kafka.core.DefaultKafkaProducerFactory;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.core.ProducerFactory;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Configuration
//public class KafkaProducerConfig {
//
//
//    private KafkaProperty kafkaProperty;
//
//    @Autowired
//    public KafkaProducerConfig(KafkaProperty kafkaProperty) {
//        this.kafkaProperty = kafkaProperty;
//    }
//
//
//    @Bean
//    public ProducerFactory<String, CustomMessage> producerFactory() {
//        Map<String, Object> configsProps = producerFactoryConfig();
//        return new DefaultKafkaProducerFactory<>(configsProps);
//    }
//
//
//    protected Map<String, Object> producerFactoryConfig() {
//        Map<String, Object> configProps = new HashMap<>();
//        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperty.getBootstrapServerAddress());
//        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
//        return configProps;
//    }
//
//    @Bean
//    public KafkaTemplate<String, CustomMessage> kafkaTemplate(){
//        return new KafkaTemplate<>(producerFactory());
//    }
//
//}
