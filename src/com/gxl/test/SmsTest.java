package com.gxl.test;

import com.gxl.util.SendSms;
import org.junit.Test;

public class SmsTest {

    @Test
    public void testSendSms() {
        int code = SendSms.random();
        System.out.println("随机数字：" + code);
        boolean flag = SendSms.send("13084208210", code);
        System.out.println(flag ? "发送成功" : "发送失败");
    }
}
