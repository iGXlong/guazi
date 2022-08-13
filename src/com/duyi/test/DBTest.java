package com.duyi.test;

import com.duyi.bean.Express;
import com.duyi.dao.BaseExpressDao;
import com.duyi.dao.ExpressDaoImp;

import java.util.List;

public class DBTest {
    public static void main(String[] args) {
        BaseExpressDao dao = new ExpressDaoImp();
        Object o = dao.statusSize(1);
        System.out.println(o);

    }
}
