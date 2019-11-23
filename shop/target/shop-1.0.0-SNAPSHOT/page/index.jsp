<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>商城</title>
    <link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/index.css">
</head>
<body>
<nav  class="navbar navbar-default" role="navigation">
    <div class="container">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="/">商城</a>
            </div>
            <div>
                <!--向右对齐-->
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            个人中心 <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="/user/shopcar">购物车</a></li>
                            <c:if test="${sessionScope.userName!=null}">
                                <li class="divider"></li>
                                <li><a href="/user/out">退出</a></li>
                            </c:if>
                        </ul>
                    </li>
                </ul>
                <a href="${sessionScope.userName==null?"/user/login":""}" class="navbar-text navbar-right">${sessionScope.userName==null?"登录":sessionScope.userName}</a>
                <a href="/admin/login" class="navbar-text navbar-right">admin</a>
            </div>
        </div>
    </div>
</nav>

<div class="row">
    <div class="container" style="height: 100px">
        <img src="/css/timg.gif" class="navbar-left" style="height: 100px">
        <form class="navbar-form navbar-right" role="search">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Search">
            </div>
            <button type="submit" class="btn btn-default" onclick="shop()">搜索商品</button>
        </form>
    </div>
</div>

<div class="row">
    <div class="class">
        <div class="uldiv">
            <ul class="classList">
                <c:forEach items="${list}" var="item">
                    <li class="cli ${item.id==firstPC?'lion':''}" id="${item.id}">${item.cname}</li>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>

<c:forEach items="${map}" var="item">
    <div class="row pdu ${item.key==firstPC?'pduon':''}" id="${item.key}pdu">
        <ul class="pduul col-sm-10 col-sm-offset-1">
            <c:forEach items="${item.value}" var="i">
                <li class="pduli col-sm-3">
                    <div class="pdulit">
                        <div class="pduimg">
                            <img src="${i.pimg}" alt="1" class="pduimgs">
                        </div>
                        <div class="pdumsg">
                            <h4> ${i.pname}</h4>
                            <p class="describe">${i.describe}</p>
                        </div>
                    </div>
                    <div class="pdulif ">
                        <div class="pduvalue">
                            <h2 class="red"><span class="describe">￥</span>${i.pvalue}</h2>
                        </div>
                        <div class="btnbtn">
                            <a href="/product?pid=${i.id}" class="button">立即抢购</a>
                        </div>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>
</c:forEach>


<script src="/js/jquery-3.4.1.min.js "></script>
<script src="/bootstrap/js/bootstrap.min.js"></script>
<script>
    var ii;
    function shop(){
        $(".cli").each(function(){
            if($(this).hasClass("lion")){
                ii=$(this).attr('id')
            }
        });
    }
    $(function () {

        $('.uldiv>ul').on('click','li',function () {
            $(this).addClass('lion').siblings().removeClass('lion');
            var id=$(this).attr('id')+'pdu'
            $('#'+id).addClass('pduon').siblings().removeClass('pduon')
        })


    })
</script>
</body>
</html>
