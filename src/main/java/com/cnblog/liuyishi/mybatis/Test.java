package com.cnblog.liuyishi.mybatis;


import com.cnblog.liuyishi.mybatis.pojo.User;
import com.cnblog.liuyishi.mybatis.util.JDBCUtil;
import com.cnblog.liuyishi.mybatis.util.MybatisUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test {

    public static void main(String[] args) throws Exception {
        System.out.println("hello, mybatis-mini");
        Connection connection = JDBCUtil.getConnection();

        String sql = "select * from user where id = 1";
        // PreparedStatement preparedStatement = connection.prepareStatement(sql);
        // ResultSet resultSet = preparedStatement.executeQuery();
        // while(resultSet.next()){
        //     int id = resultSet.getInt(1);
        //     String name = resultSet.getString(2);
        //     User user = new User();
        //     user.setId(id);
        //     user.setName(name);
        //     System.out.println("user = " + user);
        // }
        // JDBCUtil.release(connection,preparedStatement, resultSet );
        MybatisUtil<User> mybatisUtil = new MybatisUtil<>();
        User user = mybatisUtil.getBean(connection, sql, User.class);
        System.out.println("user = " + user);

    }


}
