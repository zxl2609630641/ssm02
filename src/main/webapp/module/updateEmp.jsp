<%--
  Created by IntelliJ IDEA.
  User: zxl
  Date: 2020/3/29
  Time: 10:41
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
</head>
<body>
<form action="${path}/emp/updateEmp" method="post">
    <input type="hidden" name="id" value="${emp.employeeid}">
    <input type="text" name="name" value="${emp.employeename}">
    <input type="submit" value="修改">
</form>
</body>
</html>
