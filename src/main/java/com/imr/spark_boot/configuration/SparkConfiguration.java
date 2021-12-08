package com.imr.spark_boot.configuration;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SparkConfiguration {

    @Bean
    protected SparkConf createSparkConfiguration(){
        return  new SparkConf()
                .setMaster("local[2]")
                .setAppName("cctv");
    }


    @Bean
    public SparkSession createSparkSession(){
        return SparkSession.builder()
                .appName("cctv")
                .config(createSparkConfiguration())
                .getOrCreate();
    }


    @Bean
    public JavaSparkContext createSparkContext(){
        return new JavaSparkContext(createSparkConfiguration());
    }
}


