package com.imr.spark_boot;

import com.imr.spark_boot.enums.SplitEnum;
import org.apache.commons.lang.StringUtils;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ResourceLoader;

import java.net.URL;
import java.util.Arrays;

@SpringBootApplication
public class SparkBootApplication {

    private static Logger Log = LoggerFactory.getLogger(SparkBootApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SparkBootApplication.class, args);

//        SparkConf conf = new SparkConf()
//                .setMaster("local[8]")
//                .setAppName("cctv");
//
//
//        JavaSparkContext sparkContext = new JavaSparkContext(conf);
//

    }
}
