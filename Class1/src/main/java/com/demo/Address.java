package com.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
public class Address {

    private String addres;

    public Address(){}
    public Address(String addres) {
        this.addres = addres;
    }

    public void showAddress(){
        System.out.println("Address showAddress");
    }
    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }
}
