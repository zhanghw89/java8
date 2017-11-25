package com.example.java8.lambad;

import java.util.Comparator;

/**
 * Created by shiwen on 2017/8/31.
 */
public class CompareV1  implements Comparator<String> {
    public static void main(String[] args) {
        CompareV1 compareV1 = new CompareV1();
        compareV1.compare("str1","10");

    }


    @Override
    public int compare(String o1, String o2) {
        return Integer.compare(o1.length(),o2.length());
    }
}
