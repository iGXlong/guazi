package com.gxl.servlet;

import com.gxl.bean.Message;
import com.gxl.bean.User;
import com.gxl.service.BaseUserService;
import com.gxl.service.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserSelectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json;charset=utf-8");
        //1.    接受ajax发送的手机号码
        String phone = request.getParameter("phone");
        String flag = request.getParameter("flag");
        int flagValue = Integer.parseInt(flag);

        //2.    调用service 查询用户
        BaseUserService service = new UserServiceImp();
        User u = service.findUserByPhoneNumber(phone, flagValue);
        //3.    根据查询的结果， 准备不同的消息 ，发送给ajax
        Message msg = null;
        if(u != null){
            //查询到了用户
            msg = new Message("ok",u);
        }else{
            //查询失败
            msg = new Message("error");
        }
        String json = msg.toJSON();
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
