package com.example.spring.controller;

import org.springframework.lang.NonNull;
import org.springframework.lang.NonNullApi;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
// address 가 없다면 호출 불가
// 여러개로 설정한다면 { } 안에 기재
@RequestMapping(value = "main5")
public class Controller05 {
    // main5/sub1?name=lee&age=33&address-paris
    @RequestMapping("sub1")
    public void method1(String name, Integer age, String address) {
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        System.out.println("address = " + address);
    }

    // /main5/sub2?name=lee&age=44&address=paris
    @RequestMapping("sub2")
    public void method2(String name, Integer age, String address) {
        Person5 o1 = new Person5();
        o1.setName(name);
        o1.setAge(age);
        o1.setAddress(address);

//        service.action(o1);
        System.out.println(o1);
    }

    // /main5/sub3?name=lee&age=44&address=paris
    // 메소드 매개변수에 클래스만 넣어도 가능
    @RequestMapping(value = "sub3")
    public void method3(Person5 person5) {
        System.out.println("person5 = " + person5);
    }

    // /main5/sub4?email=gns14585@naver.com&married=true&age=33&info=programmer
    // Student5 클래스 작성
    @RequestMapping("sub4")
    public void method4(Student5 student5) {
        System.out.println("student5 = " + student5);
    }
}

class Student5 {
    private String email;
    private Boolean married;
    private Integer age;
    private String info;

    @Override
    public String toString() {
        return "Student5{" +
                "email='" + email + '\'' +
                ", married=" + married +
                ", age=" + age +
                ", info='" + info + '\'' +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getMarried() {
        return married;
    }

    public void setMarried(Boolean married) {
        this.married = married;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}

class Person5 {
    private String name;
    private Integer age;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person5{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}