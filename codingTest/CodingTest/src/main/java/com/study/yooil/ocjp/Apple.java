package com.study.yooil.ocjp;

import java.util.ArrayList;
import java.util.List;

public class Apple {
    public String color;

    public Apple(String color) {
        this.color = color;
    }

    public static void main(String [] args) {
        Apple apple = new Apple("GREEN");
        System.out.println(apple.color);
    }
}



