package com.example.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main8")
public class Controller8 {
    @RequestMapping("sub1")
    public void method1(Model model) { // lombok 임포트클래스 하면안되고 sprin framework 로 해야함
        model.addAttribute("attr1", "value1");
        model.addAttribute("attr2", "value2");
        // forward to /WEB-INF/jsp/main8/sub1.jsp
    }

    @RequestMapping("sub2")
    public void method(Model model) {
        model.addAttribute("propone1", "😂");
        model.addAttribute("propTWO", "😊");
    }
}
