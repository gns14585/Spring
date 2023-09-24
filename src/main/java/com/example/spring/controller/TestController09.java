package com.example.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("main10")
public class TestController09 {
    @RequestMapping("Testjsp10")
    public void method(Model model) {
        var map1 = Map.of("phone1", "iphone", "contry", "korea", "movie", "loadofthering");
        var map2 = Map.of("phone2", "galxi", "contry", "japan", "movie", "moving");

        model.addAttribute("moving1", map1);
        model.addAttribute("moving2", map2);

    }
}
