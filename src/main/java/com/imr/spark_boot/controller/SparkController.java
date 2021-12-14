package com.imr.spark_boot.controller;

import com.imr.spark_boot.service.ExactContentSerivce;
import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.RemoteIterator;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;

@RestController
@RequestMapping("/apis/spark")
public class SparkController {


    private ResourceLoader resourceLoader;
    private JavaSparkContext sparkContext;
    private SparkSession sparkSession;
    private ExactContentSerivce exactContentSerivce;

    private static Logger Log = LoggerFactory.getLogger(SparkController.class);

    @Autowired
    public SparkController(ResourceLoader resourceLoader, JavaSparkContext sparkContext,SparkSession sparkSession,ExactContentSerivce exactContentSerivce){
        this.resourceLoader = resourceLoader;
        this.sparkContext = sparkContext;
        this.sparkSession = sparkSession;
        this.exactContentSerivce = exactContentSerivce;
    }

    @GetMapping
    public void analysis() throws IOException {
        Resource resource = resourceLoader.getResource( "classpath:files/cctv_data.csv");
        URL url = resource.getURL();
        JavaRDD<String> videos = sparkContext.textFile(url.getPath());


        //TransFormations
        JavaRDD<String> titles = videos
                .map(exactContentSerivce::exactTitle)
                .filter(StringUtils::isNotBlank);


        JavaRDD<String> words = titles.flatMap((title) -> Arrays.asList(title.toLowerCase()).iterator());
        words.foreach(word -> Log.info(word.toString()));

    }

    @GetMapping("/hdfs")
    public void hdfs() throws Exception{

        Configuration configuration = new Configuration();
        configuration.set("fs.default.name","hdfs://172.27.201.69:9000");

        FileSystem fs = FileSystem.get(configuration);
        RemoteIterator<LocatedFileStatus> files = fs.listFiles(new Path("/user/cctv"), true);
        while(files.hasNext()){
            Log.info(files.next().getPath().toUri().toString());
        }
//        Dataset<Row> rows = sparkSession.read().parquet("hdfs://172.27.201.69:9000");
    }




}
