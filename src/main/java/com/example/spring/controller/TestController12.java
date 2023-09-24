package com.example.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("main10")
public class TestController12 {
    @RequestMapping("Testjsp12")
    public void method(Model model) {
        List<TestDto12> list = new ArrayList<>();
        list.add(new TestDto12("이정훈", 29, "남", "은평구"));
        list.add(new TestDto12("이동진", 29, "남", "영등포"));
        list.add(new TestDto12("박채은", 25, "여", "은평구"));
        list.add(new TestDto12("민하연", 26, "여", "금천구"));
        list.add(new TestDto12("이정훈", 26, "여", "금천구"));
        list.add(new TestDto12("이정훈", 26, "여", "금천구"));

        model.addAttribute("Info", list);


    }
}
