package com.example.spring.controller;

import com.example.spring.domain.TestDto5;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main10")
public class TestController05 {
    @RequestMapping("Testjsp5")
    public String method(TestDto5 dto5, Model model) {
        model.addAttribute("name", "LeeJungHoon");
        model.addAttribute("age", 29);
        model.addAttribute("address", "seoul");
        return "main10/Testjsp5";
    }
}
