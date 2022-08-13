package com.duyi.servlet;

import com.duyi.bean.Message;
import com.duyi.bean.User;
import com.duyi.service.BaseUserService;
import com.duyi.service.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //1.    接受传递的参数
        String id = request.getParameter("id");
        int idValue = Integer.parseInt(id);
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        User u = new User(name,password,phone);
        //2.    调用service。 完成修改
        BaseUserService service = new UserServiceImp();



        int f = service.updateUserById(idValue, u);
        //3.    根据修改的结果， 准备不同的回复消息
        Message msg = null;
        if(f == 1){
            //修改成功
            msg = new Message("ok");
        }else{
            msg = new Message("error");
        }
        String json = msg.toJSON();
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
