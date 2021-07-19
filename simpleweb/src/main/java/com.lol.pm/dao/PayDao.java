package com.lol.pm.dao;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import cn.hutool.db.Page;
import cn.hutool.db.PageResult;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class PayDao {
    public List<Entity> query(String cost_id) {
        try {
            List<Entity> list = Db.use().query("select * from pay where owner_id LIKE ?", "%" + cost_id + "%");
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public PageResult<Entity> queryPager() {
        try {
            PageResult<Entity> result = Db.use().page(Entity.create("Pay"), new Page(1, 5));
            return result;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public int insert(Pay pay) {
        String id = UUID.randomUUID().toString();
        try {
            int res = Db.use().execute("INSERT INTO pay VALUES(?,?,?,?,?)", id, pay.getCost_id(), pay.getPay_money(), pay.getPay_time(), pay.getPay_remark());
            return res;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public int delete(Pay pay) {
        try {
            int res = Db.use().execute("DELETE FROM pay WHERE pay_id=?", pay.getPay_id());
            return res;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public int update(Pay pay) {
        try {
            int res = Db.use().execute("UPDATE pay SET pay_remark=? WHERE pay_id=?", pay.getPay_remark(),pay.getPay_id());
            return res;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }


}
