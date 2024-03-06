package com.gxl.servlet;

import com.gxl.service.BaseExpressService;
import com.gxl.service.ExpressServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ExpressDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.setContentType("text/html;charset=utf-8");


        //1.    接收要删除的快递id
        String id = request.getParameter("id");
        //2.    将id传递给service,  完成删除
        int idValue = Integer.parseInt(id);
        BaseExpressService service = new ExpressServiceImp();
        boolean success = service.deleteById(idValue);
        //3.    根据service返回的删除结果(boolean) , 向浏览器回复JSON的数据
        String json = null;
        if(success){
            //删除成功: {"result":"ok"}
            json = "{\"result\":\"ok\"}";
        }else{
            //删除失败: {"result":"error"}
            json = "{\"result\":\"error\"}";
        }
        response.getWriter().append(json);
    }
}
