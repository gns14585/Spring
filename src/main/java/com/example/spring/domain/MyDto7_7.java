package com.example.spring.domain;

public class MyDto7_7 {

    private String address;
    private String email;
    private Integer age;

    public String getAddress() {
        return "서울";
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return "gns14585@naver.com";
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return 29;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return "김봉석";
    }

    @Override
    public String toString() {
        return "내가 만든 클래스😂";
    }
}
