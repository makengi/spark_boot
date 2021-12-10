//
//package com.imr.spark_boot.components;
//
//import com.imr.spark_boot.configuration.KafkaProperty;
//import com.imr.spark_boot.model.CustomMessage;
//
//import org.apache.kafka.clients.consumer.KafkaConsumer;
//import org.glassfish.jersey.internal.inject.Custom;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.support.KafkaHeaders;
//import org.springframework.kafka.support.SendResult;
//import org.springframework.messaging.Message;
//import org.springframework.messaging.support.MessageBuilder;
//import org.springframework.stereotype.Component;
//import org.springframework.util.concurrent.ListenableFuture;
//import org.springframework.util.concurrent.ListenableFutureCallback;
//
//@Component
//public class KafkaMessageSender {
//
//
//    private KafkaTemplate<String, CustomMessage> kafkaTemplate;
//    private KafkaProperty kafkaProperty;
//
//    @Autowired
//    public KafkaMessageSender(KafkaTemplate<String, CustomMessage> kafkaTemplate,KafkaProperty kafkaProperty){
//        this.kafkaTemplate = kafkaTemplate;
//        this.kafkaProperty = kafkaProperty;
//    }
//
//    public void send(CustomMessage gcmPushEntity) {
//
//        Message<CustomMessage> message = MessageBuilder
//                .withPayload(gcmPushEntity)
//                .setHeader(KafkaHeaders.TOPIC, kafkaProperty.getTopicName())
//                .build();
//
//        ListenableFuture<SendResult<String, CustomMessage>> future =
//                kafkaTemplate.send(message);
//
//        future.addCallback(new ListenableFutureCallback<SendResult<String, CustomMessage>>() {
//
//            @Override
//            public void onSuccess(SendResult<String, CustomMessage> stringObjectSendResult) {
//                System.out.println("Sent message=[" + stringObjectSendResult.getProducerRecord().value().toString() +
//                        "] with offset=[" + stringObjectSendResult.getRecordMetadata().offset() + "]");
//            }
//
//            @Override
//            public void onFailure(Throwable ex) {
//                System.out.println("Unable to send message=[] due to : " + ex.getMessage());
//            }
//        });
//    }
//}
