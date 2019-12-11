<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>商品管理系统</title>
    <jsp:include page="/page/includes/head.jsp"/>
</head>
<body>
<div style="padding:0 50px">
    <jsp:include page="/page/includes/adminNav.jsp">
        <jsp:param name="index" value="0"/>
    </jsp:include>
    <div style="float: left;width: 85%;">
        <jsp:include page="/page/includes/adminTop.jsp">
            <jsp:param name="topname" value="主页"/>
        </jsp:include>
        <div class="row">
            <div class="container">
                <h1 class="col-sm-5 col-sm-offset-3">欢迎登录商品管理系统</h1>
            </div>
        </div>
    </div>
</div>
<jsp:include page="/page/includes/head.jsp"/>
</body>
</html>
