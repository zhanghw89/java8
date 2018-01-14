package com.example.java8.stream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * @author 张会文 (Email: zhanghuiwen@icourt.cc)
 * @date 2018/1/13 下午1:11
 */
public class StreamDemo {
    public static void main(String[] args) {

        String str = null;
        Objects.requireNonNull(null, "不能为空");
        int length = str.length();


        User user = new User();
        user.setCity("BeiJing");
        List<User> users = new ArrayList<>();

        users.add(user);
        users.add(user);
        users.add(user);
        users.add(user);

        long count = countByFor(users);
        System.out.println(count);

        count = countByJava8(users);
        System.out.println(count);


    }


    public static long countByFor(List<User> users) {
        long count = 0;
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User next = iterator.next();
            if (next.isFrom("BeiJing")) {
                count++;
            }
        }

        return count;

    }


    /**
     * 使用流的优点：
     * 1.代码简洁
     *
     * @param users
     * @return
     */

    public static long countByJava8(List<User> users) {
        /*
        逻辑功能：
        1.找出所有符合条件的users
        2.统计总数

        如何判断是否是惰性请求？如果返回值是stream则是惰性请求，如果不是则是及早请求
         */

        //这段代码不会被立即执行；而是构建了一个stream，
        Stream<User> stream = users.stream().filter(user -> user.isFrom("BeiJing"));

        //和上面的区别是什么
//        Stream<User> stream = users.stream().filter(user -> user.isFrom("BeiJing")).count();

        //执行count操作的时候才会真正的执行stream中的内容
        return stream.count();

    }

    public static long countByJava81(List<User> users) {
        /*
        逻辑功能：
        1.找出所有符合条件的users
        2.统计总数
         */

        //这段代码不会被立即执行；而是构建了一个stream，
        Stream<User> stream = users.stream().filter(user -> {
            System.out.println(user.getCity());
            return user.isFrom("BeiJing");
        });


        //执行count操作的时候才会真正的执行stream中的内容
        return stream.count();

    }

    //collect操作






}
