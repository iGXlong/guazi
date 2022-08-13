<%--
  Created by IntelliJ IDEA.
  User: LWJ
  Date: 2020/1/3
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" type="text/css" href="../../css/reset.css"/>
    <link rel="stylesheet" type="text/css" href="../../css/add.css"/>
</head>
<body>
<div id="app">
    <div class="header">
        <span>添加快递员</span>
    </div>
    <div class="content">
        <table>
            <tr>
                <td class="text-right">姓名</td><td class="content_right"><input class="input" placeholder="请输入姓名"></td>
            </tr>
            <tr>
                <td class="text-right">手机号码</td><td class="content_right"><input class="input" placeholder="请输入手机号码"></td>
            </tr>
            <tr>
                <td class="text-right">密码</td><td class="content_right"><input class="input" placeholder="请输入密码"></td>
            </tr>
            <tr>
                <td></td><td class="content_right"><span class="btn btn-info" onclick="insert()">立即提交</span> <span class="btn">重置</span> </td>
            </tr>
        </table>


    </div>
</div>
<script src="../../js/jquery.min.js"></script>
<script src="../../js/layer/layer.js"></script>
<script>
    function insert(){
        layer.load();
        //1.    获取各个输入框中的内容
        var name = $("input:eq(0)").val();
        var phone = $("input:eq(1)").val();
        var upass = $("input:eq(2)").val();
        //2.    通过ajax 将输入框中的快递员信息 发送给服务器
        $.post("../../courier/add.do","name="+name+"&phone="+phone+"&upass="+upass+"&flag=1",function(data){
            layer.closeAll();
            if(data.result == "ok"){
                layer.msg("<span style='color:#fff'>插入成功</span>");
                $("input").val("");
            }else{
                layer.msg("<span style='color:#fff'>插入失败</span>");
            }
        },"JSON");
    }

</script>
</body>
</html>
