<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>分页查询</title>
    <%@include file="common/comm.jsp" %>

</head>
<body>
<div class="container">
    <%@include file="common/top.jsp" %>
    <div class="row">
        <div class="col-md-12">
        <table class="table-bordered table ">
            <thead>
            <tr>
                <th>序列号</th>
                <th>视频id</th>
                <th>视频标题</th>
                <th>导演</th>
                <th>演员</th>
                <th>标签</th>
                <th>地区</th>
                <th>语言</th>
            </tr>
            </thead>
            <tbody id="videolist">


            </tbody>
        </table>
        </div>
    </div>
    <div class="row">
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <input type="text" class="hidden" value="1" id="pageNum">
                <li>
                    <a href="javascript:jump(1)" aria-label="index">
                        <span aria-hidden="true">首页</span>
                    </a>
                </li>
                <li>
                    <a href="javascript:prev()" aria-label="Previous">
                        <span aria-hidden="true">上一页</span>
                    </a>
                </li>
                <li><a href="javascript:jump(1)">1</a></li>
                <li><a href="javascript:jump(2)">2</a></li>
                <li><a href="javascript:jump(3)">3</a></li>
                <li><a href="javascript:jump(4)">4</a></li>
                <li><a href="javascript:jump(5)">5</a></li>
                <li>
                    <a href="javascript:next()" aria-label="Next">
                        <span aria-hidden="true">下一页</span>
                    </a>
                </li>
                <li>
                    <span>
                    <select  id="size" onchange="change()">
                        <option value="10">10</option>
                        <option value="20">20</option>
                        <option value="50">50</option>
                    </select>
                        </span>
                </li>
            </ul>
        </nav>
    </div>
</div>
<script type="text/javascript">
    $(function () {
        change();

    })
    //下一页
    function  prev() {
        var page = parseInt($('#pageNum').val());
        // 判断是否为首页
        if(page!=1){
        page-=1;
        }
        jump(page);
    }
    //下一页
    function  next() {
       var page = parseInt($('#pageNum').val());
           //TODO 判断是否为末页
        if(true){
       page+=1;
   }
        jump(page);
    }
    //跳转页面
    function jump(page) {
          $('#pageNum').val(page);
          console.log($('#pageNum').val());
        var size = $('#size option:selected').val();
          query(page,size)
    }
//更改每页显示数量
    function change() {
            var pageNum=parseInt( $('#pageNum').val());
           var size = $('#size option:selected').val();
             query(pageNum,size);
    }
    function query(pageNum,size){
        var url="servlet/videopage";
        var param={
            "pageNum":pageNum,
            "size":size
        }
        $.getJSON(url,param,function (videoElements) {
            var html="";
            $.each(videoElements,function (i,v) {
                html+="<tr>"+
                        "<td>"+v.id+"</td>"+
                        "<td>"+v.vid+"</td>"+
                        "<td>"+v.title+"</td>"+
                        "<td>"+v.directors+"</td>"+
                        "<td>"+v.actors+"</td>"+
                        "<td>"+v.tags+"</td>"+
                        "<td>"+v.area+"</td>"+
                        "<td>"+v.language+"</td>"+
                        "</tr>";

            })
           $ ('#videolist').html(html)
        })
    }
</script>
</body>
</html>
