package com.example.spring.controller;

import com.example.spring.domain.TestDto3;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main10")
public class TestController3 {
    @RequestMapping("TestHtml")
    public String method1(TestDto3 dt3, Model m) {
        m.addAttribute("name", "이정훈");
        m.addAttribute("age", 29);
        return "main10/Testhtml";
    }
}
