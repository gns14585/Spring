package com.example.spring.domain;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor // 매개변수 없는 생성자 필요할때 선언 (기본생성자)
//@RequiredArgsConstructor // final 필드를 선언하면 매개변수 있는 생성자가 만들어짐
@AllArgsConstructor // 생성자를 만드는데, 매개변수 안에 필드에 있는 모든 변수들이 들어감
public class MyDto5 {
    private String name;
    private  Integer age;
}
