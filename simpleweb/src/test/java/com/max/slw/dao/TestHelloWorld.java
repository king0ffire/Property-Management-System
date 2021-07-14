package com.max.slw.dao;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestHelloWorld {
    @Test
    public void testRun() {
        System.out.println("hello world");
    }

    @Test
    public void testRun1() {
        // 整数两个基本类型
        int it1 = 10;
        long lg = 12345678901230L; //L说明是long型
        // 小数基本类型
        double db1 = 0.00001; //小数
        boolean bl = true; // false

        System.out.println("==============");
        System.out.println(it1);
        System.out.println(lg);
        System.out.println(db1);
        System.out.println("==============");

        String str = "DDD张胜多负少";
        Date dt = new Date();
        System.out.println(dt.toString());
    }

    @Test
    public void run3() {
        String str = "10.1";
        // 如何变成整数
//        int i = Integer.valueOf(str);
//
//        // 再变回数字
//        String ss = Integer.toString(i);
//        System.out.println(ss);

        //小数 转 字符串   --> 小数
        double db = Double.valueOf(str);
        Double.toString(db);
    }

    @Test
    public void run4() {
        String str = "zhangsan";
        if(str.equals("zhangsan")) {
            System.out.println("zhangsan");
        } else if(str.equals("lisi")) {
            System.out.println("lisi");
        } else {
            System.out.println("othes");
        }
    }

    @Test
    public void run5() {
        // 有一个数字序列  3 4 5 6 9 10 11 34
        List<Integer> list = new ArrayList<>(); // 线性表
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(9);
        list.add(10);
        list.add(11);
        list.add(34);

        System.out.println("==============");
        for(int index=0; index < list.size(); index++ ) {
            System.out.println(list.get(index));
        }
        System.out.println("==============");

        // 数字序列 调整 奇数在前 ，偶数在后
        List<Integer> list2 =  list; //new ArrayList<>(); // 线性表

        for(int index=0; index < list.size(); index++ ) {
            int item = list.get(index);
            if(item % 2 == 0 ) {
                list2.add(item);
            }
        }
        for(int index=0; index < list.size(); index++ ) {
            int item = list.get(index);
            if(item % 2 != 0 ) {
                list2.add(item);
            }
        }
        System.out.println("==============");
        for(int index=0; index < list2.size(); index++ ) {
            System.out.println(list2.get(index));
        }
        System.out.println("==============");
    }

    @Test
    public void run6() {
        List<Integer> list = new ArrayList<>(); // 线性表
        List<Integer> list2 = list; // new ArrayList<>(); // 线性表

        list.add(1);
        list.add(2);

        System.out.println(list.toString());
        System.out.println(list2.toString());
    }
}
