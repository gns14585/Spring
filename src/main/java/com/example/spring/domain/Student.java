package com.example.spring.domain;

public class Student {
    // email property (쓰기(set))
    // info(x) Information property (읽기(get), 쓰기(set))
    private String email;
    private String info;

//    public String getEmail() {
//        return email;
//    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInforamtion() {
        return info;
    }

    public void setInforamtion(String info) {
        this.info = info;
    }
}
