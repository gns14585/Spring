package com.example.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main1") // 경로 앞부분이 동일하면 Controller 밑에 공통경로 지정가능
public class Controller02 {

    // @RequestMapping("/main1/sub1 or sub2") 경로 중 앞부분이 같은경우 동일한 클래스에서 진헹
    // 경로 앞에 "/" 생략가능
    @RequestMapping("/sub1")
    public void method1() {
        System.out.println("Controller02.method1");
    }

    // /main1/sub2

    @RequestMapping("/sub2")
    public void method2() {
        System.out.println("Controller02.method2");
    }

    @RequestMapping("/sub3")
    public void method3() {
        System.out.println("Controller02.method3");
    }
}
