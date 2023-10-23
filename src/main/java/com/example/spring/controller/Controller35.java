package com.example.spring.controller;

import com.example.spring.domain.MyDto38;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("main35")
public class Controller35 {

    @GetMapping("sub1")
    public void method1() {

    }

    @GetMapping("sub2")
    public void method2() {
        System.out.println("Controller35.method2");
    }

    @GetMapping("sub3")
    public void method3(String address) {
        System.out.println("address = " + address);
    }

    @GetMapping("sub4")
    public void method4(String address, String name, Integer age, String email) {
        System.out.println("address = " + address);
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        System.out.println("email = " + email);
    }

    // 예제 , ajax5();
    @GetMapping("sub5")
    public void method5(String city, Integer id, Double score, String country) {
        System.out.println("city = " + city);
        System.out.println("id = " + id);
        System.out.println("score = " + score);
        System.out.println("country = " + country);
    }

    // /main35/sub6?eid=3&lastName=son&firstName=hm
    @GetMapping("sub6")
    public void method6(MyDto38 dto) {
        System.out.println("dto = " + dto);
    }

    @PostMapping("sub7")
    public void method7() {
        System.out.println("Controller35.method7");
    }
}


























