<%@ page import="com.gxl.dao.ExpressDaoImp" %>
<%@ page import="com.gxl.bean.Express" %>
<%@ page import="com.gxl.dao.BaseExpressDao" %>
<%@ page import="java.util.List" %>
<%@ page import="com.gxl.util.DateFormatUtil" %>
<%@ page import="com.gxl.service.BaseExpressService" %>
<%@ page import="com.gxl.service.ExpressServiceImp" %><%--
  Created by IntelliJ IDEA.
  User: LWJ
  Date: 2019/12/30
  Time: 22:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //1.    创建数据库快递表格的 数据操作对象
    BaseExpressService service = new ExpressServiceImp();
    //2.    调用数据操作对象的 findAll方法，  查询所有快递数据
    List<Express> all = service.findAll();
%>


<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" type="text/css" href="../../css/reset.css"/>
    <link rel="stylesheet" type="text/css" href="../../css/list.css"/>
    <script src="../../js/jquery.min.js"></script>
    <script src="../../js/layer/layer.js"></script>
</head>
<body>
<%
    if(all.size()==0){
        %>
    <h1 style="text-align:center">暂无快递数据</h1>
<%
        return;
    }

%>


<table class="tab tab-hover">
    <tr class="active">
        <th>编号</th><th>单号</th><th>快递公司</th><th>收货人</th><th>收货电话</th><th>状态</th><th>取件码</th><th>状态变更时间</th><th>操作</th>
    </tr>
    <%
        for (Express e:all) {
            %>
    <tr>
        <td><%=e.getId()%></td>
        <td><%=e.getENumber()%></td>
        <td><%=e.getCompany()%></td>
        <td><%=e.getUsername()%></td>
        <td><%=e.getUserphone()%></td>
        <td><%=e.getStatus()==0?"待取件":"已取件"%></td>
        <td><%=e.getCode()%></td>
        <%--如果未取件， 则显示到件时间 ，如果已取件， 则显示取件时间
            yyyy-MM-dd HH:mm:ss
        --%>
        <td><%=e.getStatus()==0?(DateFormatUtil.format(e.getInTime())):(DateFormatUtil.format(e.getOutTime()))%></td>
        <td><span class="btn-danger" onclick="deleteE(<%=e.getId()%>,this)">删除</span></td>
    </tr>
            <%
        }
    %>


    <script>
        function deleteE(eId,span){
            layer.load();
            $.get("../../express/delete.do","id="+eId,function(data){
                layer.closeAll();
                if(data.result == "ok"){//交互设计师
                    layer.msg("<span style='color:#fff'>删除成功</span>");
                    //alert("删除成功");
                    $(span).parent().parent().remove();
                }else{
                    layer.msg("<span style='color:#fff'>删除失败</span>");
                    //alert("删除成功");
                }
            },"JSON");
            //;
        }
    </script>

</table>
</body>
</html>
