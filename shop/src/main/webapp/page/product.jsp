<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>商品</title>
    <jsp:include page="/page/include/css.jsp"/>
    <link rel="stylesheet" href="/static/css/index.css">
</head>
<body class="home">
<jsp:include page="/page/include/header.jsp"/>


<div class="container">
    <c:if test="${msg!=null}">
        <div class="alert alert-danger alert-dismissable">
            <button type="button" class="close" data-dismiss="alert"
                    aria-hidden="true">
                &times;
            </button>
                ${msg}
        </div>
    </c:if>
</div>

<div class="row">
    <div class="container" >
        <div class="col-sm-5">
            <img src="${product.pimg}" width="100%" style="padding:20px;border: 1px solid #c8cbcf" alt="1">
            <p><h3>${product.pname}</h3></p>
        </div>
        <div class="col-sm-7" style="padding: 20px">
            <form action="/user/shopcar" method="post">
                <input type="hidden" name="pid" value="${product.id}">
                <input type="hidden" name="uid" value="${sessionScope.userId==null?" ":sessionScope.userId}">
                <div class="row">
                    <label class="col-sm-12 pduname">${product.pname}</label>
                </div>
                <div class="row pvalue">
                    <label for="pvalue" class="col-sm-2 title">价格</label>
                    <label id="pvalue" class="col-sm-10 tv"><i>￥</i>${product.pvalue}</label>
                </div>
                <div class="row pvalue">
                    <label for="pdescribe" class="col-sm-2 title">商品描述</label>
                    <label id="pdescribe" class="col-sm-8 pdescribe">${product.describe}</label>
                </div>
                <div class="row pvalue">
                    <label for="ppvalue" class="col-sm-2 title">数量</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" id="ppvalue" value="1" name="pnum" placeholder="请输入数量">
                    </div>
                </div>
                <div class="row">
                    <input type="submit" id="addCarBtn" value="加入购物车">
                </div>
            </form>
        </div>
    </div>
</div>

<jsp:include page="/page/include/footer.jsp"/>
<jsp:include page="/page/include/js.jsp"/>
</body>
</html>
