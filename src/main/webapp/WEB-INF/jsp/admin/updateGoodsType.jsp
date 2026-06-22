<%--
  Created by IntelliJ IDEA.
  User: lwvc
  Date: 2026/4/17
  Time: 9:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>Title</title>
    <base href="<%=basePath%>">
</head>
<body>
    <div class="container">
        <jsp:include page="nav.jsp"/>
        <form role="form" action="goodsType/doUpdate" method="post">
            <h1>修改商品类型</h1>
            <div class="form-group">
                <label for="id">类型ID</label>
                <input type="text" class="form-control" id="id"   value="${goodsType.id}" disabled>
                <input type="hidden" name="id" value="${goodsType.id}"/>
            </div>
            <div class="form-group">
                <label for="name">类型名称</label>
                <input type="text" class="form-control" id="name" placeholder="请输入类型名称" name="typename" value="${goodsType.typename}">
            </div>

            <button type="submit" class="btn btn-default">修改</button>
            <button type="reset" class="btn btn-default">重置</button>
        </form>
    </div>
</body>
</html>
