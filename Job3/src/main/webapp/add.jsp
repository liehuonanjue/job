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
        div {
            margin: 0 auto;
            width: 500px;
        }

        div h4 {
            background: #49ff4b;
            text-align: center;
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

        <%--时间的验证--%>
        var sj = /^\d{4}\-\d{1,2}\-\d{1,2}$/;

        //判断验证
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

        //添加
        function add() {
            $.ajax({
                type: "POST",
                url: "/Operation/ad",
                dataType: "text",
                data: {
                    categoryId: ${param.name},
                    title: $("[name=title]").val(),
                    summary: $("[name=summary]").val(),
                    uploaduser: $("[name=uploaduser]").val(),
                    Datetime: $("[name=cretedate]").val()
                },
                success: function (data) {
                    if (data == "true") {
                        alert("添加成功");
                        window.location.href = "/index.jsp"
                    } else {
                        alert("添加失败");
                        window.location.href = "/add.jsp"
                    }
                }
            });

        }

    </script>
</head>
<body>
<div>
    <h4>增加电子图书</h4>
    <p>图书名称 <input type="text" name="title"></p>
    <p>图书摘要 <input type="text" name="summary"></p>
    <p>上传人 <input type="text" name="uploaduser"></p>
    <p>上传时间 <input type="text" name="cretedate"></p>
    <p><input type="button" value="提交" onclick="addsale()">
        <input type="button" href="#" onclick="javascript:history.go(-1);" value="返回"/></p>
</div>

</body>
</html>
