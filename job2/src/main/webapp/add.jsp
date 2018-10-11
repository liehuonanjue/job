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
            $.ajax({
                type: "POST",
                url: "/Operation/add",
                data: {
                    invaid: ${errorStr},
                    content: content,
                    autohor: autohor
                },
                dataType: "txt",
                success: function (data) {
                    alert(data)
                    console.log(data)
                }
            });
        }

    </script>
</head>
<body>
<h4>添加回复</h4>
<p>回复内容 <textarea name="content" rows="3" cols="20">
</textarea>
<p>回复名称<input type="text" name="autohor"/></p>
<input type="button" onclick="add()" value="提交"/>
</body>
</html>
