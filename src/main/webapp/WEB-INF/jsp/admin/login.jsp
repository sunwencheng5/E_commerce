<%--
  Created by IntelliJ IDEA.
  User: lwvc
  Date: 2026/4/13
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<form class="form-horizontal" role="form" action="admin/login" method="post">
  <div class="form-group">
    <label for="firstname" class="col-sm-2 control-label">用户名</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="firstname" placeholder="用户名" name="aname">
    </div>
  </div>
  <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">密码</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="lastname" placeholder="密码" name="apwd">
    </div>
  </div>

  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">登录</button>
      <button type="reset" class="btn btn-default">重置</button>
    </div>
  </div>
</form>
</body>
</html>
