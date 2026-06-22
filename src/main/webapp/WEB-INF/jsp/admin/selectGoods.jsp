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
            <caption>商品列表</caption>
            <thead>
            <tr>
                <th>商品ID</th>
                <th>商品名称</th>
                <th>商品类型</th>
                <th>修改</th>
                <th>删除</th>
                <th>详情</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach items="${currentGoods}" var="goods">
                    <tr>
                        <td>${goods.id}</td>
                        <td>${goods.gname}</td>
                        <td>${goods.type.typename}</td>
                        <td><a href="goods/toUpdate?id=${goods.id}">修改</a></td>
                        <td><a href="javascript:confirmDelete(${goods.id})">删除</a></td>
                        <td><a href="goods/detail?id=${goods.id}">详情</a></td>
                    </tr>
                </c:forEach>
                <tr>
                    <td colspan="6" align="right">
                        <ul class="pagination">
                            <li><a><span>第${currentPage}页</span></a></li>
                            <li><a><span>共${totalCount}页</span></a></li>
                            <c:if test="${currentPage!=1}">
                                <li><a href="goods/select?currentPage=${currentPage-1}"><span>上一页</span></a></li>
                            </c:if>
                            <c:if test="${currentPage!=totalCount}">
                                <li><a href="goods/select?currentPage=${currentPage+1}"><span>下一页</span></a></li>
                            </c:if>
                        </ul>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
<script>
    function confirmDelete(id){
        if(window.confirm("你确定真的删除吗？")){
            $.ajax({
                url:"goods/toDelete?id="+id,//请求路径
                dataType:"json",//返回数据格式
                success:function(data){//成功的回调函数
                    alert(data.msg);//弹出提示信息
                    if(data.msg.indexOf("成功")>=0){//如果提示信息中有成功两字，那说明真的执行了删除
                        console.log(location.pathname);
                        var url=location.pathname.substring(0,location.pathname.lastIndexOf("/"));
                        window.location.href=url+"/select?currentPage=1";//请求列表页面，刷新页面
                    }
                },
                error:function(){//失败的回调函数
                    alert("请求失败")
                }
            })
        }
    }
</script>
</body>
</html>
