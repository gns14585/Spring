package com.example.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data                   // getter, setter, toString, hashcode, equals 셋팅
@AllArgsConstructor     // 필드에 있는 변수들 매개변수 있는 생성자 생성
@NoArgsConstructor      // 기본 생성자 생성
public class TestDto9 {
    private String movie;   // 영화명
    private String contry;  // 나라별
    private String kind;    // 종류
    private String age;     // 연령

}
