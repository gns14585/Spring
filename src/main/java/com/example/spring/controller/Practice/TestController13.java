package com.example.spring.controller.Practice;

import com.example.spring.domain.Practice.TestDto13;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main10")
public class TestController13 {
    @RequestMapping("Testjsp13")
    public void method(TestDto13 dto13, Model model) {
        model.addAttribute("myName", "이정훈");
        model.addAttribute("yourAddress", "서울");
        model.addAttribute("herEmail", "ab1@nav.com");
    }
}
