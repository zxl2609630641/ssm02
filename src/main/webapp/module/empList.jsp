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
</head>
<body>
<a href="${path}/module/insertEmp.jsp">新增</a>
<table>
    <tr>
        <td>id</td>
        <td>姓名</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${list}" var="emp">
        <tr>
            <td>${emp.employeeid}</td>
            <td>${emp.employeename}</td>
            <td>
                <a href="${path}/emp/selectEmpById?id=${emp.employeeid}">修改</a>
                <a href="${path}/emp/deleteEmp?id=${emp.employeeid}">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
