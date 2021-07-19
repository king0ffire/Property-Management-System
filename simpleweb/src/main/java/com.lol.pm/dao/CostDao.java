package com.max.slw.dao;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import cn.hutool.db.Page;
import cn.hutool.db.PageResult;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class CostDao {
    public List<Entity> query(String owner_id) {
        try {
            List<Entity> list = Db.use().query("select * from cost where owner_id LIKE ?", "%" + owner_id + "%");
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public PageResult<Entity> queryPager() {
        try {
            PageResult<Entity> result = Db.use().page(Entity.create("Cost"), new Page(1, 5));
            return result;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public int insert(Cost cost) {
        String id = UUID.randomUUID().toString();
        try {
            int res = Db.use().execute("INSERT INTO cost VALUES(?,?,?,?,?)", id, cost.getCost_reason(),cost.getCost_time(),cost.getOwner_id(),cost.getCost_total());
            return res;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public int delete(Cost cost) {
        try {
            int res = Db.use().execute("DELETE FROM cost WHERE cost_id=?", cost.getCost_id());
            return res;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public int update(Cost cost) {
        try {
            int res = Db.use().execute("UPDATE person SET cost_total=? WHERE cost_id=?", cost.getCost_total(),cost.getCost_id());
            return res;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
}
