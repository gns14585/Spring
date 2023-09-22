package com.example.spring.controller;

import com.example.spring.domain.MyDto10;
import com.example.spring.domain.MyDto9;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("main10")
public class Contorller10 {
    @RequestMapping("sub1")
    public void method1(Model model) {
        MyDto9 o1 = new MyDto9();
        MyDto9 o2 = new MyDto9();
        MyDto9 a1 = new MyDto9();
        MyDto9 a2 = new MyDto9();
        MyDto9 a3 = new MyDto9();


        o1.setFirstName("son");
        o2.setFirstName("lee");

        model.addAttribute("students", List.of(o1, o2));

        a1.setFirstName("Lee");
        a2.setFirstName("Jung");
        a3.setFirstName("Hoon");

        model.addAttribute("studentList", List.of(a1,a2,a3));
    }

    @RequestMapping("sub2")
    public void method2(Model model) {
        MyDto9 o1 = new MyDto9();
        MyDto9 o2 = new MyDto9();

        o1.setLastName("두식");
        o2.setLastName("봉석");

        model.addAttribute("personMap", Map.of("person1", o1, "person2", o2));

        model.addAttribute("people", Map.of("1st", o1, "2nd", o2));
    }

    @RequestMapping("sub3")
    public void method3(Model model) {
        MyDto10 o1 = new MyDto10();
        o1.setName("doosik");
        o1.setId(3);
        o1.setFoods(List.of("pizza", "burger", "milk"));
        o1.setCars(List.of("k3", "k5", "k7"));

        model.addAttribute("person1", o1);

    }

    @RequestMapping("sub4")
    public void method4(Model model) {
        model.addAttribute("myList", List.of("tesla", "kia", "benz"));

    }

    @RequestMapping("sub5")
    public void method5(Model model) {
        model.addAttribute("foodList", List.of("고등어구이", "제육볶음", "돼지김치찌개"));
        model.addAttribute("names", List.of("두식", "봉석", "희수", "미현"));
        model.addAttribute("foods", List.of("pizza", "milk", "water", "salad"));
    }

    @RequestMapping("sub6")
    public void method6(Model model) {
        List<MyDto9> list = new ArrayList<>();
        list.add(new MyDto9(31L, "son", "hm", "football", "010"));
        list.add(new MyDto9(32L, "lee", "ki", "paris", "011"));
        list.add(new MyDto9(33L, "김", "두식", "서울", "02"));
        list.add(new MyDto9(34L, "김", "봉석", "부산", "03"));
        list.add(new MyDto9(35L, "장", "희수", "제주", "05"));

        model.addAttribute("moving", list);

    }
}





















