package com.example.spring.domain;

import lombok.Data;

@Data
public class MyDto24 {
    // sql의 별칭이랑 필드명이 맞지 않으면 Exception 발생
    private Integer id;
    private String name;
    private String country;
}
