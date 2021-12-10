package com.imr.spark_boot.configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageProperty {

    private static Logger Log = LoggerFactory.getLogger(MessageProperty.class);
    @Value("${msg.addr}")
    private String address;

}
