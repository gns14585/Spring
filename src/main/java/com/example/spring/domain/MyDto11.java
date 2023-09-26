package com.example.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyDto11 {
    private String userId;
    private String userEmail;
    private LocalDate birthDate;
    private List<String> hobby;
}
