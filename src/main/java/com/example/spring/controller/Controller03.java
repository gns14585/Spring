package com.example.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

@Controller
@RequestMapping("main2")
public class Controller03 {
    // https://developer.mozilla.org/en-US/docs/Learn/Common_questions/Web_mechanics/What_is_a_URL
    // 위 주소 도메인 설명

    // /main2/sub1?address=seoul
    @RequestMapping("sub1")
    public void method1(WebRequest request) {
        System.out.println("Controller03.method1");

        String address = request.getParameter("address");
        System.out.println("address = " + address);
    }

    // /main2/sub2?name=son&address=london
    @RequestMapping("sub2")
    public void method2(WebRequest request) {
        String name = request.getParameter("name");
        String address = request.getParameter("address");

        System.out.println("name = " + name);
        System.out.println("address = " + address);
    }

    // /main2/sub3?name=손흥민
    @RequestMapping("sub3")
    public void method3(@RequestParam("name") String name) {
        System.out.println("name = " + name);
    }

    // /main2/sub4?name=김두식&address=서울
    @RequestMapping("sub4")
    public void method4(@RequestParam("name") String name,
                        @RequestParam("address") String address) {
        System.out.println("name = " + name);
        System.out.println("address = " + address);
    }

    // main2/sub5?email=abc@gmail.com&gender=남자&number=010-9999
    @RequestMapping("sub5")
    public void method5(@RequestParam("email") String email,
                        @RequestParam("gender") String gender,
                        @RequestParam("number") String number) {
        System.out.println("email = " + email);
        System.out.println("gender = " + gender);
        System.out.println("number = " + number);
    }

    // /main2/sub6?name=leejunghoon&age=29
    @RequestMapping("sub6")
    public void method6(@RequestParam("name") String name,
                        @RequestParam("age") String age) {
        System.out.println("name = " + name);
        System.out.println("age = " + age);

        Integer a = Integer.valueOf(age);
    }

    @RequestMapping("sub7")
    public void method7(@RequestParam("name") String name,
                        @RequestParam("age") Integer age) {
        System.out.println("name = " + name);
        System.out.println("age = " + age);
    }

    // /main2/sub8?address=seoul&marride=false&age=6
    @RequestMapping("sub8")
    public void method8(@RequestParam("address") String address,
                        @RequestParam("marride") Boolean marride,
                        @RequestParam("age") Integer age) {

        System.out.println("address = " + address);
        System.out.println("marride = " + marride);
        System.out.println("age = " + age);

    }

    // /main2/sub9?name=son
    @RequestMapping("sub9")
    public void method9(@RequestParam(value = "name", required = false) String name) {
        System.out.println("name = " + name);
    }

    // /main2/sub10?address=seoul&age=30
    // /main2/sub10?address=jeju
    // maethod10
    @RequestMapping("sub10")
    public void method10(@RequestParam("address") String address,
                         @RequestParam(value = "age",required = false) Integer age) {
        System.out.println("address = " + address);
        System.out.println("age = " + age);
    }

    // main2/sub11
    @RequestMapping("sub11")
    public void method11(@RequestParam(value = "age", defaultValue = "0") Integer age) {
        System.out.println("age = " + age);
    }

}
