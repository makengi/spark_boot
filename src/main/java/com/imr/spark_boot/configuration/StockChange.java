package com.imr.spark_boot.configuration;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class StockChange {

    String yyyymmdd;
    String skuCd;
    String fieldName;
    int diff;

    @Builder
    public StockChange(String yyyymmdd, String skuCd, String fieldName, int diff) {
        this.yyyymmdd = yyyymmdd;
        this.skuCd = skuCd;
        this.fieldName = fieldName;
        this.diff = diff;
    }
}