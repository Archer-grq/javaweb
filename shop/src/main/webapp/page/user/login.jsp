<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户登录</title>
    <link rel="stylesheet" href="../../bootstrap/css/bootstrap.min.css">
    <style>
        #body{
            border: #0f0f0f solid 1px;
            width:500px;
            padding:50px;
            margin:100px auto;
            border-radius: 10px;
        }
    </style>
</head>
<body>
<div class="container" id="body">
    <div class="row">
        <h1 class="text-center">欢迎会员登录</h1>
    </div>
    <div class="row">
        <c:if test="${message!=null}">
            <div class="alert alert-success alert-dismissable">
                <button type="button" class="close" data-dismiss="alert"
                        aria-hidden="true">
                    &times;
                </button>
                    ${message}
            </div>
        </c:if>
    </div>
    <form class="form-horizontal" role="form" action="/user/login" method="post">
        <div class="form-group">
            <label for="name" class="col-sm-3 control-label">用户名</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" id="name" name="username" placeholder="请输入用户名">
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="col-sm-3 control-label">密码</label>
            <div class="col-sm-8">
                <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-2">
                <a type="button" href="/" class="btn btn-default">返回首页</a>
            </div>
            <div class="col-sm-offset-4 col-sm-2">
                <button type="submit" class="btn btn-info">登录</button>
            </div>
            <div class=" col-sm-2">
                <a type="button" href="/user/reg" class="btn btn-default">注册</a>
            </div>
        </div>
    </form>
</div>



<script src="../../js/jquery-3.4.1.min.js "></script>
<script src="../../bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
