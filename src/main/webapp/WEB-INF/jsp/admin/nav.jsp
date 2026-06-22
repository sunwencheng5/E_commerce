<%--
  Created by IntelliJ IDEA.
  User: lwvc
  Date: 2026/4/14
  Time: 8:39
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
    <div class="container">
        <h1>管理主界面</h1>
        <nav class="navbar navbar-default" role="navigation">
            <div class="container-fluid">
                <div>
                    <ul class="nav navbar-nav">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                商品管理
                                <b class="caret"></b>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="goods/toAdd">新增商品</a></li>
                                <li><a href="goods/select?currentPage=1">查询商品</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                类型管理
                                <b class="caret"></b>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="goodsType/toAdd">新增类型</a></li>
                                <li><a href="goodsType/select?currentPage=1">查询类型</a></li>
                            </ul>
                        </li>
                        <li class="active"><a href="order/select?currentPage=1">查询订单</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                销量统计
                                <b class="caret"></b>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="order/selectByMonth">按月统计</a></li>
                                <li><a href="order/selectByType">按类型统计</a></li>
                            </ul>
                        </li>
                        <li class="active"><a href="admin/logout">安全退出</a></li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
    <script src="static/js/jquery-3.6.0.min.js"></script>
    <script src="static/js/bootstrap.js"></script>
</body>
</html>
