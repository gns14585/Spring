package com.example.spring.controller;

import com.example.spring.domain.TestDto11;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main10")
public class TestController11 {
    @RequestMapping("Testjsp11")
    public void method(TestDto11 dto11, Model model) {
        model.addAttribute("name", "이정훈");
        model.addAttribute("age", 29);
        model.addAttribute("address","seoul");
        model.addAttribute("number", 36138304);

    }
}
