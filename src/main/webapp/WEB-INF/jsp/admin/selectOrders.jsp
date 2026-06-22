<%--
  Created by IntelliJ IDEA.
  User: lwvc
  Date: 2026/4/13
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div class="container">
        <jsp:include page="nav.jsp"/>
        <table class="table table-bordered table-hover">
            <caption>订单列表</caption>
            <thead>
            <tr>
                <th>ID</th>
                <th>用户邮箱</th>
                <th>订单金额</th>
                <th>订单状态</th>
                <th>下单日期</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach items="${currentOrders}" var="item">
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.user.bemail}</td>
                        <td>${item.amount}</td>
                        <td>
                            <c:if test="${item.status==1}">
                                已支付
                            </c:if>
                            <c:if test="${item.status==0}">
                                未支付
                            </c:if>
                        </td>
                        <td>${item.orderdate}</td>
                    </tr>
                </c:forEach>
                <tr>
                    <td colspan="6" align="right">
                        <ul class="pagination">
                            <li><a><span>第${currentPage}页</span></a></li>
                            <li><a><span>共${totalCount}页</span></a></li>
                            <c:if test="${currentPage!=1}">
                                <li><a href="order/select?currentPage=${currentPage-1}"><span>上一页</span></a></li>
                            </c:if>
                            <c:if test="${currentPage!=totalCount}">
                                <li><a href="order/select?currentPage=${currentPage+1}"><span>下一页</span></a></li>
                            </c:if>
                        </ul>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
</body>
</html>
