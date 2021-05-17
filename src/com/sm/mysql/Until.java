package com.sm.mysql;


import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.sql.*;

import com.sm.common.KeyNotFound;



public class Until {
    private static Properties properties;

    static {
        properties = new Properties();
        try {
            properties.load(Until.class.getClassLoader().getResourceAsStream("db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }


    //获取连接
    public static Connection getConn() {
        Connection connection = null;

        try {
            //1.注册驱动，把Driver加载起来
            Class.forName(getValue("DriverClassName"));
            //2.父类引用指向子类对象 mysql -u root -p jdbc是大协议 mysql是子协议
            connection = DriverManager.getConnection(getValue("url"), getValue("user"), getValue("password"));
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    //读取配置文件
    public static String getValue(String key) {
        if (properties.containsKey(key)) {
            return properties.getProperty(key);
        } else {
            throw new KeyNotFound("没有找到" + key);
        }
    }
    //更改
    public static int update( String sql,Object...para) throws SQLException {
        Connection conn = getConn();
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        for(int i=0;i<para.length;i++){
            if(para!=null&&para.length>0){
                preparedStatement.setObject(i+1,para[i]);
            }
        }
        int i = preparedStatement.executeUpdate();
        preparedStatement.close();
        conn.close();
        return i;
    }


    //查询所有
    public static <T> List<T> query(String sql,Class<T> tClass, Object... para) throws SQLException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        List<T> list=new ArrayList<>();
        Connection conn = getConn();
        //运行sql语句
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        Constructor<?> declaredConstructor = tClass.getDeclaredConstructor(ResultSet.class);
        declaredConstructor.setAccessible(true);
        //给占位符赋值
        for (int i = 0; i < para.length; i++) {
            if (para != null && para.length > 0) {
                preparedStatement.setObject(i + 1, para[i]);
            }
        }
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
             list.add((T)declaredConstructor.newInstance(resultSet));
        }
        close(preparedStatement, conn,resultSet );
        return list;

    }
    //关闭连接
    public static void close(PreparedStatement preparedStatement, Connection connection, ResultSet resultSet) throws SQLException {
        if (preparedStatement != null) {
            preparedStatement.close();
        }
        if (connection != null) {
            connection.close();
        }
        if (resultSet != null) {
            resultSet.close();
        }

    }
}

