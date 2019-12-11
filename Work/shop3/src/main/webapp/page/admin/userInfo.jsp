<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户管理</title>
    <jsp:include page="/page/includes/head.jsp"/>
</head>
<body>
<div style="padding:0 50px">
    <jsp:include page="/page/includes/adminNav.jsp">
        <jsp:param name="index" value="1"/>
    </jsp:include>
    <div style="float: left;width: 85%;">
        <jsp:include page="/page/includes/adminTop.jsp">
            <jsp:param name="topname" value="用户管理"/>
        </jsp:include>
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
</body>
</html>
