package com.study.yooil.ocjp;

public class Main {

    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Person();

        p1.setId(1);
        p1.setName("Jung");
        p2.setId(2);
        p2.setName("Hwan");

        System.out.println(p1.getId());
        System.out.println(p1.getName());
        System.out.println();
        System.out.println(p2.getId());
        System.out.println(p2.getName());
    }
}