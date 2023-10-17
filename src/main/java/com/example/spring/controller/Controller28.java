package com.example.spring.controller;

import com.example.spring.dao.MyDao2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("main28")
@RequiredArgsConstructor
public class Controller28 {

    private final MyDao2 dao;

    @GetMapping("sub1")
    public void method1(Integer id) throws Exception {
        String name = dao.select(id);
        System.out.println("name = " + name);
    }
}
