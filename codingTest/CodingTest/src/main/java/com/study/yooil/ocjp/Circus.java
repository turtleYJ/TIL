package com.study.yooil.ocjp;

class Animal {
    protected void jump() {
        System.out.println("Animal");
    }
}

class Cat extends Animal {
    public void jump(int a) {
        System.out.println("Cat");
    }
}

class Deer extends Animal {
    public void jump() {
        System.out.println("Deer");
    }
}

public class Circus {
    public static void main(String[] args) {
        Animal cat = new Cat();
        Animal deer = new Deer();
        cat.jump();
        deer.jump();
    }
}