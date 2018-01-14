package com.example.java8.stream;

import com.sun.tools.javac.util.Assert;
import lombok.Data;

/**
 * @author 张会文 (Email: zhanghuiwen@icourt.cc)
 * @date 2018/1/13 下午1:25
 */

@Data
public class User {

    private String city;

    public boolean isFrom(String city) {
        Assert.checkNonNull(city,"对象不能为空");
        return city.equals(this.city);
    }
}
