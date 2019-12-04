package com.grq.util;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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

    private static Connection connection=null;
    private static ResultSet rs=null;
    private static PreparedStatement ps=null;

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


    /**
     *查询所有
     * 要求 ：实体类字段名与 数据库字段 一一对应
     *
     * @param c Class 对象
     * @param <T> 返回要返回的类型
     * @return T
     */
    public static <T> List<T> selectALL(Class<T> c){
        List<T> list=new ArrayList<>();
        try {
            connection= getConnection();
            String sql="select * from "+c.getSimpleName().toLowerCase();
            ps=connection.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                T t = c.getConstructor().newInstance();
                Field[] fields = c.getDeclaredFields();
                for(Field field :fields){
                    field.setAccessible(true);
                    field.set(t,rs.getObject(field.getName().toLowerCase(),field.getType()));
                }
                list.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            close(rs,ps,connection);
        }
        return list;
    }


    /**
     * 根据 自定义 sql 语句进行查询
     * 要求 ：实体类字段名与 数据库字段 一一对应
     *
     * @param sql SQL语句 必须是 prepareStatement 要用到的sql类型
     * @param objects 参数列表
     * @param returnClass  返回值类型的 Class 对象
     * @param <T> 返回值类型
     * @return List<T>
     */
    public static <T> List<T> select(String sql,Object[] objects,Class<T> returnClass){

        List<T> list=new ArrayList<>();
        try {
            connection= getConnection();
            ps=connection.prepareStatement(sql);
            for(int i=1;i<=objects.length;i++){
                ps.setObject(i, objects[i-1]);
            }
            rs=ps.executeQuery();
            while (rs.next()){
                T t = returnClass.getConstructor().newInstance();
                Field[] fields = returnClass.getDeclaredFields();
                for(Field field :fields){
                    field.setAccessible(true);
                    field.set(t,rs.getObject(field.getName().toLowerCase(),field.getType()));
                }
                list.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            close(rs,ps,connection);
        }
        return list;
    }

    /**
     * 插入数据 插到与实体类对应的表中
     * 要求 ：实体类字段名与 数据库字段 一一对应
     *
     *
     * @param t 要插入的数据
     * @param tClass 实体类 Class 对象
     * @param <T> 实体类型
     * @return int
     */
    public static <T> int insert(T t, Class<T> tClass){
        int result = 0;
        try {
            connection= getConnection();
            StringBuilder sql= new StringBuilder("insert into ");
            sql.append(tClass.getSimpleName().toLowerCase()).append(" (");

            Field[] fields = tClass.getDeclaredFields();
            for(int i=0;i<fields.length;i++){
                sql.append(fields[i].getName().toLowerCase()).append(',');
            }
            sql.deleteCharAt(sql.length()-1);
            sql.append(") values (");
            for(int i=0;i<fields.length;i++){
                sql.append('?').append(',');
            }
            sql.deleteCharAt(sql.length()-1);
            sql.append(')');

            ps=connection.prepareStatement(sql.toString());
            for(int i=1;i<=fields.length;i++){
                fields[i-1].setAccessible(true);
                ps.setObject(i,fields[i-1].get(t));
            }
            result = ps.executeUpdate();

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            close(ps,connection);
        }
        return result;
    }


    /**
     * 插入数据 插到 tableName 表中
     * 要求 ：实体类字段名与 数据库字段 一一对应
     *
     *
     * @param tableName 表名
     * @param t 实体类
     * @param tClass 实体类的 Class 对象
     * @param <T> 实体类型
     * @return int
     */
    public static <T> int insert(String tableName ,T t, Class<T> tClass){
        int result = 0;
        try {
            connection= getConnection();
            StringBuilder sql= new StringBuilder("insert into ");
            sql.append(tableName.toLowerCase()).append(" (");

            Field[] fields = tClass.getDeclaredFields();
            for(int i=0;i<fields.length;i++){
                if(fields[i].getName().toLowerCase().equals("describe")){
                    sql.append('`').append(fields[i].getName().toLowerCase()).append('`').append(',');
                }else{
                    sql.append(fields[i].getName().toLowerCase()).append(',');
                }
            }
            sql.deleteCharAt(sql.length()-1);
            sql.append(") values (");
            for(int i=0;i<fields.length;i++){
                sql.append('?').append(',');
            }
            sql.deleteCharAt(sql.length()-1);
            sql.append(')');

            ps=connection.prepareStatement(sql.toString());
            for(int i=1;i<=fields.length;i++){
                fields[i-1].setAccessible(true);
                ps.setObject(i,fields[i-1].get(t));
            }
            result = ps.executeUpdate();

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            close(ps,connection);
        }
        return result;
    }


    /**
     * 插入数据 拥堵自定义 sql
     * @param sql sql语句
     * @param objects 参数列表
     * @return int
     */
    public static int insert(String sql,Object[] objects){
        int result = 0;
        try {
            connection= getConnection();
            ps=connection.prepareStatement(sql.toString());
            for(int i=0;i<objects.length;i++){
                ps.setObject(i+1,objects[i]);
            }
            result = ps.executeUpdate();

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            close(ps,connection);
        }
        return result;
    }

    /**
     * 更新数据
     * @param sql SQL语句
     * @param objects 参数列表
     * @return int
     */
    public static int update(String sql,Object[] objects){
        int result = 0;
        try {
            connection= getConnection();
            ps=connection.prepareStatement(sql.toString());
            for(int i=0;i<objects.length;i++){
                ps.setObject(i+1,objects[i]);
            }
            result = ps.executeUpdate();

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            close(ps,connection);
        }
        return result;
    }

    /**
     * 删除数据
     * @param sql SQL语句
     * @param objects 参数列表
     * @return int
     */
    public static int delete(String sql,Object[] objects){
        int result = 0;
        try {
            connection= getConnection();
            ps=connection.prepareStatement(sql.toString());
            for(int i=0;i<objects.length;i++){
                ps.setObject(i+1,objects[i]);
            }
            result = ps.executeUpdate();

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            close(ps,connection);
        }
        return result;
    }



}
