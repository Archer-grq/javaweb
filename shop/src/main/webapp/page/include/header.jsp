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
    <div class="container">
        <div class="main-header">
            <div class="row">
                <div class="col-lg-3 col-sm-4 col-md-3 col-xs-7 col-ts-12 header-element">
                    <div class="logo">
                        <a href="/">
                            <img src="/static/assets/images/logo.png" alt="img">
                        </a>
                    </div>
                </div>
                <div class="col-lg-7 col-sm-8 col-md-6 col-xs-5 col-ts-12">
                    <div class="block-search-block">
                        <form class="form-search form-search-width-category">
                            <div class="form-content">
                                <div class="inner">
                                    <input type="text" class="input" name="s" value="" placeholder="搜索">
                                </div>
                                <button class="btn-search" type="submit">
                                    <span class="icon-search"></span>
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="col-lg-2 col-sm-12 col-md-3 col-xs-12 col-ts-12">
                    <div class="header-control">
                        <div class="block-minicart zentimo-mini-cart block-header">
                            <a href="/user/shopcar" class="shopcart-icon">
                                购物车
                            </a>
                        </div>
                        <div class="block-account block-header zentimo-dropdown">
                            <a href="javascript:void(0);" data-zentimo="zentimo-dropdown">
                                <i class="fa fa-user-o" aria-hidden="true"></i>
                            </a>
                            <div class="header-account zentimo-submenu">
                                <div class="header-user-form-tabs">
                                    <ul class="tab-link">
                                        <c:if test="${sessionScope.userName==null}">
                                            <li class="active">
                                                <a data-toggle="tab" aria-expanded="true" href="#header-tab-login">登录</a>
                                            </li>
                                            <li>
                                                <a data-toggle="tab" aria-expanded="true" href="#header-tab-rigister">注册</a>
                                            </li>
                                        </c:if>
                                       <c:if test="${sessionScope.userName!=null}">
                                           <li class="active">
                                               <a data-toggle="tab" aria-expanded="true" href="#header-tab-profile">个人信息</a>
                                           </li>
                                       </c:if>
                                    </ul>
                                    <div class="tab-container">
                                        <c:if test="${sessionScope.userName==null}">
                                            <div id="header-tab-login" class="tab-panel active">
                                                <form method="post" action="/user/login" class="login form-login">
                                                    <p class="form-row form-row-wide">
                                                        <input type="text" placeholder="用户名" name="username" class="input-text">
                                                    </p>
                                                    <p class="form-row form-row-wide">
                                                        <input type="password" class="input-text" name="password" placeholder="密码">
                                                    </p>
                                                    <p class="form-row">
                                                        <input type="submit" class="button" value="登录">
                                                    </p>
                                                </form>
                                            </div>
                                            <div id="header-tab-rigister" class="tab-panel">
                                                <form method="post" action="/user/reg" class="register form-register">
                                                    <p class="form-row form-row-wide">
                                                        <input type="text" placeholder="用户名" name="username" class="input-text">
                                                    </p>
                                                    <p class="form-row form-row-wide">
                                                        <input type="password" class="input-text" name="password" placeholder="密码">
                                                    </p>
                                                    <p class="form-row form-row-wide">
                                                        <input type="password" class="input-text" name="password1" placeholder="确认密码">
                                                    </p>
                                                    <p class="form-row">
                                                        <input type="submit" class="button" value="注册">
                                                    </p>
                                                </form>
                                            </div>
                                        </c:if>
                                        <c:if test="${sessionScope.userName!=null}">
                                            <div id="header-tab-profile" class="tab-panel active">
                                                <form  class="register form-register">
                                                    <div class="form-row">
                                                        <a href="/user/update" class="button" >修改密码</a>
                                                    </div>
                                                    <br>
                                                    <div class="form-row">
                                                        <a href="/user/out" class="button" >退出登录</a>
                                                    </div>
                                                </form>
                                            </div>
                                        </c:if>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <a class="menu-bar mobile-navigation menu-toggle" href="#">
                            <span></span>
                            <span></span>
                            <span></span>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="header-nav-container rows-space-20">
        <div class="container">
            <div class="header-nav-wapper main-menu-wapper">
                <div class="vertical-wapper block-nav-categori">
                    <div class="block-title">
							<span class="icon-bar">
								<span></span>
								<span></span>
								<span></span>
							</span>
                        <span class="text">商城</span>
                    </div>
                </div>
                <div class="header-nav">
                    <div class="container-wapper">
                        <ul class="zentimo-clone-mobile-menu zentimo-nav main-menu " id="menu-main-menu">
                            <li class="menu-item">
<%--                                <a href="#" class="zentimo-menu-item-title" title="About">关于</a>--%>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>