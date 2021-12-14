package com.imr.spark_boot.controller;

import com.imr.spark_boot.service.ExactContentSerivce;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SparkControllerTest {

    @Autowired
    private ExactContentSerivce exactContentSerivce;

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private JavaSparkContext sparkContext;

    @Test
    public void 스파크_csv_읽기() throws IOException {
        //Given
        Resource resource = resourceLoader.getResource("classpath:files/cctv_data.csv");
        URL url = resource.getURL();

        //When
        Assertions.assertNotNull(url);

        JavaRDD<String> lines = sparkContext.textFile(url.getPath());

        //Transformation
        JavaRDD<String> titles = lines
                .map(exactContentSerivce::exactTitle)
                .filter(StringUtils::isNotBlank);

        JavaRDD<String> words = titles.flatMap((title) -> Arrays.asList(title.toLowerCase()).iterator());


    }

}