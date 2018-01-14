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

### 2.2.stream 常用api总结
    stream.filter(); //过滤符合条件的Stream
    stream.count(); //统计符合条件的个数（及早求值）
    stream.flatMap(); //Map<key,value1,value2>
    stream.


