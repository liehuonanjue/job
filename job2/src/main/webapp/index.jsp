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

    </style>
    <script type="text/javascript" src="/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        $(function () {
            load(0);
        });

        function de(idd) {
            if(confirm("确定删除吗？")){
                $.ajax({
                    url: "/Operation/delete",
                    type: "post",
                    data: {"uid": idd},
                    dataType: "text",
                    success: function (data) {
                        alert(data)
                        if (data == "true") {
                            alert("删除成功");
                            window.location.href = "index.jsp"
                        } else {
                            alert("删除失败");
                            window.location.href = "index.jsp"
                        }
                    }
                })
            }

        }

        var pageNume = null
        var pages = 1;

        function load(pageNum) {
            var order = $("[name=order]").val();
            if (pageNum < 0) {   //当前页数小于0的时候
                alert("已经不能在小了")
                ++pageNume
            }
            else if (pages + 1 == pageNume) { //当前页数大于最大的时候
                alert("已经不能在大了")
                --pageNume
            }
            else {
                $.ajax({
                    url: "/sale/salelist",
                    type: "post",
                    data: {"order": order, "pageNum": pageNum},   //带条件和页数
                    dataType: "JSON",
                    success: function (data) {
                        pageNum = data.pageNum;  //当前页数
                        pages = data.pages - 1;  // 页数总共有两个 可从0开始所以减一
                        $("#list-content").html('');        //清空数据
                        //追加数据
                        $.each(data.list, function (i, dom) {
                            //一个dom就是一个对象
                            $("#list-content").append("<tr><td>" + dom.title + "</td><td>" + dom.summary + "</td><td>" + dom.author + "</td><td>" + dom.datetime + "</td><td>" +
                                "<a href='/sale/SaleReply?order=" + dom.id + "' >查看回復</a>&nbsp;&nbsp;" +
                                "<a onclick='javascript:de(" + dom.id + ")' > 刪除 </a>" +
                                "</td >< /tr>");
                        });

                        $(' #tab tr:even').css("backgroundColor", "#b2ff00");
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
            <tr aria-colcount="2">
                <th height="50">帖子标题</th>
            </tr>
            <tr>
                <th>
                    帖子标题：
                    <input type="text" class="form-control" name="order">
                    <input type="button" class="btn btn-default" value="查询" onclick="javascript:load(0)"/></th>
                </h4>
            </tr>
        </table>
        <table id="tab" align="center" border="2px">

            <tr>
                <th>标题</th>
                <th>内容</th>
                <th>作者</th>
                <th>发布时间</th>
                <th>操作</th>
            </tr>
            <tbody id="list-content">

            </tbody>

        </table>
        <div class="pagination" id="pagination"></div>
    </div>
<span class="ded"></span>
</div>


</body>
</html>
