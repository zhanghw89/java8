package com.example.java8.defaultmethod;

interface Formula {
    double calculate(int a);
 
    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}
