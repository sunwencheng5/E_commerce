<%--
  Created by IntelliJ IDEA.
  User: lwvc
  Date: 2026/4/27
  Time: 11:19
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
      <div class="panel panel-default">
          <div class="panel-heading">
              <h3 class="panel-title">订单提交成功</h3>
          </div>
          <div class="panel-body">
              <p>您的订单编号是#{order.id}</p>
              <p><a href="beforeorder/pay?id=${order.id}">去支付</a></p>
          </div>
      </div>
  </div>
</body>
</html>
