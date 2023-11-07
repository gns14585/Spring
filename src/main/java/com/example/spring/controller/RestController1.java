package com.example.spring.controller;

import com.example.spring.dao.MyDao10;
import com.example.spring.domain.MyDto34Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("api/main1")
public class RestController1 {

    private final MyDao10 dao;

    // http://localhost:8080/api/main1/sub1
    @GetMapping("sub1")
    @ResponseBody
    public String method1() {

        return "customer name!!";
    }

    // http://localhost:8080/api/main1/sub2
    // get 요청시
    // 5번 고객의 customerName 응답

    @GetMapping("sub2")
    @ResponseBody
    public String method2() {

        return dao.selectCustomerId();
    }

    @GetMapping("sub3")
    @ResponseBody
    public MyDto34Customer method3() {
        return dao.getCustomer();
    }

}
