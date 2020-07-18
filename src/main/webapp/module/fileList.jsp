<%--
  Created by IntelliJ IDEA.
  User: zxl
  Date: 2020/4/14
  Time: 11:06
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
    <!--所有的静态文件不应该被核心控制器进行处理-->
    <script src="${path}/resources/jquery-2.1.3.js"></script>
    <title>Title</title>
    <script>
        $().ready(function () {
            $.ajax({
                url: "${path}/file/selectFile",
                data: {},
                type: "get",
                dataType: "json",
                success: function (data) {
                    for (var i = 0; i < data.length; i++) {
                        var fileInfo = data[i];
                        var html = "<tr>\n" +
                            "            <td>" + (i + 1) + "</td>\n" +
                            "            <td>" + fileInfo.filename + "</td>\n" +
                            "            <td><a href='${path}/file/download?fileid=" + fileInfo.fileid + "'>下载</a></td>\n" +
                            "        </tr>";
                        $("#tb").append(html);
                    }
                }
            });


        });
    </script>
</head>
<body>

<table>
    <tr>
        <td>序号</td>
        <td>名称</td>
        <td>操作</td>
    </tr>
    <tbody id="tb">

    </tbody>
</table>

</body>
</html>
