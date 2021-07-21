package com.lol.statistics.house;

import cn.hutool.json.JSONUtil;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Housetotalfee {
    @Test
    public List<HOCP> houseTotalfee() {
        Connection connection = null;
        List<HOCP> list = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://127.0.0.1:3306/propertymanagement?useUnicode=true&characterEncoding=UTF-8" +
                    "&allowMultiQueries=true&serverTimezone=GMT%2B8&allowPublicKeyRetrieval=true";
            connection = DriverManager.getConnection(url, "root", "123456");

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM house A inner join owner" +
                    " B on A.owner_id = B.owner_id inner join cost C on B.owner_id = C.owner_id inner join pay D on C" +
                    ".cost_id =D.cost_id ");

            System.out.println(preparedStatement.toString());

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String property_id = rs.getString(1); //房产编号
                int block_id = rs.getInt(2); //楼号
                int room_no = rs.getInt(3); //房号
                Date check_in_date = rs.getDate(4);  //入住时间
                String unit_type = rs.getString(5);  //户型
                int area = rs.getInt(6);  //面积
                String landlord_id = rs.getString(7); //业主
                String owner_id = rs.getString(8);
                String owner_name = rs.getString(9);
                String owner_gender = rs.getString(10);
                String owner_hometown = rs.getString(11);
                String owner_phone = rs.getString(12);
                String cost_id = rs.getString(13);
                String cost_reason = rs.getString(14);
                Date cost_time = rs.getDate(15);
                //String owner_id=rs.getString(16);
                double cost_total = rs.getInt(17);
                String pay_id = rs.getString(18);
                //private String cost_id;
                double pay_money = rs.getInt(20);
                Date pay_time = rs.getDate(21);
                String pay_remark = rs.getString(22);
                HOCP HOCP = new HOCP(property_id, block_id, room_no, check_in_date, unit_type,
                        area, landlord_id, owner_id, owner_name, owner_gender, owner_hometown, owner_phone, cost_id,
                        cost_reason,
                        cost_time, cost_total, pay_id, pay_money, pay_time, pay_remark);
                list.add(HOCP);
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
