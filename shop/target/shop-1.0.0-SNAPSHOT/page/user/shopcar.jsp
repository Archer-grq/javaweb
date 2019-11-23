<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>购物车</title>
    <link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/index.css">
</head>
<body>
<nav  class="navbar navbar-default" role="navigation">
    <div class="container">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="/">返回首页</a>
            </div>
            <div>
                <!--向右对齐-->
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            个人中心 <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="#">个人资料</a></li>
                            <li><a href="#"></a></li>
                            <li><a href="/user/shopcar">购物车</a></li>
                            <li class="divider"></li>
                            <li><a href="/user/out">退出</a></li>
                        </ul>
                    </li>
                </ul>
                <a class="navbar-text navbar-right">${sessionScope.userName}</a>
                <a href="/admin/login" class="navbar-text navbar-right">admin</a>
            </div>
        </div>
    </div>
</nav>

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
            <a href="#" id="buy" class="col-sm-2">立即购买</a>
        </div>
    </div>
</div>

<script src="/js/jquery-3.4.1.min.js "></script>
<script src="/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
