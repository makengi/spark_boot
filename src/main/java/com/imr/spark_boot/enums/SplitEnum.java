package com.imr.spark_boot.enums;

public enum SplitEnum {
    
    COMMA_DELIMITER(","),
    SEMI_COLON(":");

    private final String name;

    SplitEnum(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

}
