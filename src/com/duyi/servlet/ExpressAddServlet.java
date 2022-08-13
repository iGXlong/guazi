package com.duyi.servlet;

import com.duyi.bean.Express;
import com.duyi.service.BaseExpressService;
import com.duyi.service.ExpressServiceImp;
import com.duyi.util.SendSms;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ExpressAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.    设置请求体的编码格式 UTF-8
        request.setCharacterEncoding("UTF-8");
        //2.    从请求中获取四个快递的关键性参数
        String number = request.getParameter("number");
        String company = request.getParameter("company");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        //3.    调用service.  完成数据的存储
        Express e = new Express(number,name,phone,company,"-1");
        BaseExpressService service = new ExpressServiceImp();
        String code = service.insert(e);
        //4.    判断返回的数据是否为null
        String json = null;
        if(code==null){
            //插入失败, 快递单号重复
            //1.    准备JSON数据 返回给ajax    {"result":"error"}
            json = "{\"result\":\"error\"}";
        }else{
            //插入成功
            //1.    发送短信
            SendSms.send(phone,code);
            //2.    准备JSON数据 返回给ajax    {"result":"ok"}
            json = "{\"result\":\"ok\"}";//ISO-8859-1
        }
        //5.   给浏览器回复JSON数据
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
