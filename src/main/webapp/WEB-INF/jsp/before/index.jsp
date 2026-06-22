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
    <style>
        .oprice{
            text-decoration: line-through;
        }
        .goods-row {
            display: flex;
            flex-wrap: wrap;
        }
        .goods-row [class*="col-"] {
            /* 保留原有宽度，但移除默认的浮动行为 */
            float: none;
        }
        /* 强制左对齐，避免最后一个元素被拉伸 */
        .goods-row::after {
            display: none;
        }
    </style>
</head>
<body>
  <jsp:include page="head.jsp"/>
  <div class="container">
      <h2>最新商品</h2>
      <div class="row goods-row" >
          <c:forEach items="${latestGoods}" var="goods">
            <div class="col-sm-6 col-md-2">
                <div class="thumbnail">
                    <a href="index/toDetail?id=${goods.id}">
                        <img src="static/images/${goods.gpicture}">
                    </a>
                    <div class="caption">
                        <h3>${goods.gname}</h3>
                        <p>
                            <span>￥${goods.grprice}</span>
                            <span class="oprice">￥${goods.goprice}</span>
                        </p>
                        <p>
                            <a href="#" class="btn btn-primary" role="button">
                                加入收藏
                            </a>
                        </p>
                    </div>
                </div>
            </div>
          </c:forEach>
      </div>
  </div>
</body>
</html>
