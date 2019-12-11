<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户管理</title>
    <jsp:include page="/page/includes/head.jsp"/>
    <style>
        #modal-body{
            height: 400px;
        }
    </style>
</head>
<body>
<div style="padding:0 50px">
    <jsp:include page="/page/includes/adminNav.jsp">
        <jsp:param name="index" value="2"/>
    </jsp:include>
    <div style="float: left;width: 85%;">
        <jsp:include page="/page/includes/adminTop.jsp">
            <jsp:param name="topname" value="商品管理"/>
        </jsp:include>
        <div class="col-sm-10 col-sm-offset-1">
            <div class="row">
                <table class="table table-striped table-bordered table-hover">
                    <thead>
                    <tr>
                        <th>id</th>
                        <th>商品名称</th>
                        <th>商品类别</th>
                        <th>商品价格</th>
                        <th>详细信息</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${pduList}" var="item" >
                        <tr>
                            <td>${item.id}</td>
                            <td>${item.pname}</td>
                            <td>${item.cname}</td>
                            <td>${item.pvalue}</td>
                            <td><button class="btn btn-default" onclick="showModal(${item.id},'${item.pname}','${item.cname}',${item.pvalue},'${item.pimg}','${item.describe}')">查看信息</button>
                                <a href="/admin/pdu/delete?id=${item.id}" class="btn btn-danger">删除</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    详细信息
                </h4>
            </div>
            <div class="modal-body" id="modal-body">
                <div class="col-sm-10 col-sm-offset-1">
                    <div class="row">
                        <label for="pname" class="col-sm-3 control-label">商品名称</label>
                        <div class="col-sm-7">
                            <span id="pname"></span>
                        </div>
                    </div>
                    <div class="row">
                        <label for="pid" class="col-sm-3 control-label">商品id</label>
                        <div class="col-sm-7">
                            <span id="pid"></span>
                        </div>
                    </div>
                    <div class="row">
                        <label for="cname" class="col-sm-3 control-label">商品类别</label>
                        <div class="col-sm-7">
                            <span id="cname"></span>
                        </div>
                    </div>
                    <div class="row">
                        <label for="pvalue" class="col-sm-3 control-label">商品价格</label>
                        <div class="col-sm-7">
                            <span id="pvalue"></span>
                        </div>
                    </div>
                    <div>
                        <div class="row">
                            <label class="col-sm-3 control-label">商品图片</label>
                        </div>
                        <div class="row">
                            <div class="col-sm-7">
                                <a href="#" class="thumbnail" id="pimg">

                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <label for="describe" class="col-sm-3 control-label">商品描述</label>
                        <div class="col-sm-7">
                            <span id="describe"></span>
                        </div>
                    </div>
                </div>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">
                    关闭
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<script>
    function showModal(id,pname,cname,pvalue,img,describe){
        $('#pname').html(pname);
        $('#pid').html(id);
        $('#pvalue').html(pvalue);
        $('#pimg').html("<img src='"+img+"' alt='商品图片'>");
        $('#cname').html(cname);
        $('#describe').html(describe);
        $('#myModal').modal('show')
    }
</script>
</body>
</html>
