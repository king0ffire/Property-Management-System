package com.lol.build;

import org.testng.annotations.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Jdbc {
    @Test
    public int addBuild(Build build) {        //加载驱动 建立连接 创建执行语句对象 执行insert语句 释放资源关闭连接
        Connection connection = null;
        int i = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://127.0.0.1:3306/propertymanagement?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true&serverTimezone=GMT%2B8&allowPublicKeyRetrieval=true";
            connection = DriverManager.getConnection(url, "root", "123456");

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO build VALUES(?,?,?,?,?,?,?)");

            preparedStatement.setInt(1, build.getBuild_id());
            preparedStatement.setString(2, build.getBuild_name());
            preparedStatement.setInt(3, build.getBuild_floornum());
            preparedStatement.setInt(4, build.getBuild_housenum());
            preparedStatement.setDate(5, build.getBuild_time());
            preparedStatement.setInt(6, build.getBuild_accept());
            preparedStatement.setString(7, build.getBuild_layout());

            i = preparedStatement.executeUpdate();
            System.out.println("add success：" + i);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return i;
    }

    @Test
    public void test() {
        Date date=new Date(System.currentTimeMillis());
        Build build=new Build(0,null,-1,-1,null,100,null);
        deleteBuild(build);
    }

    @Test
    public int deleteBuild(Build build) {        //加载驱动 建立连接 创建执行语句对象 执行insert语句 释放资源关闭连接
        Connection connection = null;
        int i = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://127.0.0.1:3306/propertymanagement?useUnicode=true&characterEncoding=UTF-8" +
                    "&allowMultiQueries=true&serverTimezone=GMT%2B8&allowPublicKeyRetrieval=true";
            connection = DriverManager.getConnection(url, "root", "123456");



            //preparedStatement.setString(1, build.getBuild_id());
            //preparedStatement.setString(2, build.getBuild_name());
            //preparedStatement.setInt(3, build.getBuild_floornum());
            //preparedStatement.setInt(4,build.getBuild_housenum());
            //preparedStatement.setDate(5, build.getBuild_time());
            //preparedStatement.setInt(6,build.getBuild_accept());
            //preparedStatement.setString(7,build.getBuild_layout());
            PreparedStatement preparedStatement=null;
            //手动动态删除，每个if都有connection操作是因为where里面的“表属性”如果使用问好进行动态，会有单引号无法解决
            if (build.getBuild_name() != null) {
                preparedStatement = connection.prepareStatement("DELETE FROM build WHERE build_name LIKE ?");
                preparedStatement.setString(1, "%" + build.getBuild_name() + "%");
            } else if (build.getBuild_floornum() != -1) {
                preparedStatement = connection.prepareStatement("DELETE FROM build WHERE build_floornum LIKE ?");
                preparedStatement.setString(1, "%"+build.getBuild_floornum()+"%");
            } else if (build.getBuild_housenum() != -1) {
                preparedStatement = connection.prepareStatement("DELETE FROM build WHERE build_housenum LIKE ?");
                preparedStatement.setString(1, "%"+build.getBuild_housenum()+"%");
            } else if (build.getBuild_time() != null) {
                preparedStatement = connection.prepareStatement("DELETE FROM build WHERE build_time LIKE ?");
                preparedStatement.setString(1, "%"+build.getBuild_time()+"%");
            } else if (build.getBuild_accept() != -1) {
                preparedStatement = connection.prepareStatement("DELETE FROM build WHERE build_accept LIKE ?");
                preparedStatement.setString(1, "%"+build.getBuild_accept()+"%");
            } else if(build.getBuild_layout()!=null){
                preparedStatement = connection.prepareStatement("DELETE FROM build WHERE build_layout LIKE ?");
                preparedStatement.setString(1,"%"+build.getBuild_layout()+"%");
            }

            i = preparedStatement.executeUpdate();
            System.out.println("32132132");
            System.out.println("删除成功：" + i);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return i;
    }


    @Test
    public int updateBuild(Build build1,Build build2) {        //build1是目标数据过滤器，build2是目标数据将要改成什么，在检测到build1的过滤属性后将对应直接用build2的属性
        Connection connection = null;
        int i = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://127.0.0.1:3306/propertymanagement?useUnicode=true&characterEncoding=UTF-8" +
                    "&allowMultiQueries=true&serverTimezone=GMT%2B8&allowPublicKeyRetrieval=true";
            connection = DriverManager.getConnection(url, "root", "123456");

            PreparedStatement preparedStatement = null;
            //手动动态
            if (build1.getBuild_name() != null) {
                preparedStatement = connection.prepareStatement("UPDATE build SET build_name=? WHERE build_name LIKE ?");
                preparedStatement.setString(2, "%" + build1.getBuild_name() + "%");
                preparedStatement.setString(1, build2.getBuild_name());
            } else if (build1.getBuild_floornum() != -1) {
                preparedStatement = connection.prepareStatement("UPDATE build SET build_floornum=? WHERE build_floornum LIKE ?");
                preparedStatement.setString(2, "%"+build1.getBuild_floornum()+"%");
                preparedStatement.setInt(1, build2.getBuild_floornum());
            } else if (build1.getBuild_housenum() != -1) {
                preparedStatement = connection.prepareStatement("UPDATE build SET build_housenum=? WHERE build_housenum LIKE ?");
                preparedStatement.setString(2, "%"+build1.getBuild_housenum()+"%");
                preparedStatement.setInt(1, build2.getBuild_housenum());
            } else if (build1.getBuild_time() != null) {
                preparedStatement = connection.prepareStatement("UPDATE build SET build_time=? WHERE build_time LIKE ?");
                preparedStatement.setString(2, "%"+build1.getBuild_time()+"%");
                preparedStatement.setString(1, build2.getBuild_time().toString());
            } else if (build1.getBuild_accept() != -1) {
                preparedStatement = connection.prepareStatement("UPDATE build SET build_accept=? WHERE build_accept LIKE ?");
                preparedStatement.setString(2, "%"+build1.getBuild_accept()+"%");
                preparedStatement.setInt(1, build2.getBuild_accept());
            } else if(build1.getBuild_layout()!=null){
                preparedStatement = connection.prepareStatement("UPDATE build SET build_accept=? WHERE build_accept LIKE ?");
                preparedStatement.setString(2,"%"+build1.getBuild_layout()+"%");
                preparedStatement.setString(1,build2.getBuild_layout());
            }
            System.out.println(preparedStatement.toString());
            i = preparedStatement.executeUpdate();
            System.out.println("update success：" + i);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return i;
    }

    @Test
    public List<Build> queryBuild(Build build) {        //开闭查询
        Connection connection = null;
        List<Build> list =new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://127.0.0.1:3306/propertymanagement?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true&serverTimezone=GMT%2B8&allowPublicKeyRetrieval=true";
            connection = DriverManager.getConnection(url, "root", "123456");

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM build WHERE 1=1 AND build_name LIKE ?");



            if (build.getBuild_name() != null) {
                preparedStatement.setString(1, build.getBuild_name());
            } else if (build.getBuild_floornum() != -1) {
                preparedStatement.setInt(1, build.getBuild_floornum());
            } else if (build.getBuild_housenum() != -1) {
                preparedStatement.setInt(1, build.getBuild_housenum());
            } else if (build.getBuild_time() != null) {
                preparedStatement.setString(1, build.getBuild_time().toString());
            } else if (build.getBuild_accept() != -1) {
                preparedStatement.setInt(1, build.getBuild_accept());
            } else if(build.getBuild_layout()!=null){
                preparedStatement.setString(1,build.getBuild_layout());
            }
            /*preparedStatement.setInt(1, build.getBuild_id());
            preparedStatement.setString(2, build.getBuild_name());
            preparedStatement.setInt(3, build.getBuild_floornum());
            preparedStatement.setInt(4, build.getBuild_housenum());
            preparedStatement.setDate(5, build.getBuild_time());
            preparedStatement.setInt(6, build.getBuild_accept());
            preparedStatement.setString(7, build.getBuild_layout());*/
            System.out.println(preparedStatement.toString());

            ResultSet rs =preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int floornum = rs.getInt(3);
                int housenum=rs.getInt(4);
                Date date = rs.getDate(5);
                int accept=rs.getInt(6);
                String layout=rs.getString(7);
                Build tbuild=new Build(id,name,floornum,housenum,date,accept,layout);
                list.add(tbuild);
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
