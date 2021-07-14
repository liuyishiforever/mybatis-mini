package com.cnblog.liuyishi.mybatis.util;

import java.sql.Connection;

public class MybatisUtil<T> {

    public T getBean(Connection connection, String sql, Class clazz) {
        // 查询 sql
        // 解析结果集
        // 映射 javabean
        Object o = new Object();
        return (T) o;
    }

}
