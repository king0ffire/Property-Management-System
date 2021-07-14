package com.dgong.test;

import cn.hutool.core.date.DateUtil;
import org.junit.jupiter.api.Test;

public class DateTest {
    @Test
    public  void DateDemo() {
        String date = "2020-07-05";

        java.sql.Date sqlDate = java.sql.Date.valueOf(date);
        System.out.println(sqlDate);

        java.util.Date utilDate = DateUtil.parseDate(date);
        System.out.println(utilDate);
    }
}
