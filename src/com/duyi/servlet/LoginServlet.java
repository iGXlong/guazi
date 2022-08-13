package com.duyi.servlet;

import com.duyi.util.SessionUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        //1.    接收请求的参数
        //  -账号
        String username = req.getParameter("username");
        //  -密码
       String password = req.getParameter("password");
       //2.     验证账号密码是否为 admin & 123
        if("admin".equals(username) && "123".equals(password)){
            //3.    管理员登陆成功的情况。
            //  处理方式： 通过重定向， 想浏览器发送302的状态码， 以及主页地址
            resp.sendRedirect("index.jsp");
            //  将管理员登陆成功的标记 存储在session中
            SessionUtil.setManagerFlag(req.getSession());
        }else{
            //4.    登陆失败的情况
            //  处理方式:  通过resp响应对象， 获取打印流， 打印script响应体内容
            PrintWriter out = resp.getWriter();
            out.println("<script>alert('账号密码错误，登陆失败！');window.location.href='login.jsp';</script>");
        }
    }
}
