package com.example.spring.controller;

import com.example.spring.domain.TestDto7;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main10")
public class TestContorller07 {
    @RequestMapping("Testjsp7")
    public void method(TestDto7 dto7, Model model) {
        model.addAttribute("name", "이정훈");
        model.addAttribute("address", "서울");

    }
}
