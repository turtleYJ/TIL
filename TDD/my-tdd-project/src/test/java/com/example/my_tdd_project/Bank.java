package com.example.my_tdd_project;

public class Bank {
    public Money reduce(Expression source, String to) {
        return source.reduce(to);
    }
}
