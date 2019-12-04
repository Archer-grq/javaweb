package test;

import com.grq.bean.User;
import com.grq.util.JdbcUtil;

public class Main {
    public static void main(String[] args) throws Exception {

        User u=new User();
        u.setId(1545);
        u.setUsername("TBosfom");
        u.setPassword("123456");
        int insert = JdbcUtil.update("update user set username=? where id=?",new Object[]{"hello",1515});
        System.out.println(insert);
    }



}
