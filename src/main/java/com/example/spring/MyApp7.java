package com.example.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class MyApp7 {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MyApp7.class, args);
        System.out.println(context.getBean("myClass12"));
        System.out.println(context.getBean("myClass11", MyClass11.class).getDep());
    }
}
@Component
class MyClass12 {

}

@Component
class MyClass11 {
    private MyClass12 dep;

    // 생성자가 기본생성자, 매개변수있는 생성자 중 1개만 있는 상황이라면 (매개변수 있는 생성자) @Autowierd 애너테이션은 생략 가능(자동주입)

    public MyClass11() {
    }

    @Autowired // 생성자 주입
    public MyClass11(MyClass12 dep) {
        this.dep = dep;
    }

    public MyClass12 getDep() {
        return dep;
    }
}