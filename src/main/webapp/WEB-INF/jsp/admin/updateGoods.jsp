<%--
  Created by IntelliJ IDEA.
  User: lwvc
  Date: 2026/4/17
  Time: 9:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>Title</title>
    <base href="<%=basePath%>">
</head>
<body>
    <div class="container">
        <jsp:include page="nav.jsp"/>
        <form role="form" action="goods/doUpdate" method="post" enctype="multipart/form-data">
            <h1>修改商品</h1>
            <div class="form-group">
                <label for="id">商品ID</label>
                <input type="text" class="form-control" id="id" placeholder="请输入名称"  value="${goods.id}" disabled>
                <input type="hidden" name="id" value="${goods.id}"/>
            </div>
            <div class="form-group">
                <label for="name">商品名</label>
                <input type="text" class="form-control" id="name" placeholder="请输入名称" name="gname" value="${goods.gname}">
            </div>
            <div class="form-group">
                <label for="goprice">商品原价</label>
                <input type="text" class="form-control" id="goprice" placeholder="0.0" name="goprice" value="${goods.goprice}">
            </div>
            <div class="form-group">
                <label for="grprice">商品折扣价</label>
                <input type="text" class="form-control" id="grprice" placeholder="0.0" name="grprice" value="${goods.grprice}">
            </div>
            <div class="form-group">
                <label for="gstore">商品库存</label>
                <input type="text" class="form-control" id="gstore" placeholder="0" name="gstore"  value="${goods.gstore}">
            </div>
            <div class="form-group">
                <label for="gpictureForm">商品图片</label>
                <input type="file" id="gpictureForm" name="gpictureForm">
            </div>
            <input type="hidden" name="gpicture"value="${goods.gpicture}"/>
            <!-- 预览容器 -->
            <div id="previewContainer" style="display: flex; gap: 10px; flex-wrap: wrap; margin-top: 20px;">
                <img src="static/images/${goods.gpicture}"/>
            </div>
            <div class="form-group">
                <label for="name">商品类型</label>
                <select class="form-control" name="type.id">
                    <!--遍历typeList，展示商品类型下拉列表-->
                   <c:forEach items="${typeList}" var="item">
                       <!-- 判断是否和此商品的类型相同，相同则设置为选中状态-->
                       <option value="${item.id}" ${item.id==goods.type.id? 'selected':''}>${item.typename}</option>
                   </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label>是否广告</label>
                <label class="radio-inline">
                    <input type="radio" name="isshow" id="optionsRadios3" value="1" ${goods.isshow==1?'checked':''}> 是
                </label>
                <label class="radio-inline">
                    <input type="radio" name="isshow" id="optionsRadios4"  value="0"  ${goods.isshow==0?'checked':''}> 否
                </label>
            </div>
            <button type="submit" class="btn btn-default">修改</button>
            <button type="reset" class="btn btn-default">重置</button>
        </form>
    </div>
    <script>
        const input = document.getElementById('gpictureForm');
        const previewArea = document.getElementById('previewContainer');

        input.addEventListener('change', function(event) {
            // 清空之前的预览
            previewArea.innerHTML = '';

            const file = event.target.files[0];  // 单选，直接取第一个

            // 如果没有选择文件则返回
            if (!file) return
            const reader=new FileReader();
            reader.onload = function(e) {
                // 创建图片元素
                const img = document.createElement('img');
                img.src = e.target.result;
                img.style.maxWidth = '300px';
                img.style.maxHeight = '300px';
                img.style.borderRadius = '8px';
                img.style.border = '1px solid #ccc';
                img.style.display = 'block';
                previewArea.appendChild(img);
            };

            reader.readAsDataURL(file);
        });
    </script>
</body>
</html>
