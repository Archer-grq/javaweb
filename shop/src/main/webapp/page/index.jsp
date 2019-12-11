<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>商城</title>
    <jsp:include page="/page/include/css.jsp"/>
</head>
<body class="home">
<jsp:include page="/page/include/header.jsp"/>
<div>
    <div class="fullwidth-template">
        <div class="zentimo-tabs  default rows-space-40">
            <div class="container">
                <div class="tab-head">
                    <ul class="tab-link">
                        <c:forEach items="${list}" var="item">
                            <li class="${item.id==firstPC?'active':''}">
                                <a data-toggle="tab" aria-expanded="true" href="#${item.id}">${item.cname}</a>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
                <div class="tab-container">
                    <c:forEach items="${map}" var="item">
                        <div id="${item.key}" class="tab-panel ${item.key==firstPC?'active':''}">
                            <div class="zentimo-product">
                                <ul class="row list-products auto-clear equal-container product-grid">
                                    <c:forEach items="${item.value}" var="i">
                                        <li class="product-item  col-lg-3 col-md-4 col-sm-6 col-xs-6 col-ts-12 style-1">
                                            <div class="product-inner equal-element">
                                                <div class="product-top">
                                                    <div class="flash">
													<span class="onnew">
														<span class="text">
															new
														</span>
													</span>
                                                    </div>
                                                </div>
                                                <div class="product-thumb">
                                                    <div class="thumb-inner">
                                                        <a href="#">
                                                            <img src="${i.pimg}" alt="img">
                                                        </a>
                                                    </div>
                                                </div>
                                                <div class="product-info">
                                                    <h5 class="product-name product_title">
                                                        <a href="#">${i.pname}</a>
                                                    </h5>
                                                    <div class="group-info">
                                                        <div class="stars-rating">
                                                            <div class="star-rating">
                                                                <span class="star-3"></span>
                                                            </div>
                                                            <div class="count-star">
                                                                (3)
                                                            </div>
                                                        </div>
                                                        <div class="price">
                                                            <ins>
                                                                ￥${i.pvalue}
                                                            </ins>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="loop-form-add-to-cart">
                                                    <form class="cart">
                                                        <div class="single_variation_wrap">
                                                            <a href="/product?pid=${i.id}" class="single_add_to_cart_button button">立即购买
                                                            </a>
                                                        </div>
                                                    </form>
                                                </div>
                                            </div>
                                        </li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="/page/include/footer.jsp"/>
<jsp:include page="/page/include/js.jsp"/>
</body>
</html>
