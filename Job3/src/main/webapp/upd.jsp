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
    <%--<link rel="stylesheet" href="/css/public.css"/>--%>
    <%--<link rel="stylesheet" href="/css/style.css"/>--%>
    <%--<link rel="stylesheet" href="/css/bootstrap.min.css"/>--%>
    <style type="text/css">
        div {
            margin: 0 auto;
            width: 500px;
        }

        div h4 {
            background: #49ff4b;
        }

        span {
            width: 100px;
            border-right: 1px #000000 solid;
        }

        div p input {
            border-left: 1px #000000 solid;
            width: 400px;
        }

        div p, h4 {
            margin: 0px;
            padding: 0px;
            width: 500px;
            border: 1px #000000 solid;
            height: 36px;
            line-height: 40px;
        }

        .bu {
            width: 40px;
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
                    Datetime: $("[name=cretedate]").val()
                },
                success: function (data) {
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
<div>
    <h4>更新电子图书</h4>
    <p><span>图书编号：</span> ${selid.id}</p>
    <p><span></span>图书名称：<input type="text" name="title" value="${selid.title}"></p>
    <p><span>图书摘要：</span><input type="text" name="summary" value="${selid.summary}"></p>
    <p><span>&nbsp;&nbsp;上传人&nbsp;&nbsp;：</span><input type="text" name="uploaduser" value="${selid.uploaduser}"></p>
    <p><span>上传时间 ：</span><input type="text" name="cretedate" value="${selid.datetime}"></p>
    <p>
        <input type="button" value="提交" class="bu" onclick="addsale()">
        <input type="button" class="bu" onclick="javascript:history.go(-1);" value="返回"/></p>
</div>

</body>
</html>
