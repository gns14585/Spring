package com.example.spring.controller;

import com.example.spring.domain.TestDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main8") // 인터넷 브라우저 주소
public class TestController {
    @RequestMapping("Testjsp") // 인터넷 브라우저 주소
    public String method1(TestDto dt, Model model) {
        model.addAttribute("name", "이정훈");
        model.addAttribute("age", "29");
        model.addAttribute("address", "은평구");
        model.addAttribute("marr", "x");
        return "main8/Testjsp";
    }
}
