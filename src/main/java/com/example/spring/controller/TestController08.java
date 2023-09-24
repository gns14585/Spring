package com.example.spring.controller;

import com.example.spring.domain.TestDto9;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("main10")
public class TestController08 {
    @RequestMapping("Testjsp9")
    public void method(Model model) {
        List<TestDto9> list = new ArrayList<>();
        list.add(new TestDto9("반지의제왕", "판타지", "12세", "외국"));
        list.add(new TestDto9("신세계", "느와르", "19세", "한국"));
        list.add(new TestDto9("위쳐", "판타지", "19세", "외국"));
        list.add(new TestDto9("타짜", "도박", "19세", "한국"));
        list.add(new TestDto9("엘리멘탈", "애니메이션", "12세", "외국"));
        list.add(new TestDto9("무빙", "드라마", "12세", "한국"));
        list.add(new TestDto9("스파이더맨", "판타지", "12세", "외국"));
        list.add(new TestDto9("아이언맨", "판타지", "12세", "외국"));

        model.addAttribute("mov", list);

    }
}
