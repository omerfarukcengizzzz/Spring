package com.cybertek.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class ResponseWrapper {

    private boolean success;
    private String message;
    private Integer code;
    private Object data;

    public ResponseWrapper(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    public ResponseWrapper(String message) {
        this.message = message;
    }
}
