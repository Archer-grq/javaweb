<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>商城</title>
    <jsp:include page="/page/include/css.jsp"/>
</head>
<body class="home">
<jsp:include page="/page/include/adminHeader.jsp"/>

<div class="container">
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
<jsp:include page="/page/include/footer.jsp"/>
<jsp:include page="/page/include/js.jsp"/>
</body>
</html>
