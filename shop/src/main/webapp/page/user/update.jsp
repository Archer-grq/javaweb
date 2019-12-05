<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改密码</title>
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
        <h1 class="text-center">修改密码</h1>
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
    <form class="form-horizontal" role="form" action="/user/update" method="post">
        <input type="hidden" name="id" value="${sessionScope.userId}" >
        <input type="hidden" name="name" value="${sessionScope.userName}" >

        <div class="form-group">
            <label for="id" class="col-sm-3 control-label">用户名</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" id="id"   value="${sessionScope.userName}" disabled>
            </div>
        </div>
        <div class="form-group">
            <label for="oldPassword" class="col-sm-3 control-label">原密码</label>
            <div class="col-sm-8">
                <input type="password" class="form-control" id="oldPassword" name="oldPassword" placeholder="请输入密码">
            </div>
        </div>
        <div class="form-group">
            <label for="newPassword" class="col-sm-3 control-label">新密码</label>
            <div class="col-sm-8">
                <input type="password" class="form-control" id="newPassword" name="newPassword" placeholder="请输入密码">
            </div>
        </div>
        <div class="form-group">
            <label for="newpassword1" class="col-sm-3 control-label">确认密码</label>
            <div class="col-sm-8">
                <input type="password" class="form-control" id="newpassword1" name="newPassword1" placeholder="请再次输入密码">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-2 ">
                <a type="button" href="/" class="btn btn-default">返回首页</a>
            </div>
            <div class="col-sm-3 col-sm-offset-5 ">
                <button type="submit" class="btn btn-info">确认修改</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
