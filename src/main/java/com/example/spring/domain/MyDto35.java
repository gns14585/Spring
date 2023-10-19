package com.example.spring.domain;

import lombok.Data;
import lombok.Getter;

public class MyDto35 {
    private String id;
    private String uRL;

    // 프로퍼티명 : id (get제외, Id 중 첫글자 소문자)
    public String getId() {
        return id;
    }
}
