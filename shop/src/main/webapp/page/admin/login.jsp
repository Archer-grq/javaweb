<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>商城</title>
    <jsp:include page="/page/include/css.jsp"/>
</head>
<body class="home">
<jsp:include page="/page/include/simpleHeader.jsp"/>
<div class="main-content main-content-login">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="breadcrumb-trail breadcrumbs">
                    <ul class="trail-items breadcrumb">
                        <li class="trail-item trail-begin">
                            <a href="/">商城</a>
                        </li>
                        <li class="trail-item trail-end active">
                            管理员
                        </li>
                    </ul>
                </div>
            </div>
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
            <div class="content-area col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <div class="site-main">
                    <h3 class="custom_blog_title">
                        管理员登录
                    </h3>
                    <div class="customer_login">
                        <div class="row">
                            <div class="col-lg-6 col-md-6 col-sm-12">
                                <div class="login-item">
                                    <h5 class="title-login">登录到后台管理系统</h5>
                                    <form class="login" action="/admin/login" method="post">
                                        <p class="form-row form-row-wide">
                                            <label class="text">用户名</label>
                                            <input title="username" type="text" name="name" value="admin" class="input-text">
                                        </p>
                                        <p class="form-row form-row-wide">
                                            <label class="text">密码</label>
                                            <input title="password" type="password" name="pwd" value="admin" class="input-text">
                                        </p>
                                        <p class="form-row">
                                            <input type="submit" class="button-submit" value="登录">
                                        </p>
                                    </form>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="/page/include/footer.jsp"/>
<jsp:include page="/page/include/js.jsp"/>
</body>
</html>
