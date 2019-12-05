<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>购物车</title>
    <jsp:include page="/page/includes/head.jsp"/>
</head>
<body>
<jsp:include page="/page/includes/top.jsp"/>

<div class="row">
    <div class="container" >
        <table class="table table-striped">
            <caption>购物车</caption>
            <thead>
            <tr>
                <th>id</th>
                <th>商品名称</th>
                <th>数量</th>
                <th>单价</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${list}" var="item">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.pname}</td>
                    <td>${item.num}</td>
                    <td>${item.pvalue}</td>
                    <td><a href="/user/shopcar/delete?id=${item.id}" class="btn btn-danger">删除</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="row">
            <a href="/user/shopcar/delete" class="btn btn-danger col-sm-2">清空购物车</a>
            <div class="col-sm-4 col-sm-offset-4">
                <label class="tv"><span style="color:#6c757d ;font-size: 15px;margin-right: 20px">总价</span><i>￥</i>${totalMoney}</label>
            </div>
            <a href="/user/buy" id="buy" class="col-sm-2">立即购买</a>
        </div>
    </div>
</div>
</body>
</html>
