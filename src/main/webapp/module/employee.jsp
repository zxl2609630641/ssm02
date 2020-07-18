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
<input type="button" value="新增" class="btn btn-info" id="addBtn"/>
<table border="1" style="width: 550px" class="table table-bordered table-hover table-striped">
    <tr class="warning">
        <td>序号</td>
        <td>员工姓名</td>
        <td>员工部门</td>
        <td>员工性别</td>
        <td>员工年龄</td>
        <td>员工电话</td>
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
                <h4 class="modal-title" id="myModalLabel">员工修改/新增</h4>
            </div>
            <div class="modal-body">
                <form class="form" id="forminfo">
                    <input type="hidden" id="employeeid" name="employeeid"/>
                    <div class="form-group">
                        <label for="employeename">员工姓名：</label>
                        <input type="text" class="form-control" name="employeename" id="employeename">
                    </div>
                    <div class="form-group">
                        <label for="departmentid">部门：</label>
                        <select class="form-control" name="departmentid" id="departmentid">
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="employeesex">员工性别：</label>
                        <input type="text" class="form-control" name="employeesex" id="employeesex">
                    </div>
                    <div class="form-group">
                        <label for="employeeage">员工年龄：</label>
                        <input type="text" class="form-control" name="employeeage" id="employeeage">
                    </div>
                    <div class="form-group">
                        <label for="employeephone">员工电话：</label>
                        <input type="text" class="form-control" name="employeephone" id="employeephone">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" id="saveBtn" class="btn btn-primary">保存</button>
            </div>
        </div>
    </div>
</div>
<script>
    $.ajax({
        url: "${path}/restEmp/Emp",
        data: {},
        dataType: "json",
        type: "get",
        success: function (data) {
            console.log(data);
            for (var i = 0; i < data.length; i++) {
                var emp = data[i];
                var html = "<tr class='success'>\n" +
                    "            <td>" + emp.employeeid + "</td>\n" +
                    "            <td>" + emp.employeename + "</td>\n" +
                    "            <td>" + emp.departmentname + "</td>\n" +
                    "            <td>" + emp.employeesex + "</td>\n" +
                    "            <td>" + emp.employeeage + "</td>\n" +
                    "            <td>" + emp.employeephone + "</td>\n" +
                    "            <td>" +
                    "               <input type=\"button\" class='btn-primary btn' id=\"" + emp.employeeid + "\" value=\"修改\"/>" +
                    "               <input type=\"button\" class='btn-primary btn' id=\"" + emp.employeeid + "\" value=\"删除\"/>" +
                    "            </td>\n" +
                    "        </tr>";
                $("#tbody").append(html);
            }
        }
    });
    $.ajax({
        url: "${path}/restEmp/Dept",
        data: {},
        dataType: "json",
        type: "get",
        success: function (data) {
            console.log(data);
            for (var i = 0; i < data.length; i++) {
                var dept = data[i];
                var html = "<option value=\"" + dept.departmentid + "\">" + dept.departmentname + "</option>";
                $("#departmentid").append(html);
            }
        }
    });

    //多条新增
    <%--$("#addBtn").click(function () {--%>
    <%--window.location.href="${path}/module/insertEmp.jsp";--%>
    <%--})--%>
    $("#addBtn").click(function () {
        $("#employeeid").val("");
        $("#forminfo").get(0).reset();
        $("#empInfo").modal('show');
    });
    $("#tbody").on("click", "input[value='修改']", function () {
        var id = this.id;
        $.ajax({
            url: "${path}/restEmp/" + id,
            data: {},
            dataType: "json",
            type: "get",
            success: function (data) {
                console.log(data);
                $("#employeeid").val(data.employeeid);
                $("#departmentid").val(data.departmentid);
                $("#employeename").val(data.employeename);
                $("#employeesex").val(data.employeesex);
                $("#employeeage").val(data.employeeage);
                $("#employeephone").val(data.employeephone);
                $("#empInfo").modal('show');
            }
        })
    });
    $("#saveBtn").click(function () {
        $.ajax({
            url: "${path}/restEmp",
            data: $("#forminfo").serialize(),
            dataType: "json",
            type: "post",
            success: function (data) {
                if (data.message == '修改成功') {
                    $("#empInfo").modal('hide');
                    window.location.href = "${path}/module/employee.jsp"
                } else if (data.message == '新增成功') {
                    $("#empInfo").modal('hide');
                    window.location.href = "${path}/module/employee.jsp"
                } else {
                    alert(data.message)
                }
            }
        })
    })
    $("#tbody").on("click", "input[value='删除']", function () {
        var id = this.id;
        $.ajax({
            url: "${path}/restEmp/" + id,
            data: {},
            dataType: "json",
            type: "delete",
            success: function () {
                window.location.reload();
            }
        })
    })
</script>
</body>
</html>
