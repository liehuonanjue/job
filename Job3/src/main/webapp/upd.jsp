<%--
  Created by IntelliJ IDEA.
  User: 齐亮
  Date: 2018/10/9
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/css/public.css"/>
    <link rel="stylesheet" href="/css/style.css"/>
    <link rel="stylesheet" href="/css/bootstrap.min.css"/>
    <style type="text/css">
        table th, tr, td {
            align-content: center;
            text-align: center;
        }

        table {
            width: 500px;
        }

        .salelist {
            float: right;
            border: none;
        }

        .salelist a {
            color: red;
        }

    </style>
    <script type="text/javascript" src="/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">

        var sj = /^\d{4}\-\d{1,2}\-\d{1,2}$/;

        function addsale() {
            if ($("[name=title]").val() == "") {
                alert("图书名称不能为空！");
                return;
            } else if (!sj.test($("[name=cretedate]").val())) {
                alert("时间格式不对！");
                return;
            } else {
                add()
            }
        }

        function add() {
            $.ajax({
                type: "POST",
                url: "/Operation/upd",
                dataType: "text",
                data: {
                    id: ${selid.id},
                    title: $("[name=title]").val(),
                    summary: $("[name=summary]").val(),
                    uploaduser: $("[name=uploaduser]").val(),
                    aa: $("[name=cretedate]").val()
                },
                success: function (data) {
                    alert(data)
                    if (data == "true") {
                        alert("修改成功");
                        window.location.href = "/index.jsp"
                    } else {
                        alert("修改失败");
                        window.location.href = "/upd.jsp"
                    }
                }
            });

        }

    </script>
</head>
<body>
<h4>更新电子图书</h4>
<p>图书编号： ${selid.id}</p>
<p>图书名称 ：<input type="text" name="title" value="${selid.title}"></p>
<p>图书摘要 ：<input type="text" name="summary" value="${selid.summary}"></p>
<p>上传人 ：<input type="text" name="uploaduser" value="${selid.uploaduser}"></p>
<p>上传时间 ：<input type="text" name="cretedate" value="${selid.datetime}"></p>
<input type="button" value="提交" onclick="addsale()">
<input type="button" href="#" onclick="javascript:history.go(-1);" value="返回"/>
</body>
</html>
