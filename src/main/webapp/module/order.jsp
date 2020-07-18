<%--
  Created by IntelliJ IDEA.
  User: zxl
  Date: 2020/3/31
  Time: 13:12
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
<table border="1" style="width: 800px" class="table table-bordered table-hover table-striped">
    <tr class="warning">
        <td>序号</td>
        <td>会员id</td>
        <td>会员电话</td>
        <td>会员等级</td>
        <td>订单金额</td>
        <td>实际消费</td>
        <td>支付方式</td>
        <td>操作</td>
    </tr>
    <tbody id="tbody">

    </tbody>
</table>

<div class="modal fade" id="empInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">查询订单详情</h4>
            </div>
            <div class="modal-body">
                <form class="form" id="forminfo">
                    <input type="hidden" id="orderdetailid" name="orderdetailid"/>
                    <div class="form-group">
                        <label for="productname">商品名称：</label>
                        <input type="text" class="form-control" name="productname" id="productname">
                    </div>
                    <div class="form-group">
                        <label for="productsize">商品尺寸：</label>
                        <input type="text" class="form-control" name="productsize" id="productsize">
                    </div>
                    <div class="form-group">
                        <label for="productcolor">商品颜色：</label>
                        <input type="text" class="form-control" name="productcolor" id="productcolor">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>


<script>
    $.ajax({
        url: "${path}/order",
        data: {},
        dataType: "json",
        type: "get",
        success: function (data) {
            console.log(data);
            for (var i = 0; i < data.length; i++) {
                var ord = data[i];
                var html = "<tr class='success'>\n" +
                    "            <td>" + ord.orderid + "</td>\n" +
                    "            <td>" + ord.vipid + "</td>\n" +
                    "            <td>" + ord.vipphone + "</td>\n" +
                    "            <td>" + ord.vipclass + "</td>\n" +
                    "            <td>" + ord.ordermoney + "</td>\n" +
                    "            <td>" + ord.realmoney + "</td>\n" +
                    "            <td>" + ord.receiptway + "</td>\n" +
                    "            <td>" +
                    "               <input type=\"button\" class='btn-primary btn' id=\"" + ord.orderid + "\" value=\"查询详情\"/>" +
                    "               <input type=\"button\" class='btn-primary btn' id=\"" + ord.orderid + "\" value=\"修改订单\"/>" +
                    "            </td>\n" +
                    "        </tr>";
                $("#tbody").append(html);
            }
        }
    });
    $("#tbody").on("click", "input[value='查询详情']", function () {
        var id = this.id;
        $.ajax({
            url: "${path}/order/" + id,
            data: {},
            dataType: "json",
            type: "get",
            success: function (data) {
                console.log(data);
                $("#productname").val(data.productname);
                $("#productcolor").val(data.productcolor);
                $("#productsize").val(data.productsize);
                $("#orderdetailid").val(data.orderdetailid);
                $("#empInfo").modal('show');
            }
        })
    });
</script>
</body>
</html>
