<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div style="float: left;width: 15%">
    <ul class="nav nav-pills nav-stacked" id="adminNav">
        <li ><a href="/admin/">主页</a></li>
        <li><a href="/admin/userInfo">用户管理</a></li>
        <li><a href="/admin/pduList">商品管理</a></li>
        <li><a href="/admin/product/add">商品发布</a></li>
        <li><a href="/admin/signOut">退出</a></li>
    </ul>
</div>
<script>
    $(function () {
        //给第 index 个 li 添加class:active
        $("#adminNav li").eq(parseInt(${param.index})).addClass('active')
    })
</script>