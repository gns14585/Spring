package com.example.spring.controller;

import com.example.spring.domain.TestDto8;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("main10")
public class TestController07 {
    @RequestMapping("Testjsp8")
    public void method1(Model model) {
        List<TestDto8> list = new ArrayList<>();

        list.add(new TestDto8("1", "이정훈", 29, "은평구"));
        list.add(new TestDto8("2", "박채은", 25, "서대문구"));
        list.add(new TestDto8("3", "민하연", 26, "금천구"));
        list.add(new TestDto8("4", "박민정", 26, "금천구"));
        list.add(new TestDto8("5", "전은혜", 26, "금천구"));
        list.add(new TestDto8("6", "이동진", 29, "영등포구"));

        model.addAttribute("Info", list);
    }
}
