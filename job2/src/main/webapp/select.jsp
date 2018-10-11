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
        $(function () {
            load(0);
        });
        var pageNume = 0
        var pages = 1;

        function load(pageNum) {
            if (pageNum < 0) {   //当前页数小于0的时候
                alert("已经不能在小了")
                ++pageNume
            } else if (pages + 1 == pageNume) { //当前页数大于最大的时候
                alert("已经不能在大了")
                --pageNume
            }
            else {
                $.ajax({
                    url: "/sale/selec",
                    type: "post",
                    data: {"order":${errorStr}, "pageNum": pageNum},   //带条件和页数
                    dataType: "Json",
                    success: function (data) {
                        console.log(data);
                        console.log(data.list);
                        pageNum = data.pageNum;  //当前页数
                        pages = data.pages - 1;  // 页数总共有两个 可从0开始所以减一
                        //清空数据
                        $("#list-content").html('');
                        //追加数据
                        $.each(data.list, function (i, dom) {
                            //一个dom就是一个对象
                            $("#list-content").append("<tr><td>" + dom.content + "</td><td>" + dom.autohor + "</td><td>" + dom.datetime + "</td></tr>");
                        });

                        $('#tab tr:even').css("backgroundColor", "#b2ff00");
                        $('#tab tr:odd').css("backgroundColor", "#00ffd3");
                        $('#tab tr:first').css("backgroundColor", "#feff00");
                        //渲染分页  总记录数  当前页码  每页数据量
                        $('#pagination').html(
                            "<a onclick=\"javascript:load(pageNume=0 )\">首页</a><a onclick='javascript:load(--pageNume)'>上一页</a>" +
                            "<a onclick=\"javascript:load(++pageNume)\">下一页</a><a onclick=\"javascript:load(pageNume=pages)\">尾页</a>"
                        )
                        ;
                    }
                });

            }
        }


    </script>
</head>
<body>
<div align="center">
    <div id="salelist" align="center">
        <table align="center" border="2px">
            <tr>
                <th height="60px"><h3>回复信息内容</h3></th>
            </tr>
            <tr>
                <td class="salelist">
                    <a href="/add.jsp">添加回复</a>
                    <a href="/index.jsp">返回帖子列表</a>
                </td>
            </tr>

        </table>
        <table id="tab" align="center" border="2px">
            <tr>
                <td>回复内容</td>
                <td>回复名称</td>
                <td>发布时间</td>
            </tr>
            <tbody id="list-content">

            </tbody>

        </table>
        <div class="pagination" id="pagination"></div>
    </div>

</div>


</body>
</html>
