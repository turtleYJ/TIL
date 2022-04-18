package com.study.yooil.ocjp;

import java.time.LocalDate;

public class Test {
    public static void main(String [] args) {
        LocalDate joiningDate = LocalDate.parse("2006-03-16");
        System.out.println(joiningDate.withDayOfYear(29));
    }
}







