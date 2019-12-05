<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div style="height: 50px;background-color: #cccccc;width: 100%; margin-bottom: 40px;">
    <div class="row">
        <div class="col-sm-4 col-sm-offset-4" style="height: 100%; text-align: center; line-height: 50px;">
            <b>${param.topname}</b>
        </div>
        <div class="col-sm-2 col-sm-offset-2" style="height: 100%; text-align: center; line-height: 50px;">
            用户名：${sessionScope.adminName}
        </div>
    </div>
</div>