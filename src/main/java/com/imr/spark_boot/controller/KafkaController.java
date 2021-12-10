package com.imr.spark_boot.controller;

import com.imr.spark_boot.configuration.StockChange;
import com.imr.spark_boot.service.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apis/kafka")
public class KafkaController {


    private KafkaProducer kafkaProducer;

    @Autowired
    public KafkaController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    private static Logger Log = LoggerFactory.getLogger(KafkaController.class);

    @PostMapping
    public StockChange produce(@RequestBody StockChange stockChange){
        Log.info("stockChange: {}", stockChange);
        return kafkaProducer.sendMessage(stockChange);
    }
}
