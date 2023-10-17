package com.example.spring;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class MyApp9 {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MyApp9.class, args);
        MyClass16 myClass16 = context.getBean("myClass16", MyClass16.class);
        MyClass15 myClass15 = context.getBean("myClass15", MyClass15.class);

        System.out.println("myClass16 = " + myClass16);
        System.out.println("myClass15.getField() = " + myClass15.getField());
    }
}
@Component
class MyClass16 {
    
}
@Component
@RequiredArgsConstructor // final 필드를 argument로 받는 생성자 만들어주는 lombok annotation
class MyClass15 {
    // final 은 값을 딱 1번 받아야 하는데 생성자에서 받아와야함 : @RequiredArgsConstructor
    private final MyClass16 field;

    public MyClass16 getField() {
        return field;
    }
}

