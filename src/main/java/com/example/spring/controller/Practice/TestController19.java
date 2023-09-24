package com.example.spring.controller.Practice;

import com.example.spring.domain.MyDto19;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main10")
public class TestController19 {
    @RequestMapping("Testjsp19")
    public void method(Model model) {
        MyDto19 o1 = new MyDto19();
        o1.setFood("pizza");
        o1.setBirthDate("2020-01-01");
        model.addAttribute("person1", o1);

    }
}
