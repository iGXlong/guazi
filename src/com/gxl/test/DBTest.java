package com.gxl.test;

import com.gxl.bean.User;
import com.gxl.dao.BaseExpressDao;
import com.gxl.dao.BaseUserDao;
import com.gxl.dao.ExpressDaoImp;
import com.gxl.dao.UserDaoImp;
import org.junit.Test;

import java.util.List;


public class DBTest {
    @Test
    public void testExpressDao(){
        BaseExpressDao dao = new ExpressDaoImp();
        Object o = dao.statusSize(1);
        System.out.println(o);
    }

    @Test
    public void testUserDao(){
        BaseUserDao dao = new UserDaoImp();
        List<User> list = dao.findAll();
        System.out.println(list);
    }
}
