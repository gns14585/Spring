package com.example.spring.controller.Practice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("main10")
public class TestController15 {
    @RequestMapping("Testjsp15")
    public void method(Model model) {
        var map1 = Map.of("seoul", "서울", "busan", "부산");
        var map2 = Map.of("red", "빨강", "blue", "파랑", "black", "검정");
        model.addAttribute("cityMap", map1);
        model.addAttribute("color", map2);

    }
}
