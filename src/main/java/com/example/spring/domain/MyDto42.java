package com.example.spring.domain;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class MyDto42 {
    private String city;
    private Integer age;
    private Boolean married;
    private String car;
    private Map<String, Object> home;
    private List<String> foods;
}
