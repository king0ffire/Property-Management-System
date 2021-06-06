package com.max.slw.dao;

import cn.hutool.db.Entity;
import cn.hutool.db.PageResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestDemo {
    @Test
    public void testInsert() {
        DemoDao dao = new DemoDao();
        User user = new User();
        user.setName("张三5");
        int res = dao.insert(user);
        Assertions.assertEquals(1, res);
    }

    @Test
    public void testQueryPage() {
        DemoDao dao = new DemoDao();
        PageResult<Entity> pager = dao.queryPager();
        for(int index=0; index<pager.size(); index++) {
            String id = pager.get(index).getStr("id");
            String name = pager.get(index).getStr("name");
            System.out.print(id + "-->");
            System.out.println(name);

        }
    }

    @Test
    public void testQuery() {
        DemoDao dao = new DemoDao();
        List<Entity> list =  dao.query();
        for(Entity en : list) {
            System.out.println(en.getStr("id"));
            System.out.println(en.getStr("name"));
        }
    }

}
