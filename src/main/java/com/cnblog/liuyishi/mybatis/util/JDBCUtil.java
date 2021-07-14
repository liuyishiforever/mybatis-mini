package com.cnblog.liuyishi.mybatis.util;


import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtil {

    private static Connection connection;

    public static Connection getConnection() throws Exception {
        if (connection == null) {
            // 1.获取类加载器用于加载 clsspath 下面的 配置文件
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            // 2.读取druid.properties配置文件
            InputStream inputStream = classLoader.getResourceAsStream("druid.properties");

            // 3.创建Properties对象，并读取配置文件对应的输入流
            Properties properties = new Properties();
            properties.load(inputStream);

            DataSource ds = DruidDataSourceFactory.createDataSource(properties);
            // 5.获取连接对象
            connection = ds.getConnection();

        }
        return connection;
    }

    public static void release(Connection connection, PreparedStatement statement, ResultSet resultSet) {
        try {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }


}
