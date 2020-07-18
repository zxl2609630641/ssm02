<%--
  Created by IntelliJ IDEA.
  User: zxl
  Date: 2020/4/12
  Time: 21:43
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
    <script src="${path}/resources/jquery-2.1.3.js"></script>
</head>
<body>
error-busi异常---${exception}
</body>
</html>
