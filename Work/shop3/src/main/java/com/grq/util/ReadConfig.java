package com.grq.util;

import java.io.InputStream;
import java.util.Properties;

public class ReadConfig {
    public static String server_path=null;
    public static String server_upload_img_path=null;
    public static String img_path=null;
    public static String separator=null;
    public static String program_img_path=null;

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
            InputStream in = JdbcUtil.class.getResourceAsStream("/config.properties");
            //加载文件
            props.load(in);
            server_path=props.getProperty("server.path");
            server_upload_img_path=props.getProperty("server.upload.img.path");
            img_path=props.getProperty("img.path");
            separator=props.getProperty("separator");
            program_img_path=props.getProperty("program.img.path");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
