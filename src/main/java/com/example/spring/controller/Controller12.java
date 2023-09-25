package com.example.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("main12")
public class Controller12 {
    @RequestMapping("sub1")
    public void method1() {

    }

    @RequestMapping("asub2/bsub2/csub2/dsub2/esub2")
    public void method2() {

    }

    @RequestMapping("sub3")
    public void method3() {

    }

    @RequestMapping("sub4")
    public void method4(@RequestParam("name") String name,
                        @RequestParam("age") Integer age,
                        Model model) {
        System.out.println("Controller12.method4");
        System.out.println(name + "과 " + age + "를 저장함");

        model.addAttribute("message", name + "과 " + age + "를 저장함");
    }

    // 예제 sub5에서 검색했을때 sub6에 검색결과 + 다시 검색하러가기 문구 눌렀을때 다시 검색하는 화면 나오게 하기
    @RequestMapping("sub5")
    public void method5() {

    }

    @RequestMapping("sub6")
    public void method6(@RequestParam("name") String name, Model model) {
        System.out.println(name + "검색 결과 입니다.");

        model.addAttribute("mes", name + " 검색 결과 입니다.");
    }
}
