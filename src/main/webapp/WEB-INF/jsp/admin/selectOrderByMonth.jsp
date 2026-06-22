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
        <div class="panel panel-primary">
            <div class="panel-heading">
                <h3 class="panel-title">近一年的订单统计</h3>
            </div>
            <div class="panel-body">
                <!--柱状图容器-->
                <div id="demo" style="width:80%; height:400px"></div>
            </div>
        </div>
    </div>
<script src="static/js/echarts.js"></script>
<script>
    //生成柱状图
    var demo=echarts.init(document.getElementById("demo"))
    //设置柱状图各项参数
    var option={
        tooltip:{
            trigger:'axis',
            axisPointer:{
                type:'shadow'
            }
        },
        grid:{
            left:'3%',
            right:'4%',
            bottom:'3%',
            containLabel:true
        },
        xAxis: {
            type:'category',
            data:${months} ,
            axisTick:{
                alignWithLabel: true
            }
        },
        yAxis: {
            type:'value'
        },
        series:[{
            data:${totalAmounts},
            type:'bar',
            name:'销量(元)'
        }]
    };
    demo.setOption(option);
</script>
</body>
</html>
