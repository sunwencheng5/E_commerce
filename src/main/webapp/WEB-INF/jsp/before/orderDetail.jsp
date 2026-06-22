<%--
  Created by IntelliJ IDEA.
  User: lwvc
  Date: 2026/5/12
  Time: 9:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<jsp:include page="head.jsp"/>
<div class="container">
  <table class="table table-bordered">
    <caption>收藏列表</caption>
    <thead>
    <tr>
      <th>商品编号</th>
      <th>商品图片</th>
      <th>商品名称</th>
      <th>商品购买价</th>
      <th>购买数量</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${orderDetailList}" var="orderDetai">
      <tr>
        <td>${orderDetai.id}</td>
        <td><img src="static/images/${orderDetai.gpicture}"/></td>
        <td>${orderDetai.gname}</td>
        <td>${orderDetai.grprice}</td>
        <td>${orderDetai.shoppingnum}</td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>
