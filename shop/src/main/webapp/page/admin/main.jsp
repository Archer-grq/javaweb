<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户管理</title>
    <link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">
</head>
<body>
<div style="padding:0 50px">
    <div style="float: left;width: 15%">
        <ul class="nav nav-pills nav-stacked">
            <li class="active"><a href="">主页</a></li>
            <li ><a href="/admin/userInfo">用户管理</a></li>
            <li><a href="/admin/pduList">商品管理</a></li>
            <li><a href="/admin/product/add">商品发布</a></li>
            <li><a href="/admin/signOut">退出</a></li>
        </ul>
    </div>
    <div style="float: left;width: 85%;">
        <div style="height: 50px;background-color: #cccccc;width: 100%; margin-bottom: 40px;">
            <div class="row">
                <div class="col-sm-4 col-sm-offset-4" style="height: 100%; text-align: center; line-height: 50px;">
                    <b>主页</b>
                </div>
                <div class="col-sm-2 col-sm-offset-2" style="height: 100%; text-align: center; line-height: 50px;">
                    用户名：${sessionScope.adminName}
                </div>
            </div>

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

    </div>

</div>


<script src="/js/jquery-3.4.1.min.js "></script>
<script src="/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
