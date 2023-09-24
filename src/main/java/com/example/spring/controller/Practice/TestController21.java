package com.example.spring.controller.Practice;

import com.example.spring.domain.Practice.TestDto21;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("main10")
public class TestController21 {
    @RequestMapping("Testjsp21")
    public void method(Model model) {
        TestDto21 o1 = new TestDto21();
        TestDto21 o2 = new TestDto21();
        TestDto21 o3 = new TestDto21();
        o1.setFirstName("son");
        o2.setFirstName("lee");
        o3.setFirstName("kim");

        model.addAttribute(
                "studentList", List.of(o1, o2, o3));

        TestDto21 o4 = new TestDto21();
        TestDto21 o5 = new TestDto21();

        o4.setListName("두식");
        o5.setListName("봉석");

        model.addAttribute(
                "personMap", Map.of("person1", o4, "person2", o5)
        );
    }

}
