package com.example.cruddemo.service;


//@Service
public class HomeService {

    private String name;

    public HomeService() {
        System.out.println();
    }

    public HomeService(String name) {
        System.out.println("Name" + name);
        this.name = name;
    }

    public void home() {
        System.out.println("Home " + this.name);
    }
}
