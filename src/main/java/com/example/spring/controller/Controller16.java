package com.example.spring.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("main16")
public class Controller16 {

    @Autowired
    public ServletContext application;

    @RequestMapping("sub1")
    public void method1(Model model, HttpSession session) {
        model.addAttribute("modelAttr1", "추석");
        session.setAttribute("sessionAttr1", "강강술래");
        application.setAttribute("appAttr1", "보름");

        model.addAttribute("attr1", "송편");
        session.setAttribute("attr1", "윷놀이");
        application.setAttribute("attr1", "토끼");
    }

    @RequestMapping("sub2")
    public void method2(HttpSession session) {
        Object count = session.getAttribute("count");
        if (count == null) {
            session.setAttribute("count", 0);
        } else {
            Integer countInt = (Integer) count;
            session.setAttribute("count", ++countInt);
        }

        Object appCount = application.getAttribute("count");
        if (appCount == null) {
            application.setAttribute("count", 0);
        } else {
            Integer countInt = (Integer) appCount;
            countInt++;
            application.setAttribute("count", countInt);
        }
    }

    // 밑 두개의 model은 서로 다른 객체임 , session은 같은 객체

    @RequestMapping("sub3")
    public void method3(Model model, HttpSession session) {
        model.addAttribute("modelAttr1", "보름달");
        session.setAttribute("sessionAttr1", "송편");
    }

    @RequestMapping("sub4")
    public void method4(Model model, HttpSession session) {
        Object modelAttr1 = model.getAttribute("modelAttr1");
        Object sessionAttr1 = session.getAttribute("sessionAttr1");

        System.out.println("modelAttr1 = " + modelAttr1);
        System.out.println("sessionAttr1 = " + sessionAttr1);
    }

    @GetMapping("sub5")
    public String method5() {

        return "/main16/sub5"; // view name
    }

    // redirection
    @GetMapping("sub6")
    public String method6() {

        // 다른곳(location)으로 가!! 라는 응답(response, 302)
        return "redirect:/main16/sub5";
    }

    @GetMapping("sub7")
    public String method7() {
        return "redirect:https://www.naver.com";
    }

    //
    @GetMapping("sub8")
    public String method8(String email) {
        String processed = email + "processed";

        return "redirect:/main16/sub9?p="+processed;
    }

    @GetMapping("sub9")
    public void method(String p) {
        System.out.println("p = " + p);
    }

    @GetMapping("sub10")
    public String method10(String name, HttpSession session) {
        String processed = name + " 처리 결과";
        session.setAttribute("processedValue", processed);

        return "redirect:/main16/sub11";
    }

    @GetMapping("sub11")
    public void method11(HttpSession session) {
        Object processedValue = session.getAttribute("processedValue");
        System.out.println("processedValue = " + processedValue);
    }

    @GetMapping("sub12")
    // method12()매개변수 안에 session을 넣으면 안전하지 않아서
    // RedirectAttrivutes를 대신 넣을 수 있음
    // 이걸 사용하게 되면 두번째 코드에서 Model을 사용 가능함
    public String method12(String address, RedirectAttributes rttr) {
        String processed = address + " 처리 결과";
        rttr.addFlashAttribute("processedValue", processed);
        return "redirect:/main16/sub13";
    }

    @GetMapping("sub13")
    public void method(Model model) {
        Object processed = model.getAttribute("processedValue");
        System.out.println("processed = " + processed);
    }

    // 첫 요청을 /main16/sub14
    @GetMapping("sub14")
    public String method14(RedirectAttributes rat) {
        rat.addFlashAttribute("foodList", List.of("피자", "송편"));
        return "redirect:/main16/sub15";
    }

    @GetMapping("sub15")
    public void method15() {

    }

    @GetMapping("sub16")
    public String method16(RedirectAttributes rttr) {
        // addFlashAttrtibute : 모델에 붙음
        rttr.addFlashAttribute("flashAttr", "모델에 붙음");

        // addAttribute : 쿼리스트링에 붙음
        rttr.addAttribute("attr1", "쿼리스트링에 붙음");
        rttr.addAttribute("address", "서울 신촌");
        return "redirect:/main16/sub17";
    }

    @GetMapping("sub17")
    public void method17() {
        System.out.println("Controller16.method17");
    }
}
