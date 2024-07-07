package com.example.my_tdd_project;

public interface Expression {
    Money reduce(Bank bank, String to);

    Expression plus(Expression tenFrancs);
}
