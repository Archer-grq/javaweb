<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>商城</title>
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
                            <li><a href="/user/shopcar">购物车</a></li>
                            <c:if test="${sessionScope.userName!=null}">
                                <li><a href="/user/update">修改密码</a></li>
                                <li class="divider"></li>
                                <li><a href="/user/out">退出</a></li>
                            </c:if>
                        </ul>
                    </li>
                </ul>
                <a href="${sessionScope.userName==null?"/user/login":""}" class="navbar-text navbar-right">${sessionScope.userName==null?"登录":sessionScope.userName}</a>
                <a href="/admin/login" class="navbar-text navbar-right">admin</a>
            </div>
        </div>
    </div>
</nav>

<div class="container">
    <c:if test="${msg!=null}">
        <div class="alert alert-danger alert-dismissable">
            <button type="button" class="close" data-dismiss="alert"
                    aria-hidden="true">
                &times;
            </button>
           ${msg}
        </div>
    </c:if>
</div>

<div class="row">
    <div class="container" >
        <div class="col-sm-5">
            <img src="${product.pimg}" width="100%" style="padding:20px;border: 1px solid #c8cbcf" alt="1">
            <p><h3>${product.pname}</h3></p>
            <a class="iconc"><span class="glyphicon glyphicon-heart"><i>收藏</i></span></a>
            <a class="iconc"><span class="glyphicon glyphicon-share-alt"><i>分享</i></span></a>
            <a class="iconc"><span class="glyphicon glyphicon-sort"><i>对比</i></span></a>
        </div>
        <div class="col-sm-7" style="padding: 20px">
            <form action="/user/shopcar" method="post">
                <input type="hidden" name="pid" value="${product.id}">
                <input type="hidden" name="uid" value="${sessionScope.userId==null?" ":sessionScope.userId}">
                <div class="row">
                    <label class="col-sm-12 pduname">${product.pname}</label>
                </div>
                <div class="row pvalue">
                    <label for="pvalue" class="col-sm-2 title">价格</label>
                    <label id="pvalue" class="col-sm-10 tv"><i>￥</i>${product.pvalue}</label>
                </div>
                <div class="row pvalue">
                    <label for="pdescribe" class="col-sm-2 title">商品描述</label>
                    <label id="pdescribe" class="col-sm-8 pdescribe">${product.describe}</label>
                </div>
                <div class="row pvalue">
                    <label for="ppvalue" class="col-sm-2 title">数量</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" id="ppvalue" value="1" name="pnum" placeholder="请输入数量">
                    </div>
                </div>
                <div class="row">
                    <input type="submit" id="addCarBtn" value="加入购物车">
                </div>
            </form>
        </div>
    </div>
</div>

<script src="/js/jquery-3.4.1.min.js "></script>
<script src="/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
