<%--
  Created by IntelliJ IDEA.
  User: lwvc
  Date: 2026/5/6
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        .yj{
            text-decoration: line-through;
        }
    </style>
</head>
<body>
    <jsp:include page="head.jsp"/>
    <div class="container">
        <!-- 左对齐 -->
        <div class="media">
            <div class="media-left">
                <img src="static/images/${goods.gpicture}" class="media-object" style="width:280px">
            </div>
            <div class="media-body">
                <p>商品名:${goods.gname}</p>
                <p>商品折扣价:￥${goods.grprice}</p>
                <p>商品原价:￥<span class="yj">${goods.goprice}</span></p>
                <p>商品类型:${goods.type.typename}</p>
                <p>库存:${goods.gstore}</p>
                <p><input type="text" placeholder="请输入购买量" id="num"/></p>
                <p>
                    <button type="button" class="btn btn-primary" onclick="shoucang(${goods.id})">加入收藏</button>
                    <button type="button" class="btn btn-success" onclick="jiagou(${good.id})">加入购物车</button>
                </p>
            </div>
        </div>
    </div>
    <script>
        function shoucang(id){
            $.ajax({
                url:"user/focus?goodId="+id,
                type: 'POST',
                contentType:"application/json",
                success:function(data){
                    if(data=="noLogin"){
                        alert("请先登录")
                    }
                    if(data=="no"){
                        alert("您已收藏过该商品")
                    }
                    if(data=="ok"){
                        alert("收藏成功")
                    }
                    if(data=="fail"){
                        alert("收藏失败")
                    }
                }
            })
        }
        function jiagou(id){
            var num=document.getElementById("num").value;
            if (num==null||num.trim())
                $.ajax({
                    url: 'cart/putCart',
                    type: 'POST',
                    contentType: 'application/json',
                    data:JSON.stringify({goodstable_id:id,shoppingnum:num}),
                    success: function(res) {
                        if(res=="ok"){
                            alert("加购成功")
                        }
                        if(res=="fail"){
                            alert("加购失败")
                        }
                    },
                    error:function(res){
                        console.log(res);
                    }
                });
        }
    </script>
</body>
</html>
