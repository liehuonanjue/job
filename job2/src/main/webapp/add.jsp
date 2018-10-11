<%--
  Created by IntelliJ IDEA.
  User: 齐亮
  Date: 2018/10/11
  Time: 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/css/public.css"/>
    <link rel="stylesheet" href="/css/style.css"/>
    <link rel="stylesheet" href="/css/bootstrap.min.css"/>
    <script type="text/javascript" src="/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        function add() {
            var content = $("[name=content]").val();
            var autohor = $("[name=autohor]").val();
            if (content == "") {
                alert("请添加回复内容！");
                return
            }
            else {
                if (autohor == ""){
                    autohor="匿名用户";
                }
                $.ajax({
                    type: "POST",
                    url: "/Operation/ad",
                    data: {
                        invaid: ${errorStr},
                        content: content,
                        autohor: autohor
                    },
                    dataType: "text",
                    success: function (data) {
                        if (data == "true") {
                            alert("添加成功");
                            window.location.href = "index.jsp"
                        } else {
                            alert("添加失败");
                            window.location.href = "add.jsp"
                        }
                    }
                });

            }
        }

    </script>
</head>
<body>
<h4>添加回复</h4>
<p>回复内容 <textarea name="content" rows="3" cols="20">
</textarea>
<p>回复名称<input type="text" name="autohor" value=""/></p>
<input type="button" onclick="add()" value="提交"/>
<input type="button" href="#" onclick="javascript:history.go(-1);" value="返回"/>
<form action="/sale/insertSale" method="post" onsubmit="return addsale()">
</body>
</html>
