<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header class="header style7">
    <div class="top-bar">
        <div class="container">
            <div class="top-bar-left">
                <div class="header-message">
                    <a href="/">网上商城</a>
                </div>
            </div>
            <div class="top-bar-right">
                <ul class="header-user-links">
                    <li>
                        <a href="/admin/login">管理员</a>
                    </li>
                </ul>
                <ul class="header-user-links">

                    <li>
                        <a href="${sessionScope.userName==null?"/user/login":""}">${sessionScope.userName==null?"登录|注册":sessionScope.userName}</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</header>