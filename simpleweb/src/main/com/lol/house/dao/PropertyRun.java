package com.lol.house.dao;

import cn.hutool.db.Db;

import java.sql.SQLException;
import java.util.UUID;

public class PropertyRun {

    public int insertProperty(Property property) {

        String id = UUID.randomUUID().toString();
        try {
            int res = Db.use().execute("INSERT INTO property VALUES(?, ?, ?, ?, ?, ?)", id, property.getProperty_id(), property.getBlock_id(), property.getRoom_no(), property.getCheck_in_date(), property.getUnit_type(), property.getArea());
            return res;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }


    public int updateProperty(String new_landlord_id, String house_id) {
        try {
            int res = Db.use().execute("UPDATE person SET user_id=? WHERE house_id=?", new_landlord_id, house_id);
            return res;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public int deleteProperty(String name) {
        try {
            int res = Db.use().execute("DELETE FROM person WHERE name=?", name);
            return res;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }


}
