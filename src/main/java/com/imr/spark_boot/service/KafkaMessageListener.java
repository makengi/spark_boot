//package com.imr.spark_boot.service;
//
//
//import com.imr.spark_boot.configuration.KafkaProperty;
//import com.imr.spark_boot.model.CustomMessage;
//import org.apache.kafka.clients.producer.KafkaProducer;
//import org.glassfish.jersey.internal.inject.Custom;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.messaging.MessageHeaders;
//import org.springframework.messaging.handler.annotation.Headers;
//import org.springframework.messaging.handler.annotation.Payload;
//import org.springframework.stereotype.Service;
//
//@Service
//public class KafkaMessageListener {
//
//    private KafkaProperty kafkaProperty;
//    private static Logger Log = LoggerFactory.getLogger(KafkaMessageListener.class);
//    private String topics;
//
//    @Autowired
//    public KafkaMessageListener(KafkaProperty kafkaProperty) {
//        this.kafkaProperty = kafkaProperty;
//        this.topics = kafkaProperty.getTopicName();
//    }
//
//
//    @KafkaListener(
//               topics = "testTopic"
//            , groupId = "testTopic"
//            , containerFactory = "pushEntityKafkaListenerContainerFactory")
//    public void listenWithHeaders(String message) {
//
////        Log.info(
////                "Received Message: " + customMessage.toString() +
////                       " headers: " + messageHeaders);
//    }
//}
