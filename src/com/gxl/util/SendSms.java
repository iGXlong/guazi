package com.gxl.util;

import java.util.HashMap;
import java.util.Random;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.google.gson.Gson;

public class SendSms {

    /**
     * 用于随机生成100000 - 999999 范围的随机数字
     *
     * @return
     */
    public static int random() {
        Random r = new Random();
        // 1000-9999
        int num = r.nextInt(9000) + 1000;

        return num;
    }

    /**
     * 向指定手机号码发送短信
     *
     * @param phoneNumber 手机号码
     * @param code        验证码内容
     * @return true表示发送成功 false表示发送失败
     */
    public static boolean send(String phoneNumber, long code) {
        return send(phoneNumber, code + "");
    }

    /**
     * 向指定手机号码发送短信
     *
     * @param phoneNumber 手机号码
     * @param code        验证码内容
     * @return true表示发送成功 false表示发送失败
     */
    public static boolean send(String phoneNumber, String code) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI5tKaV4RdMjXJYrDsacsk", "o7z2ZHhkAFoCY9U5oVl6mRR2801S4v");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phoneNumber);
        request.putQueryParameter("SignName", "longnote");
        request.putQueryParameter("TemplateCode", "SMS_465311351");
        request.putQueryParameter("TemplateParam", "{\"code\":" + code + "}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
            String json = response.getData();
            Gson g = new Gson();
            HashMap result = g.fromJson(json, HashMap.class);
            if ("OK".equals(result.get("Message"))) {
                return true;
            }
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return false;
    }

}