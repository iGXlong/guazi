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


public class ExpressUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.    设置请求体的编码
        request.setCharacterEncoding("UTF-8");
        //2.    获取请求中, 用于修改快递的五个关键性参数
        //  -   快递的id
        String id = request.getParameter("id");
        int idValue = Integer.parseInt(id);
        //  -   新的快递数据
        String number = request.getParameter("number");
        String company = request.getParameter("company");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        //  使用新的快递数据 组装一个快递对象
        Express e = new Express();
        e.setENumber(number);
        e.setCompany(company);
        e.setUsername(name);
        e.setUserphone(phone);
        //3.    调用Service 执行修改
        BaseExpressService service = new ExpressServiceImp();
        boolean flag = service.updateById(idValue,e);
        //4.    根据修改的结果, 准备不同的JSON数据
        Message msg = null;
        if(flag){
            //修改成功
            msg = new Message("ok");
        }else{
            //修改失败.
            msg = new Message("error");
        }
        String json = msg.toJSON();
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
