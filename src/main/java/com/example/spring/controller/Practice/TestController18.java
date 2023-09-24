package com.example.spring.controller.Practice;

import com.example.spring.domain.Practice.TestDto18;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main10")
public class TestController18 {
    @RequestMapping("Testjsp18")
    public void method(TestDto18 dto18, Model model) {
        model.addAttribute("attr3", dto18);
    }
}
