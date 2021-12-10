package com.imr.spark_boot.model;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class CustomMessage {
    private String content;

    @Builder
    public CustomMessage(String content) {
        this.content = content;
    }
}
