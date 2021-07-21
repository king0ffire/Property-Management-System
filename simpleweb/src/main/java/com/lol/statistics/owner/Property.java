package com.lol.statistics.owner;

import cn.hutool.json.JSONUtil;
import com.lol.owner.dao.Owner;
import org.testng.annotations.Test;

import java.sql.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Property {

    @Test
    public Map<String, Object> total(String owner_id) {
        Connection connection = null;
        Map<String, Object> map = new HashMap<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://127.0.0.1:3306/propertymanagement?useUnicode=true&characterEncoding=UTF-8" +
                    "&allowMultiQueries=true&serverTimezone=GMT%2B8&allowPublicKeyRetrieval=true";
            connection = DriverManager.getConnection(url, "root", "123456");

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT owner_name,count(property_id) " +
                    "FROM owner A inner join house B on A.owner.id = B.owner_id GROUP BY property_id");

            System.out.println(preparedStatement.toString());

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                int totnum = rs.getInt(2);
                map.put(id, totnum);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return map;
    }

    @Test
    public void test() {
        Property tot = new Property();
        Owner owner = new Owner();
        //System.out.println(total().toString());
    }


    @Test
    public List<OH> ownerHouse() {
        Connection connection = null;
        List<OH> list = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://127.0.0.1:3306/propertymanagement?useUnicode=true&characterEncoding=UTF-8" +
                    "&allowMultiQueries=true&serverTimezone=GMT%2B8&allowPublicKeyRetrieval=true";
            connection = DriverManager.getConnection(url, "root", "123456");

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM owner A inner join house" +
                    " B on A.owner_id = B.owner_id");

            System.out.println(preparedStatement.toString());

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String gender = rs.getString(3);
                String hometown = rs.getString(4);
                String phone = rs.getString(5);
                String pid = rs.getString(6);
                int buildid = rs.getInt(7);
                int houseid = rs.getInt(8);
                Date time = rs.getDate(9);
                String type = rs.getString(10);
                int area = rs.getInt(11);
                String oid = rs.getString(12);
                OH oh = new OH(id, name, gender, hometown, phone, pid, buildid, houseid, time, type, area, oid);
                list.add(oh);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        System.out.println(JSONUtil.toJsonStr(list));
        return list;
    }

}


