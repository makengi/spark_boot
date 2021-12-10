//package com.imr.spark_boot.configuration;
//
//import com.imr.spark_boot.model.CustomMessage;
//import lombok.RequiredArgsConstructor;
//import org.apache.kafka.clients.consumer.ConsumerConfig;
//import org.apache.kafka.common.serialization.StringDeserializer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.annotation.EnableKafka;
//import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
//import org.springframework.kafka.core.ConsumerFactory;
//import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
//import org.springframework.kafka.support.serializer.JsonDeserializer;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@EnableKafka
//@Configuration
//@RequiredArgsConstructor
//public class KafkaConsumerConfiguration {
//
//    private final KafkaProperty kafkaProperty;
//
//    @Bean
//    public ConsumerFactory<String, CustomMessage> pushEntityConsumerFactory() {
//        JsonDeserializer<CustomMessage> deserializer = jsonDeserializer();
//        return new DefaultKafkaConsumerFactory<>(
//                consumerFactoryConfig(deserializer),
//                new StringDeserializer(),
//                deserializer);
//    }
//
//    private Map<String, Object> consumerFactoryConfig(JsonDeserializer<CustomMessage> deserializer) {
//        Map<String, Object> props = new HashMap<>();
//        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperty.getBootstrapServerAddress());
//        props.put(ConsumerConfig.GROUP_ID_CONFIG, kafkaProperty.getGroupId());
//        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, deserializer);
//        return props;
//    }
//
//    private JsonDeserializer<CustomMessage> jsonDeserializer(){
//        JsonDeserializer<CustomMessage> deserializer = new JsonDeserializer<>(CustomMessage.class);
//        deserializer.setRemoveTypeHeaders(false);
//        deserializer.addTrustedPackages("*");
//        deserializer.setUseTypeMapperForKey(true);
//        return deserializer;
//    }
//
//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, CustomMessage>
//    pushEntityKafkaListenerContainerFactory() {
//        ConcurrentKafkaListenerContainerFactory<String, CustomMessage> factory =
//                new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(pushEntityConsumerFactory());
//        return factory;
//    }
//
//}
//
//
