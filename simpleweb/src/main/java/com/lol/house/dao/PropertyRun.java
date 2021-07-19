package com.lol.house.dao;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import cn.hutool.db.Page;
import cn.hutool.db.PageResult;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class PropertyRun {

    public List<Entity> query(String house_id) {
        try {
            List<Entity> list = Db.use().query("select * from house where house_id LIKE ?", "%" + house_id + "%");
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public PageResult<Entity> queryPager() {
        try {
            PageResult<Entity> result = Db.use().page(Entity.create("house"), new Page(1, 5));
            return result;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public int insertProperty(Property property) {

        String id = UUID.randomUUID().toString();
        try {
            int res = Db.use().execute("INSERT INTO house VALUES(?, ?, ?, ?, ?, ?, ?)", id, property.getBlock_id(), property.getRoom_no(), property.getCheck_in_date(), property.getUnit_type(), property.getArea(), property.getLandlord_id());
            return res;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }


    public int updateProperty(String new_landlord_id, String property_id) {
        try {
            int res = Db.use().execute("UPDATE house SET owner_id=? WHERE house_id=?", new_landlord_id, property_id);
            return res;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public int deleteProperty(String property_id) {
        try {
            int res = Db.use().execute("DELETE FROM house WHERE houseproperty_id=?", property_id);
            return res;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }


}
