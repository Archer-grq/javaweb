<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>注册</title>
    <jsp:include page="/page/includes/head.jsp"/>
    <style>

        #body{
            width:500px;
            margin:100px auto;
        }
    </style>
</head>
<body>
<div class="container" id="body">
    <div class="row">
        <h1 class="text-center">注册</h1>
    </div>
    <div class="row">
        <c:if test="${message!=null}">
            <div class="alert alert-danger alert-dismissable">
                <button type="button" class="close" data-dismiss="alert"
                        aria-hidden="true">
                    &times;
                </button>
                ${message}
            </div>
        </c:if>
    </div>
    <form class="form-horizontal" role="form" action="/user/reg" method="post">
        <div class="form-group">
            <label for="id" class="col-sm-3 control-label">用户名</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" id="id" name="username" placeholder="请输入用户名">
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="col-sm-3 control-label">密码</label>
            <div class="col-sm-8">
                <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码">
            </div>
        </div>
        <div class="form-group">
            <label for="password1" class="col-sm-3 control-label">确认密码</label>
            <div class="col-sm-8">
                <input type="password" class="form-control" id="password1" name="password1" placeholder="请再次输入密码">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-2 ">
                <a type="button" href="/" class="btn btn-default">返回首页</a>
            </div>
            <div class="col-sm-offset-3 col-sm-2 ">
                <a type="button" href="/user/login" class="btn btn-default">返回登录</a>
            </div>
            <div class="col-sm-3 ">
                <button type="submit" class="btn btn-info">注册</button>
            </div>
        </div>
    </form>
</div>

</body>
</html>
