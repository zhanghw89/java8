package com.example.java8.lambad;


import java.util.function.Predicate;

/**
 * @author 张会文 (Email: zhanghuiwen@icourt.cc)
 * @date 2017/11/25 下午10:58
 */
public class Example1 {
    public static void main(String[] args) {
        //启动一个线程执行一个任务
        test();
    }


    //eg1:执行hello word
    private static void executeHelloWord1() {
        String name = "zhangsan";
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello lmbda！hello " + name);
            }
        }).start();
    }

    //eg2:java8 执行hello word
    private static void executeHelloWord2() {
//        Runnable r = () -> System.out.println("hello lmbda！");

        new Thread(() -> System.out.println("hello lmbda！")).start();
    }

    private static void test() {
        Predicate<Integer> atLeast5 = x -> x > 5;
        System.out.println(atLeast5.test(3));

        Runnable noArguments = () -> System.out.print("hello,Lambda");
        noArguments.run();
    }

}