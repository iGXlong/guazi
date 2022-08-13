package com.duyi.test;

import com.duyi.util.SendSms;

public class MyTest {
    public static void main(String[] args) {
        int code = SendSms.random();
        System.out.println("随机数字："+code);
        boolean flag = SendSms.send("18516955565",code);
        System.out.println(flag?"发送成功":"发送失败");
    }
}
