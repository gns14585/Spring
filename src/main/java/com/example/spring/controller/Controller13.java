package com.example.spring.controller;

import com.example.spring.domain.MyDto11;
import com.example.spring.domain.MyDto12;
import com.example.spring.domain.MyDto13;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("main13")
public class Controller13 {
    @RequestMapping({"sub1", "sub2", "sub4", "sub7", "sub9", "sub11", "sub13"})
    public void method1() {

    }

    @RequestMapping("sub3")
    // 날짜는 LocalDate로 반환타입 받아야함
    public void method3(String param1, String param2, String param3, LocalDate param4, LocalDateTime param5,
                        String param6, String[] param8, @RequestParam("param8")List<String> param9) {
        System.out.println("param1 = " + param1);
        System.out.println("param2 = " + param2);
        System.out.println("param3 = " + param3);
        System.out.println("param4 = " + param4);
        System.out.println("param5 = " + param5);
        System.out.println("param6 = " + param6);

//        Arrays.stream(param8).forEach(System.out::println);
//
//        System.out.println("list로 받음");
//        param9.forEach(System.out::println);
    }

    // 예제 아이디, 이메일, 생일, 취미
    @RequestMapping("sub5")
    public void method4(String userId, String userEmail, LocalDate birthDate,
                        @RequestParam("hobby") List<String> hobby2) {

        System.out.println("userId = " + userId);
        System.out.println("userEmail = " + userEmail);
        System.out.println("birthDate = " + birthDate);
        hobby2.forEach(System.out::println);
    }

    // 자바 빈으로 작성법
    @RequestMapping("sub6")
    public void method6(MyDto11 user) {
        System.out.println("user = " + user);
    }

    // 예제
    @RequestMapping("sub8")
    public void method8(MyDto12 info) {
        System.out.println("info = " + info);
    }

    @RequestMapping("sub10")
    public void method10(String title, String contentBody) {
        System.out.println("title = " + title);
        System.out.println("contentBody = " + contentBody);
    }

    @RequestMapping("sub12")
    public void method12(MyDto13 dto13) {
        System.out.println("dto13 = " + dto13);
    }

    @RequestMapping("sub14")
    public void method(String hobby, List<String> food) {
        System.out.println("hobby = " + hobby);
        System.out.println("food = " + food);
    }

}
