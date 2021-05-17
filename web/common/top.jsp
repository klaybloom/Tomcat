<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="row clearfix">
    <div class="col-md-12 column">
        <nav class="navbar navbar-default navbar-static-top navbar-inverse" role="navigation">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1"><span
                        class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span
                        class="icon-bar"></span><span class="icon-bar"></span></button>
                <a class="navbar-brand" href="<%=application.getContextPath()%>">尚马教育</a>
            </div>

            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="">
                        <a href="<%=application.getContextPath() %>/user/list">用户列表</a>
                    </li>
                    <li>
                        <a href="#">图书列表</a>
                    </li>
                    <li>
                        <a href="#">省市级联</a>
                    </li>
                    <li>
                        <a href="#">商品列表</a>
                    </li>

                </ul>
                <ul class="nav navbar-nav navbar-right">

                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">admin
                            <strong class="caret"></strong>
                        </a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="#">个人信息</a>
                            </li>
                            <li>
                                <a href="#">修改密码</a>
                            </li>
                            <li>
                                <a href="#">退出登录</a>
                            </li>
                            <li class="divider">
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#">&nbsp;</a>
                    </li>
                </ul>
            </div>

        </nav>
    </div>
</div>