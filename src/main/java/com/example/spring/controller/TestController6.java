package com.example.spring.controller;

import com.example.spring.domain.TestDto6;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main10")
public class TestController6 {
    @RequestMapping("Testjsp6")
    public String method(TestDto6 dto6, Model model) {
        model.addAttribute("name", "leejunghoon");
        model.addAttribute("address", "seoul");
        model.addAttribute("age", 29);
        return "main10/Testjsp6";
    }
}
