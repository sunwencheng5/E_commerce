<%--
  Created by IntelliJ IDEA.
  User: lwvc
  Date: 2026/4/27
  Time: 10:51
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
    <style>
      #myCarousel{
        height: 200px;
      }
      #myCarousel .carousel-inner{
        height: 200px;
      }
      #myCarousel .carousel-inner img{
        width:100%;
      }
    </style>
</head>
<body>
  <div class="container">
    <nav class="navbar navbar-default" role="navigation">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand" href="#">欢迎光临eBusiness</a>
        </div>
        <div>
          <!--向左对齐-->
          <ul class="nav navbar-nav navbar-left">
            <li><a href="user/toRegister">注册</a></li>
            <li><a href="#">登录</a></li>
            <li><a href="#">后台</a></li>
          </ul>

          <!--向右对齐-->
          <ul class="nav navbar-nav navbar-right">
            <li><a href="user/toUserInfo">个人信息</a></li>
            <li><a href="cart/selectCart">我的购物车</a></li>
            <li><a href="cart/myFocus">我的收藏</a></li>
            <li><a href="#">我的订单</a></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                关于我们
                <b class="caret"></b>
              </a>
              <ul class="dropdown-menu">
                <li><a href="#">联系客服</a></li>
                <li><a href="#">帮助</a></li>
              </ul>
            </li>
          </ul>
        </div>
      </div>
    </nav>
    <!-- 广告轮播 -->
    <div id="myCarousel" class="carousel slide">
      <!-- 轮播（Carousel）指标 -->
      <ol class="carousel-indicators">
        <c:forEach items="${adviseGoods}" var="adviseItem" varStatus="status">
          <li data-target="#myCarousel" data-slide-to="${status.index}" ${status.index==0?'class="active"':''}></li>
        </c:forEach>
      </ol>
      <!-- 轮播（Carousel）项目 -->
      <div class="carousel-inner">
        <c:forEach items="${adviseGoods}" var="adviseItem" varStatus="status">
          <div class="item ${status.index==0?'active':''}">
            <img src="static/images/${adviseItem.gpicture}">
          </div>
        </c:forEach>
      </div>
      <!-- 轮播（Carousel）导航 -->
      <a class="carousel-control left" href="#myCarousel"
         data-slide="prev"> <span _ngcontent-c3="" aria-hidden="true" class="glyphicon glyphicon-chevron-right"></span></a>
      <a class="carousel-control right" href="#myCarousel"
         data-slide="next">&rsaquo;</a>
    </div>
    <nav class="navbar navbar-default" role="navigation">
      <div class="container-fluid">
        <div>
          <!--向左对齐-->
          <ul class="nav navbar-nav navbar-left">
            <li><a href="index/index?typeId=0">首页</a></li>
            <c:forEach items="${allTypes}" var="typeItem">
              <li><a href="index/index?typeId=${typeItem.id}">${typeItem.typename}</a></li>
            </c:forEach>
          </ul>

          <!--向右对齐-->
          <ul class="nav navbar-nav navbar-right">
            <form class="navbar-form navbar-left" role="search" action="index/search" method="post">
              <div class="form-group">
                <input type="text" class="form-control" placeholder="请输入关键词" name="key">
              </div>
              <button type="submit" class="btn btn-default">搜索</button>
            </form>
          </ul>

        </div>
      </div>
    </nav>
  </div>
  <script src="static/js/jquery-3.6.0.min.js"></script>
  <script src="static/js/bootstrap.js"></script>
</body>
</html>
