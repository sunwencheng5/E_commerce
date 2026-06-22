<%--
  Created by IntelliJ IDEA.
  User: lwvc
  Date: 2026/4/28
  Time: 9:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>Title</title>
    <base href="<%=basePath%>">
    <link href="static/css/bootstrap.css" rel="stylesheet"/>
</head>
<body>
    <div class="container">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <h3 class="panel-title">用户登录</h3>
            </div>
            <div class="panel-body">
                <form class="form-horizontal" role="form" action="user/doLogin" id="myForm">
                    <div class="form-group">
                        <label for="email" class="col-sm-2 control-label">邮箱</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="email" placeholder="请输入您的邮箱" name="bemail" value="${bemail}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="pwd" class="col-sm-2 control-label">密码</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="pwd" placeholder="请输入您的密码" name="bpwd">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="yzm" class="col-sm-2 control-label">验证码</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="yzm" placeholder="请输入验证码" name="code">
                        </div>
                        <div class="col-sm-2">
                            <img src="validateCode" id="myImg"/>
                        </div>
                        <div class="col-sm-2">
                            <a href="javascript:changeYZM()">看不清，换一张</a>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="button" class="btn btn-default" onclick="checkForm()">登录</button>
                            <button type="reset" class="btn btn-default">重置</button>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <font color="red">${errorMessage}</font>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <script src="static/js/jquery-3.6.0.min.js"></script>
    <script src="static/js/bootstrap.js"></script>
    <script src="static/js/common.js"></script>
    <script>
        //检查表单
        function checkForm(){
            //获取三个文本框的内容
            var email=document.getElementById("email").value;
            var pwd=document.getElementById("pwd").value;
            var yzm=document.getElementById("yzm").value;
            //判断密码是否为空，为空则弹窗“密码不能为空”
            if(checkNull(email,"邮箱不能为空") &&
                checkNull(pwd,"密码不能为空") &&
                checkNull(yzm,"验证码不能为空")){
                //提交表单
                document.getElementById("myForm").submit();
            }
        }
        //换一张验证码
        function changeYZM(){
            //加参数的目的是为了让服务器认为是新的请求，防止使用缓存的图片
            document.getElementById("myImg").src="validateCode?t="+Math.random();
        }
    </script>
</body>
</html>
