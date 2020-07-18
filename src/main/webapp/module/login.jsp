<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zxl
  Date: 2020/3/29
  Time: 9:30
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
<input type="text" id="username"/>
<input type="text" id="password"/>

<input type="button" value="登录" id="saveBtn"/>
<script>
    $("#saveBtn").click(function () {
        $.ajax({
            url: "${path}/order/login",
            data: {
                username: $("#username").val(),
                password: $("#password").val()
            },//传递给控制层的参数
            dataType: "json",
            type: "post",
            success: function (data) {
                if (data.state) {
                    window.location.href = "${path}/module/order.jsp";
                } else {
                    alert(data.message);
                }
            }
        });
    })
</script>
</body>
</html>
