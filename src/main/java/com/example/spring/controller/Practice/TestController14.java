package com.example.spring.controller.Practice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main10")
public class TestController14 {
    @RequestMapping("Testjsp14")
    public void method(Model model) {
        String[] name = {"이정훈", "박채은"};
        String[] email = {"gns14@nav.com", "ch12@nav.com", "eo12@na.com"};
        String[] add = {"seoul", "jeju"};
        model.addAttribute(
                "myName", name);
        model.addAttribute(
                "yourEmail", email);
        model.addAttribute(
                "herAddress", add);
    }


}
