package com.example.swagger.configuration;

import com.example.swagger.common.utils.MyBatisUtil;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @类描述:根据ddl建表
 * @创建人:xiejs
 * @创建时间:2020-7-21 10:04:51
 */
@org.springframework.context.annotation.Configuration
public class BuildTableConfiguration {
    private final static Logger log = LoggerFactory.getLogger(BuildTableConfiguration.class);

    @EventListener({ApplicationReadyEvent.class})
    public void createTable() throws SQLException {
        log.info("----------------DDL脚本执行开始----------------");
        long start = System.currentTimeMillis();

        //获取jdbc的conn对象
        Connection connection = MyBatisUtil.getSqlSession().getConnection();
//        Statement statement = MyBatisUtil.getSqlSession().getConnection().createStatement();
        //获取脚本执行对象
        ScriptRunner runner = new ScriptRunner(connection);



        //获取路径(这种方法只能不打包获取路径，打成jar包之后获取不到)
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:sql");
        } catch (FileNotFoundException e) {
            log.error(e.getMessage());
        }





        Reader read = null;
        /*int len = 0;
        char [] sql=new char[1024];*/
        if (file != null) {
            if (file.isDirectory()) {
                String[] fileList = file.list();
                //遍历文件
                for (int i = 0; i < fileList.length; i++) {
                    File readFile = new File(file.getPath() + "\\" + fileList[i]);
                    if (!readFile.isDirectory()) {
                        try {
                            read = new BufferedReader(new FileReader(readFile));

                        /*while ((len=read.read(sql))!=-1){
                            String strSql=new String(sql,0,len);
                            System.out.println(strSql);
                            statement.executeUpdate(strSql);
                        }*/

                            //执行ddl语句脚本
                            runner.runScript(read);

                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            try {
                if (read != null) {
                    read.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        MyBatisUtil.closeSqlSession();

        long end = System.currentTimeMillis();
        log.info("DDL脚本花费时间：" + (end - start) + "毫秒");
        log.info("----------------DDL脚本执行结束----------------");
    }




}
