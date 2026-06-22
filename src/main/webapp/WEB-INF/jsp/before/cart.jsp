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
      <table class="table table-bordered">
          <caption>购物车列表</caption>
          <thead>
          <tr>
              <th>商品信息</th>
              <th>单价(元)</th>
              <th>数量</th>
              <th>小计</th>
              <th>操作</th>
          </tr>
          </thead>
          <tbody>
          <c:forEach items="${cartList}" var="cart">
              <tr>
                  <td><img src="static/images/${cart.gpicture}"></td>
                  <td>${cart.grprice}</td>
                  <td>${cart.shoppingnum}</td>
                  <td>${cart.smallsum}</td>
                  <td>><a href="cart/delete?id=${cart.cid}" onclick="return confirm('您确定要删除吗')">删除</a></td>
              </tr>
          </c:forEach>
          <tr>
              <td colspan="6" align="center">购物车所有金额(不含运费)￥${total}元</td>
          </tr>
          <tr>
              <td colspan="6" align="center">
                  <a href="cart/clear" onclick="return confirm('您确定要清空吗')">清空购物车</a>
              </td>
          </tr>
          <tr>
              <td colspan="6" align="center">
                 <a href="cart/selectCart?flag=count">去结算</a>
              </td>
          </tr>
          </tbody>
      </table>
  </div>
</body>
</html>
