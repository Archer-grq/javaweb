<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户管理</title>
    <jsp:include page="/page/includes/head.jsp"/>
</head>
<body>
<div style="padding:0 50px">
    <jsp:include page="/page/includes/adminNav.jsp">
        <jsp:param name="index" value="3"/>
    </jsp:include>
    <div style="float: left;width: 85%;">
        <jsp:include page="/page/includes/adminTop.jsp">
            <jsp:param name="topname" value="商品发布"/>
        </jsp:include>
        <div class="row">
            <div class="col-sm-8 col-sm-offset-2">
                <c:if test="${m!=null}">
                    <div class="alert alert-danger alert-dismissable">
                        <button type="button" class="close" data-dismiss="alert"
                                aria-hidden="true">
                            &times;
                        </button>
                            ${m}
                    </div>
                </c:if>
                <c:if test="${msg!=null}">
                    <div class="alert ${param.msg.equals("200")?"alert-success":"alert-danger"} alert-dismissable">
                        <button type="button" class="close" data-dismiss="alert"
                                aria-hidden="true">
                            &times;
                        </button>
                            ${param.msg.equals("200")?"发布成功":"发布失败"}
                    </div>
                </c:if>
            </div>
        </div>
        <div class="col-sm-10 col-sm-offset-1">
            <form class="form-horizontal" role="form" action="/admin/product/add" method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="select">商品类别</label>
                    <select class="form-control" id="select" name="cid">
                        <c:forEach items="${cList}" var="item">
                            <option value="${item.id}">${item.cname}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="name">名称</label>
                    <input type="text" class="form-control" id="name" name="pname" placeholder="请输入名称">
                </div>
                <div class="form-group">
                    <label for="value">商品价格</label>
                    <input type="text" class="form-control" id="value" name="pvalue" placeholder="请输入价格">
                </div>
                <div class="form-group">
                    <label for="inputfile">商品图片</label>
                    <input type="file" id="inputfile" name="img">
                </div>
                <div class="form-group">
                    <label for="textarea">商品信息</label>
                    <textarea class="form-control" id="textarea" name="describe" rows="3"></textarea>
                </div>
                <button type="submit" class="btn btn-info">提交</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
