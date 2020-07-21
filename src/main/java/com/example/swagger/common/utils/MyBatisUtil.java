package com.example.swagger.common.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @类描述:mybatis工具
 * @创建人:xiejs
 * @创建时间:2020-7-21 10:47:13
 */
public class MyBatisUtil {
    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();

    /**
     * 获取sqlSession
     * @return
     * @throws IOException
     */
    public static SqlSession getSqlSession() {
        String filePath = "mybaits.xml";
        InputStream inputStream;
        try {
            inputStream = Resources.getResourceAsStream(filePath);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        threadLocal.set(sqlSession);
        return sqlSession;
    }

    /**
     * 获取Connection
     * @return
     */
    public static Connection getConnection() {
        SqlSession sqlSession = getSqlSession();
        Connection connection = sqlSession.getConnection();
        return connection;
    }

    /**
     * 获取statement
     * @return
     */
    public static Statement getStatement() {
        Connection connection = getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }


    //关闭SqlSession
    public static void closeSqlSession() {
        SqlSession sqlSession = threadLocal.get();
        if (sqlSession != null) {
            sqlSession.close();
            threadLocal.remove();
        }
    }


}
