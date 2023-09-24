package com.example.spring.controller.Practice;

import com.example.spring.domain.Practice.TestDto22;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("main10")
public class TestController22 {
    @RequestMapping("Testjsp22")
    public void method(Model model) {
        TestDto22 o1 = new TestDto22();
        TestDto22 o2 = new TestDto22();

        o1.setLastName("두식");
        o2.setLastName("봉석");

        model.addAttribute("people",
                Map.of("1st", o1, "2nd", o2));


        o1.setCars(List.of("k3", "k5", "k7"));
        model.addAttribute("person1", o1);
    }
}
