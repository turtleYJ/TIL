package com.study.yooil.ocjp;

import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
        double price = 90000;
        String model;
        if(price > 100000) {
            model = "Tesla Model X";
        } else if(price <= 100000) {
            model = "Tesla Model S";
        }
          System.out.println(model);
    }
}