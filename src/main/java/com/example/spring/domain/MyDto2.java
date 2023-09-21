package com.example.spring.domain;

public class MyDto2 {
    // name property
    // address property
    // birthDate property
    // signed property

    private String name;
    private String address;
    private String birthDate;
    private Boolean signed;

    @Override
    public String toString() {
        return "MyDto2{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", signed=" + signed +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Boolean getSigned() {
        return signed;
    }

    public void setSigned(Boolean signed) {
        this.signed = signed;
    }
}
