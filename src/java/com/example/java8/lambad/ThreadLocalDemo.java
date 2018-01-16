package com.example.java8.lambad;

/**
 * @author 张会文 (Email: zhanghuiwen@icourt.cc)
 * @date 2018/1/15 下午12:56
 */
public class ThreadLocalDemo {
    public static void main(String[] args) {
        getOldThreadLocal();
        getNewThreadLocal();

    }

    private static void getOldThreadLocal() {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("test");
        System.out.println(threadLocal.get());
    }

    private static void getNewThreadLocal() {
        ThreadLocal<String> threadLocal = ThreadLocal.withInitial(() -> "你好");
        String hello = threadLocal.get();
        System.out.println(hello);

    }


    private static void printDate() {

    }


}
