package com.dgong.test;

import org.junit.jupiter.api.Test;

import java.util.Date;

public class PersonRun {

    @Test
    public void run() {
        // 无参构造函数 创建对象
        Person person = new Person();
        person.setName("张三");
        person.setAge(22);
        person.setBrithday(new Date());
        String info = person.disPlay();
        System.out.println(info);
        // 有参数构造函数 创建对象
        // 通过setXX修改值
        // 通过getXX获取值
    }
}
