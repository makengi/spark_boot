package com.imr.spark_boot.configuration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MessagePropertyTest {

    @Autowired
    private MessageProperty messageProperty;

    @Autowired
    private KafkaProperty kafkaProperty;

    @Test
    public void yaml_파일_읽기(){
        String name = messageProperty.getAddress();
        assertThat(name,notNullValue());
        assertThat(name,is("192.168.0.12:9092"));
    }

    @Test
    public void yaml_카프카_읽기() {
        String targetAddress = "192.168.0.12:9092";
        String targetTopicName = "testTopic3";
        String targetGroupId = "testTopic";

        String address = kafkaProperty.getBootstrapServerAddress();
        String name = kafkaProperty.getTopicName();
        String groupId = kafkaProperty.getGroupId();

        assertThat(address,notNullValue());
        assertThat(address,is(targetAddress));
        assertThat(name,notNullValue());
        assertThat(name, is(targetTopicName));
        assertThat(targetGroupId,notNullValue());
        assertThat(targetGroupId, is(groupId));
    }

}