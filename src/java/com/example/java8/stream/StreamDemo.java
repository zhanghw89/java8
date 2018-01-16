package com.example.java8.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

/**
 * @author 张会文 (Email: zhanghuiwen@icourt.cc)
 * @date 2018/1/13 下午1:11
 */
public class StreamDemo {
    public static void main(String[] args) {

        User user = new User();
        user.setCity("BeiJing");
        List<User> users = asList(user, user);
        System.out.println(countByFor(users));
        System.out.println(countByJava8(users));

        doMap();
        doFlatMap();
        doFindMax();
        doReduce();

        List<String> list = new ArrayList<>();
        list.add("zhangsan");
        list.add("zhangsan");
        list.remove("zhangsan");

        System.out.println(list);
        System.out.println("over'");

    }

    /**
     * collect 操作将list转换成为map（一种映射关系）
     *
     * @return
     */
    private static List buildList() {
        List<String> collect = Stream.of("zhagnsan", "lisi", "wangmazi").collect(Collectors.toList());
        System.out.println(collect);
        return collect;
    }


    //map操作 （讲师）
    private static List doMap() {
        System.out.print("stream map:");
        Stream<String> stream = Stream.of("zhagnsan", "lisi", "wangmazi").map(str -> str.toUpperCase());
        List<String> collect = stream.collect(Collectors.toList());
        System.out.println(collect);
        return collect;
    }

    //map操作
    private static List doFlatMap() {
        System.out.print("stream flatMap:");

        //返回值是stream
        Stream<String> stream = Stream.of(asList("zhagnsan", "lisi", "wangmazi"), asList("wangwu", "zhaoliu", "dongfanghong")).flatMap(users -> users.stream());
        stream = stream.filter(name -> name.length() > 5);
        List<String> collect = stream.collect(Collectors.toList());
        System.out.println(collect);
        return collect;
    }

    //filter操作
    private static List doFlilter() {
        System.out.print("stream filter:");
        Stream<String> stream = Stream.of("zhagnsan", "lisi", "wangmazi").filter(name -> name.length() > 5);
        List<String> collect = stream.collect(Collectors.toList());
        System.out.println(collect);
        return collect;
    }


    private static String doFindMax() {
        System.out.print("stream doFindMax:");
        Stream<String> stream = Stream.of("zhagnsan", "lisi", "wangmazi").filter(name -> name.length() > 5);
        Optional<String> max = stream.max(Comparator.comparing(name -> name.length()));
        System.out.println(max.get());
        return max.get();
    }

    private static Integer doReduce() {
        System.out.print("stream doReduce:");
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4);
        Integer reduce = integerStream.reduce(0, (lastSum, nextNum) -> lastSum + nextNum);

        System.out.println(reduce);
        return reduce;
    }


    private static long countByFor(List<User> users) {
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
