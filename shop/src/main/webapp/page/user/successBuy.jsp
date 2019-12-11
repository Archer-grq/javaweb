<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>商城</title>
	<jsp:include page="/page/include/css.jsp"/>
</head>
<body class="home">
<jsp:include page="/page/include/simpleHeader.jsp"/>

<div class="main-content main-content-404 right-sidebar">
	<div class="container">
		<div class="row">
			<div class="content-area content-404 col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<div class="site-main">
					<section class="error-404 not-found">
						<div class="images">
							<img src="/static/assets/images/404.jpg" alt="img">
						</div>
						<div class="text-404">
							<h1 class="page-title">
								<c:if test="${msg!=null}">
										${msg}
								</c:if>
							</h1>
						</div>
					</section>
				</div>
			</div>
		</div>
	</div>
</div>


<jsp:include page="/page/include/footer.jsp"/>
<jsp:include page="/page/include/js.jsp"/>
</body>
</html>
