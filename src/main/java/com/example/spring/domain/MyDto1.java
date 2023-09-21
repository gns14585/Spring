package com.example.spring.domain;

public class MyDto1 {
    // property 명 : get/set 없애고 소문자로 시작
    // name property
    // homeAddress property
    private String name;
    private String homeAddress;
    private String MYHOME;
    private Boolean married;
    private boolean checked;


    // boolean 기본타입일땐 get 대신 is로 해도 됨. 편한대로 사용
    // Boolean 참조타입일땐 get으로 나옴
    public boolean isChecked() {

        return checked;
    }

    public void setChecked(boolean checked) {

        this.checked = checked;
    }

    public Boolean getMarried() {
        return married;
    }

    public void setMarried(Boolean married) {
        this.married = married;
    }

    public String getMYHOME() {
        return MYHOME;
    }

    public void setMYHOME(String MYHOME) {
        this.MYHOME = MYHOME;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
