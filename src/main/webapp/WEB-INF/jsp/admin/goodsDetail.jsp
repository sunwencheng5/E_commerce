<%--
  Created by IntelliJ IDEA.
  User: lwvc
  Date: 2026/4/17
  Time: 9:40
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
        <table class="table table-bordered">
            <caption>商品详情信息</caption>
            <tbody>
            <tr>
                <td>ID</td>
                <td>${goods.id}</td>
            </tr>
            <tr>
                <td>商品名称</td>
                <td>${goods.gname}</td>
            </tr>
            <tr>
                <td>商品原价</td>
                <td>${goods.goprice}</td>
            </tr>
            <tr>
                <td>商品折扣价</td>
                <td>${goods.grprice}</td>
            </tr>
            <tr>
                <td>商品库存</td>
                <td>${goods.gstore}</td>
            </tr>
            <tr>
                <td>商品图片</td>
                <td><img src="static/images/${goods.gpicture}"/></td>
            </tr>
            <tr>
                <td>商品类型</td>
                <td>${goods.type.typename}</td>
            </tr>
            <tr>
                <td>是否广告</td>
                <td>
                    <c:if test="${goods.isshow==1}">是</c:if>
                    <c:if test="${goods.isshow==0}">否</c:if>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</body>
</html>
