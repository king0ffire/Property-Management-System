package com.lol.statistics.community;

import org.testng.annotations.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Totalfee {
    @Test
    public List<Fee> totalFee(String date) {   //小区总费用的查询：日期和费用产生原因（物业费，电费，维修费，水费，停车费，燃气费）。date限制：2001，2001
        // -01，2001-01-01
        Connection connection = null;
        List<Fee> list = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://127.0.0.1:3306/propertymanagement?useUnicode=true&characterEncoding=UTF-8" +
                    "&allowMultiQueries=true&serverTimezone=GMT%2B8&allowPublicKeyRetrieval=true";
            connection = DriverManager.getConnection(url, "root", "123456");

            if (date == null) {
                preparedStatement = connection.prepareStatement("SELECT cost_reason,sum(cost_total) FROM cost GROUP " +
                        "BY cost_reason");
            } else {
                preparedStatement = connection.prepareStatement("SELECT cost_reason,sum(cost_total) FROM cost WHERE " +
                        "DATE_FORMAT(cost_time,'%Y-%m-%d') LIKE ? GROUP BY cost_reason");
                preparedStatement.setString(1, date + "%");
            }
            System.out.println("1" + preparedStatement.toString());

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String cost_reason=rs.getString(1);
                double cost_total=rs.getDouble(2);
                Fee fee=new Fee(cost_reason,cost_total);
                list.add(fee);
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
        return list;
    }

}
