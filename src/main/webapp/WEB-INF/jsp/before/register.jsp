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
                <h3 class="panel-title">用户注册</h3>
            </div>
            <div class="panel-body">
                <form class="form-horizontal" role="form" action="user/doRegister" id="myForm">
                    <div class="form-group">
                        <label for="email" class="col-sm-2 control-label">邮箱</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="email" placeholder="请输入您的邮箱" name="bemail"
                            onblur="checkEmail()">
                            <span class="emailTip"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="pwd" class="col-sm-2 control-label">密码</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="pwd" placeholder="请输入您的密码" name="bpwd">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="pwd2" class="col-sm-2 control-label">确认密码</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="pwd2" placeholder="请输入您的密码" name="code">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="button" class="btn btn-default" onclick="checkForm()">注册</button>
                            <button type="reset" class="btn btn-default">重置</button>
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
        var isEmailOK=true;//记录邮箱是否正确
        function checkEmail(){
            //获取邮箱文本框的值
            var email=document.getElementById("email").value;
            if(checkNull(email,"请输入邮箱")){
                $.ajax({
                    url: 'user/isUse',
                    type: 'POST',
                    data: JSON.stringify({ "bemail": email}),
                    contentType: 'application/json',     // 发送的数据类型
                    success: function(data) {
                        if(data=="no"){
                            $(".emailTip").html("<font color='red'>此邮箱已被使用</font>")
                            isEmailOK=false;
                        }else{
                            $(".emailTip").html("");//清空提示
                            isEmailOK=true;
                        }
                    }
                });
            }
        }
        //检查表单
        function checkForm(){
            var pwd=document.getElementById("pwd").value;
            var pwd2=document.getElementById("pwd2").value;
            //判断密码是否为空，为空则弹窗“密码不能为空”
            if(checkNull(pwd,"密码不能为空")){
                //判断密码是否一致
                if(pwd!=pwd2){
                    alert("确认密码和密码不一致")
                }else{
                    //密码一致则继续判断邮箱是否正确
                    if(isEmailOK){
                        //提交表单
                        document.getElementById("myForm").submit();
                    }
                }
            }
        }
    </script>
</body>
</html>
