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
                        <a href="${sessionScope.adminName==null?"/admin/login":""}">${sessionScope.adminName==null?"管理员":sessionScope.adminName}</a>
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
    <div class="header-nav-container">
        <div class="container">
            <div class="header-nav-wapper main-menu-wapper">
                <div class="header-nav">
                    <div class="container-wapper">
                        <ul class="zentimo-clone-mobile-menu zentimo-nav main-menu " id="menu-main-menu">
                            <li class="menu-item">
                                <a href="/admin/" class="zentimo-menu-item-title" title="Home">首页</a>
                            </li>
                            <li class="menu-item">
                                <a href="/admin/userInfo" class="zentimo-menu-item-title" title="Shop">用户管理</a>
                            </li>
                            <li class="menu-item">
                                <a href="/admin/pduList" class="zentimo-menu-item-title" title="Pages">商品管理</a>
                            </li>
                            <li class="menu-item ">
                                <a href="/admin/product/add" class="zentimo-menu-item-title" title="Blogs">商品发布</a>
                            </li>
                            <li class="menu-item">
                                <a href="/admin/signOut" class="zentimo-menu-item-title" title="About">退出</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>