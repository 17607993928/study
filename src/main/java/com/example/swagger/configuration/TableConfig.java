package com.example.swagger.configuration;

import com.baomidou.mybatisplus.annotation.TableName;
import com.example.swagger.tool.weather.domain.WeatherPO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import java.io.*;
import java.lang.reflect.Field;
import java.sql.Connection;

/**
 * @类描述:自动建表
 * @创建人:xiejs
 * @创建时间:2020-7-9 10:46:27
 */
@Configuration
public class TableConfig {
    /**
     * 创建表DDL语句
     */
    private static final String CREATE_TABLE="CREATE TABLE ";


    @Bean
    public void createWeather() {
        StringBuilder sb = new StringBuilder(CREATE_TABLE);

        //获取表注解value
        Class<WeatherPO> weatherClass = WeatherPO.class;
        TableName tableAnnotation = weatherClass.getAnnotation(TableName.class);
        String tableName = tableAnnotation.value();
        sb.append(tableName + " ");

        Field[] fields = weatherClass.getDeclaredFields();
        for (Field field : fields) {

            //序列化字段不需要创建字段
            if ("serialVersionUID".equals(field.getName())) {
                continue;
            }

            String name = field.getName();

            Class<?> type = field.getType();

            String typeName = type.getSimpleName();

            //判断类型
            String var;
            switch (typeName) {
                case "Long":
                    var = "INT";
                    break;
                case "String":
                    var = "VARCHAR";
                    break;
                case "Date":
                    var = "DATETIME";
                    break;
                default:
                    var = "VARCHAR";
                    break;

            }
            sb.append(name +" "+ var+" , ");
        }

        String fileName = createSql(sb.toString(), tableName);
        executeDDL(fileName);
    }

    /**
     * 创建ddl语句脚本
     * @param sql
     * @param tableName
     */
    private String  createSql(String sql,String tableName){
        String property = System.getProperty("user.dir");
        File file = new File(property + "\\src\\main\\resources\\sql\\" + tableName + "DDL.sql");
        OutputStream out=null;
        try {
            out=new FileOutputStream(file);
            BufferedOutputStream bfOut=new BufferedOutputStream(out);
            byte[] bytes = sql.getBytes();
            bfOut.write(bytes,0,bytes.length);
            bfOut.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file.getName();
    }

    /**
     * 执行ddl语句脚本
     * @param fileName
     */
    private void executeDDL(String fileName){
        WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
        SqlSessionFactory sqlSessionFactory = (SqlSessionFactory )webApplicationContext.getBean("SqlSessionFactory");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Connection conn = sqlSession.getConnection();
        ScriptRunner runner = new ScriptRunner(conn);
        runner.setErrorLogWriter(null);
        runner.setLogWriter(null);
        try {
            runner.runScript(Resources.getResourceAsReader("sql/" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }














    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(CREATE_TABLE);

        //获取表注解value
        Class<WeatherPO> weatherClass = WeatherPO.class;
        TableName tableAnnotation = weatherClass.getAnnotation(TableName.class);
        String tableName = tableAnnotation.value();
        sb.append(tableName + " ");

        Field[] fields = weatherClass.getDeclaredFields();
        for (Field field : fields) {

            //序列化字段不需要创建字段
            if ("serialVersionUID".equals(field.getName())) {
                continue;
            }

            String name = field.getName();

            Class<?> type = field.getType();

            String typeName = type.getSimpleName();

            //判断类型
            String var;
            switch (typeName) {
                case "Long":
                    var = "INT";
                    break;
                case "String":
                    var = "VARCHAR";
                    break;
                case "Date":
                    var = "DATETIME";
                    break;
                default:
                    var = "VARCHAR";
                    break;

            }
            sb.append(name +" "+ var+" , ");
        }

        String property = System.getProperty("user.dir");
        File file = new File(property + "\\src\\main\\resources\\sql\\" + tableName + "DDL.sql");
        try {
            OutputStream out=new FileOutputStream(file);
            BufferedOutputStream bfOut=new BufferedOutputStream(out);
            byte[] bytes = sb.toString().getBytes();
            bfOut.write(bytes,0,bytes.length);
            bfOut.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(file.getName());
    }
}
