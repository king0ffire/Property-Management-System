package com.dgong.test;

import com.max.slw.dao.User;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class JdbcTest {
    @Test
    public void inserMyuser() {
        Connection connection = null;
        try {
            // 1. 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2.建立数据库连接
            String url = "jdbc:mysql://192.168.117.129:3306/myuse?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true&serverTimezone=GMT%2B8&allowPublicKeyRetrieval=true";
            connection = DriverManager.getConnection(url, "root", "123456");
            // 3.创建执行语句对象
            PreparedStatement pst = connection.prepareStatement("INSERT INTO myuser VALUES(?,?)");
            // 4.执行Inser语句
            pst.setString(1, UUID.randomUUID().toString()); // 填补sql中的？1的值
            pst.setString(2, "张三和王二麻子"); // 填补sql中的？2的值

            int res = pst.executeUpdate(); // 执行insert、 update、 delete统一用executeUpdate
            System.out.println("插入成功："  + res);
            // 5. 无
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // 6. 关闭连接
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Test
    public void queryData() {
        Connection connection = null;
        try {
            // 1. 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2.建立数据库连接
            String url = "jdbc:mysql://192.168.117.129:3306/myuse?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true&serverTimezone=GMT%2B8&allowPublicKeyRetrieval=true";
            connection = DriverManager.getConnection(url, "root", "123456");
            // 3.创建执行语句对象
            PreparedStatement pst = connection.prepareStatement("SELECT * FROM myuser WHERE name LIKE ?");
            // 4.执行Inser语句
            pst.setString(1, "%二%");
            ResultSet rs = pst.executeQuery(); //执行查询使用query

            // 5. 获得数据
            List<User> list = new ArrayList<>();
            while(rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);

                User user = new User();
                user.setId(id);
                user.setName(name);

                list.add(user);

            }
            System.out.println(list.toString());
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // 6. 关闭连接
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
