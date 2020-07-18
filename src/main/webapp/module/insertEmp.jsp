<%--
  Created by IntelliJ IDEA.
  User: zxl
  Date: 2020/3/29
  Time: 10:11
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
<input type="text" id="employeename"/>
<input type="text" id="employeephone"/>
<input type="text" id="employeeage"/><br>
<%--<input type="text" id="employeename1"/>--%>
<%--<input type="text" id="employeephone1"/>--%>
<%--<input type="text" id="employeeage1"/>--%>
<input type="button" value="保存" id="saveBtn"/>
</body>
<script>
    $("#saveBtn").click(function () {
        // var jsonArray=new Array();
        // var emp={employeename:$("#employeename").val(),
        //     employeephone:$("#employeephone").val(),
        //     employeeage:$("#employeeage").val()};
        // var emp2={employeename:$("#employeename1").val(),
        //     employeephone:$("#employeephone1").val(),
        //     employeeage:$("#employeeage1").val()};
        // jsonArray.push(emp);
        // jsonArray.push(emp2);
        <%--$.ajax({--%>
        <%--url:"${path}/empAjax/insertEmpMore",--%>
        <%--data:JSON.stringify(jsonArray),//传递给控制层的参数--%>
        <%--contentType:"application/json",//请求类型：json类型--%>
        <%--dataType:"json",--%>
        <%--type:"post",--%>
        <%--success:function(datainfo){--%>
        <%--datainfo就是返回值，返回值是json——请求的返回值——controller的返回值--%>
        <%--Servlet:out.print(json字符串)--%>
        <%--console.log(datainfo);--%>
        <%--window.location.href="${path}/module/employee.jsp";--%>
        <%--}--%>
        <%--})--%>
        $.ajax({
            url: "${path}/empAjax/insertEmp",
            data: {
                employeename: $("#employeename").val(),
                employeephone: $("#employeephone").val(),
                employeeage: $("#employeeage").val()
            },
            dataType: "json",
            type: "post",
            success: function () {
                window.location.href = "${path}/module/employee.jsp"
            }
        })

    })
</script>
</html>
