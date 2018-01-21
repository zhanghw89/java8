# java8 学习计划

## 1.lambda表达式学习

### 表达式语法：

    //无参数表达式
    Runnable noArguments =()-> System.out.println("helloWord!");
    //一个参数
    ActionListener oneArguments = event -> System.out.println("helloWord!");
    //多语句表达式
    Runable multStatements = () -> {
        System.out.println("helloWord!");
        System.out.println("helloWord!");
    }
    //
    BinaryOperator<Long> add = (x,y)->x+y;
    BinaryOperator<Long> add = (Long x, Long y)->x+y;


### 引用值而不是变量（关于final）

- java中关于闭包的解释，
- java8中对final的扩展，既成事实的final变量

### 函数式接口
函数式接口：只有一个方法的接口。使用lambda时不关注方法名，只要方法的签名签名和lambda匹配即可

重要的函数式接口：

| 接口           | 参数  | 返回值类型  |
| ------------- |:-----:|:---------:|
| Predicate<T>  | T  | T |
| Consumer<T>   | T  | T |
| Function<T,R> | T  | R |
| Suppliter<T> | T  | T |



</Table>


## 2.stream 学习计划
java8 stream 学习计划（18年1月13号） 理论学习；
练习总结；学习

### 2.1.stream 具有的功能有哪些？

#### 2.1.1 及早求值法


#### 2.1.2 惰性求值法
stream 惰性求值法：不会立即执行。而是在调用方法的时候才执行

##### 2.1.3 如何判断是惰性求值还是及早求值？
如果接口返回的结果是stream则是惰性求值；如果返回的结果是null或者对象则是及早求值。

### 2.2.stream 常用api总结 ()
stream的api可以分为两种，一种是Intermediate操作（接口返回stream对象），一种Terminal接口（返回非stream对象）。惰性接口每一次都会对原有stream进行操作，调用接口时，接口本身并没有真正执行。
Stream的Intermediate操作又称惰性化的（lazy），调用这些方法的时候并没有真正的执行。

    Map操作：
    stream.map() //执行一种映射操作 T->R (将T转换成R的操作)
    stream.mapToInt() //
    stream.flatMap ////Map<key,value1,value2>
    stream.filter(); //过滤符合条件的Stream
    stream.distinct();//对流按条件进行去重
    stream.sorted（）//对流中的操作进行排序
    stream.peek() //
    limit();
    skip();//
    parallel();



Stream的及早求值接口又称Terminal操作：

    stream.count(); //统计符合条件的个数（及早求值）
    stream.forEach(); //对stream中的内容进行循环
    stream.forEachOrdered(); //
    stream.toArray(); //将stream中的内容转换成数组
    stream.reduce(); //对stream内容进行合并
    stream.collect(); //转化为集合工具对象
    stream.min();//获取最小值
    stream.max();//获取最大值
    stream.count();//统计总量
    stream.anyMatch();//
    stream.allMatch();
    stream.noneMatch();
    stream.findFirst();
    stream.findAny();

Stream的静态方法

    Stream.of()
    Stream.generate();
    Stream.concat();//
    Stream.empty();



### 2.3.经常和stream 一起使用的接口汇总 ()


### 2.4.创建方法分析
Stream的实现类：
Stream.of(T t) 的内部实现是：

    public static<T> Stream<T> of(T t) {
        return StreamSupport.stream(new Streams.StreamBuilderImpl<>(t), false);
    }

内部又调用了 StreamSupport

    public static <T> Stream<T> stream(T[] array, int startInclusive, int endExclusive) {
        return StreamSupport.stream(spliterator(array, startInclusive, endExclusive), false);
    }


### 2.4.





