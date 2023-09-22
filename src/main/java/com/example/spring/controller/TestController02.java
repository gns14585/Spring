package com.example.spring.controller;

import com.example.spring.domain.TestDto2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main8") // 인터넷 브라우저 주소
public class TestController02 {
    @RequestMapping("TestJsp2") // 인터넷 브라우저 주소
    public String method2(TestDto2 dto2, Model model) {
        model.addAttribute("car","자동차");
        model.addAttribute("run", "달린다");
        return "main8/Testjsp2";
    }
}
