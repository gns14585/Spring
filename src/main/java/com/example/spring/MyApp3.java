package com.example.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class MyApp3 {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MyApp3.class, args);
        MyClass4 bean = context.getBean("mybean4", MyClass4.class);
        MyClass5 bean1 = context.getBean("myClass5", MyClass5.class);
        System.out.println("bean = " + bean);
        System.out.println("bean1 = " + bean1);

        Object bean2 = context.getBean("controller02");
        System.out.println("bean2 = " + bean2);

        Object bean3 = context.getBean("myApp3");
        System.out.println("bean3 = " + bean3);
        // @Controller, @Component 등 이런 애너테이션이 들어가 있으면 객체를 자동 생성하게끔 스프링 컨테이너에서 도와줌
        // 그래서 이런 애너테이션이 있으면 객체를 따로 생성 할 필요가 없음.
    }
}
@Component // spring bean의 이름을 명시하지 않으면 클래스이름 -> lowerCamelCase(첫글자 소문자)
class MyClass5 { // bean 이름 : myClass5

}
@Component("mybean4")
class MyClass4 {

}
