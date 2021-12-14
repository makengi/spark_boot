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
        return new SparkConf()
                .setMaster("spark://172.27.201.69:7077")
                .setAppName("cctv-application");
    }


    @Bean
    public SparkSession createSparkSession(){
        return SparkSession.builder()
                .appName("cctv-application")
                .config(createSparkConfiguration())
                .getOrCreate();
    }


    @Bean
    public JavaSparkContext createSparkContext(){
        return new JavaSparkContext(createSparkConfiguration());
    }
}


