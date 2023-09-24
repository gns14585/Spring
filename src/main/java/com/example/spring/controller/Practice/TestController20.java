package com.example.spring.controller.Practice;

import com.example.spring.domain.Practice.TestDto20;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main10")
public class TestController20 {
    @RequestMapping("Testjsp20")
    public void method(TestDto20 dto20, Model model) {
        model.addAttribute("student", dto20);
    }
}
