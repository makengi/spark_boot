package com.imr.spark_boot.service;

import com.imr.spark_boot.enums.SplitEnum;
import org.springframework.stereotype.Service;

@Service
public class ExactContentSerivce {


    public String exactTitle(String textLine) {
        try {
            return textLine.split(SplitEnum.COMMA_DELIMITER.getName())[0];
        } catch (Exception e) {
            e.printStackTrace();
            return "";

        }
    }
}
