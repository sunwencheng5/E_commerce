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
                <!--饼状图容器-->
                <div id="demo" style="width:80%; height:400px"></div>
            </div>
        </div>
    </div>
<script src="static/js/echarts.js"></script>
<script>
    var demo= echarts.init(document.getElementById('demo'));
    var typenames = ${types};
    var totalAmount = ${totalAmounts};
    var dataList = [];
    for(var i = 0; i < typenames.length; i++){
        dataList[i] = {value: totalAmount[i], name: typenames[i]};
    }
    var option = {
        title: {
            text: '按商品分类统计订单',
            subtext: '单位万元',
            left: 'center'
        },
        tooltip: {
            trigger: 'item'
        },
        legend: {
            orient: 'vertical',
            left: 'left'
        },
        series: [
            {
                name: '订单量',
                type: 'pie',
                radius: '50%',
                data: dataList,
                emphasis: {
                    itemStyle: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ]
    };
    demo.setOption(option);

</script>
</body>
</html>
