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
		<div>
    	<font color="red" size="50px">${msg}</font>
    </div>
	</c:if>
</div>


<script src="/js/jquery-3.4.1.min.js "></script>
<script src="/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
