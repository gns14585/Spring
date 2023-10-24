package com.example.spring.domain;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MyDto41 {
    private String lastName;
    private String firstName;
    private LocalDate birthDate;
    private Integer id;
}
