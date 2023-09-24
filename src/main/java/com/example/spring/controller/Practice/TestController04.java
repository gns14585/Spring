package com.example.spring.controller.Practice;

import com.example.spring.domain.Practice.TestDto4;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main10") // 인터넷 브라우저 주소
public class TestController04 {
    @RequestMapping("TestJsp3") // 인터넷 브라우저 주소
    public String method1(TestDto4 dto4, Model model) {
        model.addAttribute("name","Lee Jung Hoon");
        model.addAttribute("age",29);
        model.addAttribute("car", "k3");
        model.addAttribute("mar", "No");
        return "main10/Testjsp3";
    }
}
