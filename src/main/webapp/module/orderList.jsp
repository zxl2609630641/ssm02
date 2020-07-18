<%--
  Created by IntelliJ IDEA.
  User: zxl
  Date: 2020/4/12
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%
    String path = request.getContextPath();
    request.setAttribute("path", path);
%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${path}/resources/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="${path}/resources/bootstrap/css/bootstrap-theme.css">
    <script src="${path}/resources/jquery-2.1.3.js"></script>
    <script src="${path}/resources/bootstrap/js/bootstrap.js"></script>
</head>
<body>
<div class="modal-body">
    <form class="form" id="forminfo">
        <div class="form-group">
            <label for="vipphone">会员电话：</label>
            <input type="text" class="form-control" name="vipphone" id="vipphone">
        </div>
        <div class="form-group">
            <label for="vipname">会员姓名：</label>
            <input type="text" class="form-control" name="vipname" id="vipname">
        </div>
        <div class="form-group">
            <label for="vipmoney">会员余额：</label>
            <input type="text" class="form-control" name="vipmoney" id="vipmoney">
        </div>
    </form>
</div>

<div class="modal-body">
    <form class="form" id="forminfo2">
        <input type="hidden" id="productid" name="productid">
        <div class="form-group">
            <label for="productname">商品名称：</label>
            <select class="form-control" name="productname" id="productname">
            </select>
        </div>
        <div class="form-group">
            <label for="productcolor">商品颜色：</label>
            <input type="text" class="form-control" name="productcolor" id="productcolor">
        </div>
        <div class="form-group">
            <label for="productsize">商品尺寸：</label>
            <input type="text" class="form-control" name="productsize" id="productsize">
        </div>
        <div class="form-group">
            <label for="productprice">商品价格：</label>
            <input type="text" class="form-control" name="productprice" id="productprice">
        </div>
        <div class="form-group">
            <label for="number">商品数量：</label>
            <input type="text" class="form-control" name="number" id="number">
        </div>
        <div class="form-group">
            <label for="ordermoney">总金额：</label>
            <input type="text" class="form-control" name="ordermoney" id="ordermoney">
        </div>
        <input type="button" value="提交订单" id="saveBtn">
    </form>
</div>
<script>
    $("#vipphone").blur(function () {
        $.ajax({
            url: "${path}/order/vip",
            data: {vipphone: $("#vipphone").val()},
            dataType: "json",
            type: "get",
            success: function (data) {
                console.log(data);
                $("#vipname").val(data[0].vipname);
                $("#vipmoney").val(data[0].vipmoney);
            }
        })
    });
    $.ajax({
        url: "${path}/order/product",
        data: {},
        dataType: "json",
        type: "get",
        success: function (data) {
            for (var i = 0; i <= data.length; i++) {
                var pro = data[i];
                var html = "<option value=\"" + pro.productid + "\">" + pro.productname + "</option>";
                $("#productname").append(html);
            }
        }
    });
    $("#productname").change(function () {
        var productid = $("#productname").val();
        $.ajax({
            url: "${path}/order/pro",
            data: {productid: productid},
            dataType: "json",
            type: "get",
            success: function (data) {
                console.log(data);
                $("#productsize").val(data.productsize);
                $("#productcolor").val(data.productcolor);
                $("#productprice").val(data.productprice);
            }
        })
    });
    $("#saveBtn").click(function () {
        var vipphone = $("#vipphone").val();
        var vipname = $("#vipname").val();
        var vipmoney = $("#vipmoney").val();
        var ordermoney = $("#productprice").val() * $("#number").val();
        $.ajax({
            url: "${path}/order/saveorder",
            data: {},
        })
    })
</script>
</body>
</html>
