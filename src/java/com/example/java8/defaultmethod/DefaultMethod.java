package com.example.java8.defaultmethod;

/**
 * Created by shiwen on 2017/9/5.
 */
public class DefaultMethod implements Formula
{
    @Override
    public double calculate(int a) {
        return 0;
    }

    public static void main(String[] args) {
        Formula f = new DefaultMethod();
//        f.sqrt(100);
    }
}
