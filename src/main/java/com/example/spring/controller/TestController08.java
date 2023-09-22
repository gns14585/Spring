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
        list.add(new TestDto9("반지의제왕", "외국", "판타지", "12세"));
        list.add(new TestDto9("타짜", "한국", "드라마", "19세"));
        list.add(new TestDto9("엘리멘탈", "외국", "애니메이션", "12세"));
        list.add(new TestDto9("가문의영광", "한국", "코미디", "12세"));
        list.add(new TestDto9("무빙", "한국", "드라마", "12세"));

        model.addAttribute("mov", list);
    }
}
