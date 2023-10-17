package com.example.spring;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class MyApp11 {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MyApp10.class, args);
    }
}

interface MyInterface2 {
    public void method2();
}

class MyClass21 implements MyInterface2 {
    public void method2() {}
}

@Component
class MyClass22 implements MyInterface2 {
    public void method2() {}
}

@Component
@RequiredArgsConstructor
class MyClass20 {
    private final MyInterface2 field;

    public void method20() {
        field.method2();
    }
}
