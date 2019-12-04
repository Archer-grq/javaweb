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
            <li><a href="/admin/">主页</a></li>
            <li class="active"><a href="">用户管理</a></li>
            <li><a href="/admin/pduList">商品管理</a></li>
            <li><a href="/admin/product/add">商品发布</a></li>
            <li><a href="/admin/signOut">退出</a></li>
        </ul>
    </div>
    <div style="float: left;width: 85%;">
        <div style="height: 50px;background-color: #cccccc;width: 100%; margin-bottom: 40px;">
        <div class="row">
            <div class="col-sm-4 col-sm-offset-4" style="height: 100%; text-align: center; line-height: 50px;">
                <b>用户管理</b>
            </div>
            <div class="col-sm-2 col-sm-offset-2" style="height: 100%; text-align: center; line-height: 50px;">
                用户名：${sessionScope.adminName}
            </div>
        </div>
        </div>
        <div class="row">
            <div class="col-sm-8 col-sm-offset-2">
                <c:if test="${dmessage!=null}">
                    <div class="alert ${dmessage.equals("删除成功")?"alert-success":"alert-danger"} alert-dismissable">
                        <button type="button" class="close" data-dismiss="alert"
                                aria-hidden="true">
                            &times;
                        </button>
                            ${dmessage}
                    </div>
                </c:if>
            </div>
        </div>
        <table class="table table-striped table-bordered table-hover">
            <thead>
            <tr>
                <th>账号</th>
                <th>用户名</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${userList}" var="user" >
                <tr>
                    <td>${user.id}</td>
                    <td>${user.username}</td>
                    <td><a type="button" class="btn btn-default" href="/admin/delete?id=${user.id}">删除</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>

</div>


<script src="/js/jquery-3.4.1.min.js "></script>
<script src="/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
