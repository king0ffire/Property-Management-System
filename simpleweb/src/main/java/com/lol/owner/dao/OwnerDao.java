package com.lol.owner.dao;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import cn.hutool.db.Page;
import cn.hutool.db.PageResult;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class OwnerDao {
    public List<Entity> query(String owner_name) {
        try {
            List<Entity> list = Db.use().query("select * from owner where owner_name LIKE ?", "%" + owner_name + "%");
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public List<Entity> querybyid(String owner_id) {
        try {
            List<Entity> list = Db.use().query("select * from owner where owner_id=?", "%" + owner_id + "%");
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public PageResult<Entity> queryPager() {
        try {
            PageResult<Entity> result = Db.use().page(Entity.create("Owner"), new Page(1, 5));
            return result;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public int insert(Owner owner) {
        String id = UUID.randomUUID().toString();
        try {
            int res = Db.use().execute("INSERT INTO owner VALUES(?,?,?,?,?)", id, owner.getOwner_name(), owner.getOwner_gender(), owner.getOwner_hometown(), owner.getOwner_phone());
            return res;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public int delete(Owner owner) {
        try {
            int res = Db.use().execute("DELETE FROM owner WHERE owner_id=?", owner.getOwner_id());
            return res;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public int update(Owner owner) {
        try {
            int res = Db.use().execute("UPDATE owner SET owner_phone=? WHERE owner_id=?", owner.getOwner_phone(), owner.getOwner_id());
            return res;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
}
