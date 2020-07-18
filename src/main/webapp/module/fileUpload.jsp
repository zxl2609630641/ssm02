<%--
  Created by IntelliJ IDEA.
  User: zxl
  Date: 2020/4/13
  Time: 16:20
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
<form action="${path}/file/fileUploadMore" method="post" enctype="multipart/form-data">
    <input type="file" name="filename1"/>
    <input type="file" name="filename1"/>
    <input type="submit" value="上传"/>
</form>
</body>
</html>
