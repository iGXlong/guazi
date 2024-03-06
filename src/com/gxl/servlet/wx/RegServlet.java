package com.gxl.servlet.wx;

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

public class RegServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.    接收请求的参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User u = new User();
        u.setUsername(username);
        u.setPhoneNumber(username);
        u.setPassword(password);
        //2.    将接收到的手机号码 密码 调用service 进行注册
        BaseUserService service = new UserServiceImp();
        int r = service.insert(u);
        //3.    判断注册的结果, 并根据结果准备不同的消息对象
        Message msg = null;
        if(r==1){
            msg = new Message("ok");
        }else{
            msg = new Message("error");
        }
        String json = msg.toJSON();
        response.getWriter().write(json);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
