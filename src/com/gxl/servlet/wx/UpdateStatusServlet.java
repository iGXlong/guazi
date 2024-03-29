package com.gxl.servlet.wx;

import com.gxl.bean.Message;
import com.gxl.service.BaseExpressService;
import com.gxl.service.ExpressServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class UpdateStatusServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.    获取确认收件时发送的取件码
        String code = request.getParameter("code");
        //2.    通过service  修改快递的状态
        BaseExpressService service = new ExpressServiceImp();
        boolean f = service.updateStatusByCode(code);
        //3.    根据修改的结果 , 准备不同的消息 回复给ajax
        Message msg = null;
        if(f){
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
