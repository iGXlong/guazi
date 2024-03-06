package com.gxl.servlet;

import com.gxl.bean.Express;
import com.gxl.bean.Message;
import com.gxl.service.BaseExpressService;
import com.gxl.service.ExpressServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ExpressSelectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json;charset=utf-8");
        //1.    接收要查询的单号信息
        String number = request.getParameter("number");
        //2.    调用service , 查询
        BaseExpressService service = new ExpressServiceImp();
        Express e = service.findByENumber(number);
        //3.    根据查询的结果, 准备不同的JSON格式数据
        Message msg = null;
        if(e == null){
            //查询失败 {"result":"error"}
            msg = new Message("error");
        }else{
            //查询成功 {"result":"error","data":{}}
            msg = new Message("ok",e);
        }
       String json = msg.toJSON();
        //4.    将准备好的JSON格式数据 返回给浏览器
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
