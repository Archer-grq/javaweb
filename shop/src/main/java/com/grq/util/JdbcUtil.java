package com.grq.util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * jdbc工具类
 *
 */
public class JdbcUtil {
    private static String url = null;
    private static String user = null;
    private static String password = null;
    private static String driverClass = null;

    /**
     * 静态代码块中（只加载一次）
     */
    static{
        try {
            //读取db.properties文件
            Properties props = new Properties();
            /**
             *  . 代表java命令运行的目录
             *  在java项目下，. java命令的运行目录从项目的根目录开始
             *  在web项目下，  . java命令的而运行目录从tomcat/bin目录开始
             *  所以不能使用点.
             */
            //FileInputStream in = new FileInputStream("./src/db.properties");

            /**
             * 使用类路径的读取方式
             *  / : 斜杠表示classpath的根目录
             *     在java项目下，classpath的根目录从bin目录开始
             *     在web项目下，classpath的根目录从WEB-INF/classes目录开始
             */
            InputStream in = JdbcUtil.class.getResourceAsStream("/db.properties");

            //加载文件
            props.load(in);
            //读取信息
            url = props.getProperty("jdbc.url");
            user = props.getProperty("jdbc.user");
            password = props.getProperty("jdbc.password");
            driverClass = props.getProperty("jdbc.class");
            //注册驱动程序
            Class.forName(driverClass);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("驱程程序注册出错");
        }
    }

    /**
     * 抽取获取连接对象的方法
     */
    public static Connection getConnection(){
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    public static void close(AutoCloseable... autoCloseables){
        for (AutoCloseable a:autoCloseables) {
            if(null!=a){
                try {
                    a.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
