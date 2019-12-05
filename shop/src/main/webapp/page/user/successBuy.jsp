<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>商城</title>
    <jsp:include page="/page/includes/head.jsp"/>
</head>
<body>
<jsp:include page="/page/includes/top.jsp"/>

<div class="container">
	<c:if test="${msg!=null}">
		<div>
    	<font color="red" size="50px">${msg}</font>
    </div>
	</c:if>
</div>
</body>
</html>
