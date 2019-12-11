<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>商城</title>
    <jsp:include page="/page/include/css.jsp"/>
</head>
<body class="home">
<jsp:include page="/page/include/simpleHeader.jsp"/>
<div class="site-content">
    <main class="site-main  main-container no-sidebar">
        <div class="container">
            <div class="breadcrumb-trail breadcrumbs">
                <ul class="trail-items breadcrumb">
                    <li class="trail-item trail-begin">
                        <a href="">
								<span>
									商城
								</span>
                        </a>
                    </li>
                    <li class="trail-item trail-end active">
							<span>
								购物车
							</span>
                    </li>
                </ul>
            </div>
            <div class="row">
                <div class="main-content-cart main-content col-sm-12">
                    <h3 class="custom_blog_title">
                        购物车
                    </h3>
                    <div class="page-main-content">
                        <div class="shoppingcart-content">
                            <form action="#" class="cart-form">
                                <table class="shop_table">
                                    <thead>
                                    <tr>
                                        <th class="product-remove"></th>
                                        <th class="product-thumbnail"></th>
                                        <th class="product-name"></th>
                                        <th class="product-price"></th>
                                        <th class="product-quantity"></th>
                                        <th class="product-subtotal"></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${list}" var="item">
                                            <tr class="cart_item">
                                                <td class="product-remove">
                                                    <a href="/user/shopcar/delete?id=${item.id}" class="remove"></a>
                                                </td>
                                                <td class="product-thumbnail">
                                                    <a href="#">
                                                        <img src="${item.pimg}" alt="img"
                                                             class="attachment-shop_thumbnail size-shop_thumbnail wp-post-image">
                                                    </a>
                                                </td>
                                                <td class="product-name" data-title="Product">
                                                    <a href="/product?pid=${item.pid}" class="title">${item.pname}</a>
                                                </td>
                                                <td class="product-quantity" data-title="Quantity">
                                                    <div class="quantity">
                                                        <div class="control">
                                                                <span class="input-qty qty">
                                                                        ${item.num}
                                                                </span>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td class="product-price" data-title="Price">
                                            <span class="woocommerce-Price-amount amount">
                                                <span class="woocommerce-Price-currencySymbol">
                                                    ￥
                                                </span>
                                                    52
                                            </span>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </form>
                            <div class="control-cart">
                                <a href="/user/shopcar/delete" class="button btn-continue-shopping">
                                    清空购物车
                                </a>
                                <a href="/user/buy" class="button btn-cart-to-checkout">
                                    立即购买
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>
</div>
<jsp:include page="/page/include/footer.jsp"/>
<jsp:include page="/page/include/js.jsp"/>
</body>
</html>
