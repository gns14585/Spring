package com.example.spring.controller.Practice;

import com.example.spring.domain.MyDto9;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("main10")
public class TestController23 {
    @RequestMapping("Testjsp23")
    public void method(Model model) {
        model.addAttribute("myList", List.of("tesla","kia","benz"));
    }

    @RequestMapping("Testjsp24")
    public void method2(Model model) {
        model.addAttribute("foodList",
                List.of("햄버거", "피자", "족발", "보쌈"));
        model.addAttribute("names",
                List.of("두식","봉석","희수","미현"));
    }

    @RequestMapping("Testjsp25")
    public void method3(Model model) {
        List<MyDto9> list = new ArrayList<>();
        list.add(new MyDto9(31L, "son", "hm", "football", "010"));
        list.add(new MyDto9(32L, "lee", "ki", "paris", "011"));
        list.add(new MyDto9(33L, "김", "두식", "서울", "02"));
        list.add(new MyDto9(34L, "김", "봉석", "부산", "03"));
        list.add(new MyDto9(35L, "장", "희수", "제주", "05"));

        model.addAttribute("moving", list);


    }

}
