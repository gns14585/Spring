package com.example.spring.controller.Practice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("main10")
public class TestController17 {
    @RequestMapping("Testjsp17")
    public void method2(Model model) {
        var map1 = Map.of("phone1", "iphone", "phone2", "galaxy");
        var mpa2 = Map.of("korea", "seoul", "us", "ny");
        var map3 = Map.of("1st", "hamburger", "2nd", "pizza");

        model.addAttribute("phones", map1);
        model.addAttribute("caps", mpa2);
        model.addAttribute("foods", map3);
    }
}
