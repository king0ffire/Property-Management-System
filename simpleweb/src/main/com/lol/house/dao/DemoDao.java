package com.lol.house.dao;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import cn.hutool.db.Page;
import cn.hutool.db.PageResult;

import java.sql.SQLException;
import java.util.List;

public class DemoDao {
    public List<Entity> query(String name) {
        try {
            List<Entity> list = Db.use().query("select * from house where name LIKE ?", "%" + name + "%");
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public PageResult<Entity> queryPager() {
        try {
            PageResult<Entity> result = Db.use().page(Entity.create("myuser"), new Page(1, 5));
            return result;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

}