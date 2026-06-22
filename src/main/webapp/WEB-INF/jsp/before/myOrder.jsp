<%--
  Created by IntelliJ IDEA.
  User: lwvc
  Date: 2026/5/12
  Time: 8:35
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
      <th>订单金额</th>
      <th>订单状态</th>
      <th>下单时间</th>
      <th>查看详细</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${orderList}" var="order">
      <tr>
        <td>${order.id}</td>
        <td>${order.amount}</td>
        <td>
          <c:if test="${order.status==0}">
            未支付
          </c:if>
          <c:if test="${order.status==1}">
            已支付
          </c:if>
        </td>
        <td>${order.orderdate}</td>
        <td><a href="beforeorder/orderDetail?orderId="#{order.id} </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>