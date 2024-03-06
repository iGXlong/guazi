package com.gxl.servlet.wx;

import com.gxl.bean.Express;
import com.gxl.bean.Message;
import com.gxl.service.BaseExpressService;
import com.gxl.service.ExpressServiceImp;
import com.gxl.util.DateFormatUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FindExpressServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json;charset=utf-8");
        //1.    获取ajax发送来的取件码
        String code = request.getParameter("code");
        //2.    通过取件码 ,调用service , 查询快递信息
        BaseExpressService service = new ExpressServiceImp();
        Express e = service.findByCode(code);
        //3.    根据查询的结果, 给ajax回复不同的消息
        Message msg = null;
        if (e == null) {
            msg = new Message("error");
        } else {
            String time = DateFormatUtil.format(e.getInTime());
            e.setCode(time);
            msg = new Message("ok", e);
        }
        String json = msg.toJSON();
        response.getWriter().write(json);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
