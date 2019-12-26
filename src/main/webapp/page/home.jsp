<%--
  User: Jayce
  Date: 2019/10/13
  Time: 20:51
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
<%--    <meta name="viewport" content="width=device-width,initial-scale=1.0,user-scalable=0">--%>
    <title>首页</title>
    <script src="${pageContext.request.contextPath}/js/jquery/jquery.min.js"></script>
    <%--    <link href="../css/semanticUI/semantic.min.css" rel="stylesheet">--%>
    <link href="https://cdn.bootcss.com/semantic-ui/2.4.1/semantic.min.css" rel="stylesheet">
    <%--  <script src="https://cdn.bootcss.com/semantic-ui/2.4.1/semantic.min.js"></script>--%>
    <script src="${pageContext.request.contextPath}/js/semanticUI/semantic.min.js"></script>
    <link href="${pageContext.request.contextPath}/css/me/myCss.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/me/myScript.js"></script>

</head>
<body>

<input type="hidden" id="RootPath" value="${pageContext.request.contextPath}"/>

<%--导航栏--%>
<nav class="ui inverted attached segment">
    <div class="ui container">
        <div class="ui inverted secondary menu stackable">
            <c:choose>
                <c:when test="${login_state == 1}">
                    <h2 class="ui teal header" style="margin: 0 1em 0 1em;">${user.name}</h2>
                </c:when>
                <c:otherwise>
                    <h2 class="ui teal header" style="margin: 0 1em 0 1em;">Jayce</h2>
                </c:otherwise>
            </c:choose>
            <a href="#" class="item m-hide m-mobile-hide"><i class="home icon"></i>首页</a>
            <a href="#" class="item m-hide m-mobile-hide"><i class="idea icon"></i>分类</a>
            <a href="#" class="item m-hide m-mobile-hide"><i class="tags icon"></i>标签</a>
            <a href="#" class="item m-hide m-mobile-hide"><i class="clone icon"></i>归档</a>
            <a href="#" class="item m-hide m-mobile-hide"><i class="info icon"></i>关于</a>
            <div class="right item m-hide m-mobile-hide" style="padding: 0">
            <%--<div class="ui icon inverted transparent input">--%>
            <%--    <input type="text" placeholder="在这里搜索......">--%>
            <%--    <i class="search link icon"></i>--%>
            <%--</div>--%>
                <c:choose>
                    <c:when test="${login_state == 1}">
                        <div class="ui">
                            <a class="item" href="${pageContext.request.contextPath}/DropServlet"><i class="sign-out icon"></i>退出</a>
                        </div>
                    </c:when>
                    <c:when test="${login_state == 0}">
                        <div class="ui">
                            <button class="ui olive button inverted" onclick="login()">登录</button>
                            <i class="chess king icon"></i>
                            <button class="ui olive button inverted" onclick="register()">注册</button>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="ui">
                            <button class="ui olive button inverted" onclick="login()">登录</button>
                            <i class="chess king icon"></i>
                            <button class="ui olive button inverted" onclick="register()">注册</button>
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
    <a href="#" class="ui menu toggle black icon button m-right-top m-mobile-show">
        <i class="sidebar icon"></i>
    </a>
</nav>

<!--中间部分-->
<div style="padding: 1em 2em 4em 2em">
    <!--<div class="ui container">-->
    <div class="ui stackable grid">
        <!--博客部分-->
        <div class="twelve wide column">

            <!--头部-->
            <div class="ui top attached segment">
                <div class="ui middle aligned two column grid">
                    <div class="column">
                        <h3 class="ui teal header">个人主页</h3>
                    </div>
                </div>
            </div>

            <!--中间内容-->
            <div class="ui attpadded attached segment">
                <div class="ui grid" style="padding: 1em">
                    <div class="six wide column">
                        <div class="ui link cards">
                            <div class="card">
                                <div class="image">
                                    <img src="${pageContext.request.contextPath}/img/touxiang.jpg">
                                </div>
                                <div class="content">
                                    <div class="header">
                                        <c:choose>
                                            <c:when test="${login_state == 1}">
                                                ${user.name}
                                            </c:when>
                                            <c:otherwise>
                                                暂无信息
                                            </c:otherwise>
                                        </c:choose>
                                    </div>
                                </div>
                                <div class="extra content">
							      <span class="right floated">
							        Joined in 2017
							      </span>
                                    <span>
							        <i class="user icon"></i>
							        66 Friends
							      </span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="ten wide column">
                        <div class="ui divided items">
                            <div class="item">
                                <div class="middle aligned content">
                                    <i class="user icon"></i>
                                    <h3 class="ui header">介 绍：</h3>
                                </div>
                            </div>
                            <div class="item">
                                <div class="ui tiny image">
                                    <img src="${pageContext.request.contextPath}/img/me.jpg">
                                </div>
                                <div class="middle aligned content">
                                    <h3 class="ui header">学生：
                                        <c:choose>
                                            <c:when test="${login_state == 1}">
                                                ${user.realName}
                                            </c:when>
                                            <c:otherwise>
                                                暂无信息
                                            </c:otherwise>
                                        </c:choose>
                                    </h3>
                                    <p class="ui description">
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        <c:choose>
                                            <c:when test="${login_state == 1}">
                                                ${user.introduction}
                                            </c:when>
                                            <c:otherwise>
                                                暂无信息
                                            </c:otherwise>
                                        </c:choose>
                                    </p>
                                    <p class="ui description">
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;喜欢：
                                        <c:choose>
                                            <c:when test="${login_state == 1}">
                                                ${user.hobby}
                                            </c:when>
                                            <c:otherwise>
                                                暂无信息
                                            </c:otherwise>
                                        </c:choose>
                                    </p>
                                </div>
                            </div>
                            <div class="item">
                                <div class="ui tiny image">
                                    <img src="${pageContext.request.contextPath}/img/icon/hnust.jpg">
                                </div>
                                <div class="middle aligned content">
                                    <h3 class="ui header">湖南科技大学</h3>
                                    <p class="ui description">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;湖南科技大学肇始于解放前夕的湘北建设学院，2003年由湘潭工学院与湘潭师范学院合并组建而成，是湖南省人民政府与国家国防科技工业局共建高校、湖南省人民政府与原国家安全生产监督管理总局共建高校、“十三五”国家百所中西部高校基础能力建设工程支持高校、湖南省“国内一流大学建设高校”。</p>
                                </div>
                            </div>
                            <div class="item">
                                <div class="ui tiny image">
                                    <img src="${pageContext.request.contextPath}/img/icon/gis.png">
                                </div>
                                <div class="middle aligned content">
                                    <div class="middle aligned content">
                                        <h3 class="ui header">地理信息系统专业</h3>
                                        <p class="ui description">
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;地理信息系统（简称GIS）是近20年来新兴的一门集地理学、计算机、遥感技术和地图学于一体的边缘学科
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="ui attpadded attached segment">
                <div class="ui attpadded vertical segment" style="padding: 2em 1em 2em 1em">
                    <div class="ui stackable grid">
                        <div class="middle aligned three wide column">
                            <a href="#" target="_self">
                                <img src="${pageContext.request.contextPath}/img/icon/map1.png" class="ui rounded image">
                            </a>
                        </div>
                        <div class="thirteen wide column">
                            <h1 class="ui header">网页地图的制作</h1>
                            <p class="ui description">使用leaflet做了一些基本操作，能够切换地图</p>
                            <div class="ui grid">
                                <div class="middle eleven wide column">
                                    <div class="ui horizontal link list">
                                        <div class="item">
                                            <a href="#">
                                                <img src="${pageContext.request.contextPath}/img/touxiang.jpg" alt="" class="ui avatar image">
                                                <div class="content" style="display: inline-block">
                                                    <div class="ui header" style="opacity: 0.7;font-size: 14px;color: blueviolet">Jayce</div>
                                                </div>
                                            </a>
                                        </div>
                                        <div class="item aligned">
                                            <i class="calendar icon"></i> 2019-10-8
                                        </div>
                                        <div class="item aligned">
                                            <i class="eye icon"></i> 4399
                                        </div>
                                    </div>
                                </div>
                                <div class="right aligned five wide column" style="padding-top: 20px">
                                    <a href="${pageContext.request.contextPath}/page/Leaflet.html" target="_self" class="ui blue label" style="opacity: 0.8;padding: 0.3em">查看内容</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="ui padded vertical segment" style="padding: 2em 1em 2em 1em">
                    <div class="ui stackable grid">
                        <div class="middle aligned three wide column">
                            <a href="#" target="_self">
                                <img src="${pageContext.request.contextPath}/img/icon/map2.png" class="ui rounded image">
                            </a>
                        </div>
                        <div class="thirteen wide column">
                            <h1 class="ui header">矢量地图</h1>
                            <p class="ui description">使用leaflet处理简单的矢量地图</p>
                            <div class="ui grid">
                                <div class="middle eleven wide column">
                                    <div class="ui horizontal link list">
                                        <div class="item">
                                            <a href="#">
                                                <img src="${pageContext.request.contextPath}/img/touxiang.jpg" alt="" class="ui avatar image">
                                                <div class="content" style="display: inline-block">
                                                    <div class="ui header" style="opacity: 0.7;font-size: 14px;color: blueviolet">Jayce</div>
                                                </div>
                                            </a>
                                        </div>
                                        <div class="item aligned">
                                            <i class="calendar icon"></i> 2019-10-8
                                        </div>
                                        <div class="item aligned">
                                            <i class="eye icon"></i> 4399
                                        </div>
                                    </div>
                                </div>
                                <div class="right aligned five wide column" style="padding-top: 20px">
                                    <a href="${pageContext.request.contextPath}/page/vector.html" target="_self" class="ui blue label" style="opacity: 0.8;padding: 0.3em">查看内容</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="ui padded vertical segment" style="padding: 2em 1em 2em 1em">
                    <div class="ui stackable grid">
                        <div class="middle aligned three wide column">
                            <a href="#" target="_self">
                                <img src="${pageContext.request.contextPath}/img/icon/map3.png" class="ui rounded image">
                            </a>
                        </div>
                        <div class="thirteen wide column">
                            <h1 class="ui header">空间数据库</h1>
                            <p class="ui description">从空间数据库获取数据，利用leaflet展示在页面上。数据使用的是《空间数据库》这门课程的实验课上老师给的澳大利亚矢量数据</p>
                            <div class="ui grid">
                                <div class="middle eleven wide column">
                                    <div class="ui horizontal link list">
                                        <div class="item">
                                            <a href="#">
                                                <img src="${pageContext.request.contextPath}/img/touxiang.jpg" alt="" class="ui avatar image">
                                                <div class="content" style="display: inline-block">
                                                    <div class="ui header" style="opacity: 0.7;font-size: 14px;color: blueviolet">Jayce</div>
                                                </div>
                                            </a>
                                        </div>
                                        <div class="item aligned">
                                            <i class="calendar icon"></i> 2019-10-8
                                        </div>
                                        <div class="item aligned">
                                            <i class="eye icon"></i> 4399
                                        </div>
                                    </div>
                                </div>
                                <div class="right aligned five wide column" style="padding-top: 20px">
                                    <a href="${pageContext.request.contextPath}/page/GeoJSON.jsp" target="_self" class="ui blue label" style="opacity: 0.8;padding: 0.3em">查看内容</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="ui padded vertical segment" style="padding: 2em 1em 2em 1em">
                    <div class="ui stackable grid">
                        <div class="middle aligned three wide column">
                            <a href="#" target="_self">
                                <img src="${pageContext.request.contextPath}/img/icon/map4.png" class="ui rounded image">
                            </a>
                        </div>
                        <div class="thirteen wide column">
                            <h1 class="ui header">待完善功能</h1>
                            <p class="ui description">1.自己画图后的矢量数据存入空间数据库</p>
                            <p class="ui description">2.解析.shp文件，并加载到页面上</p>
                            <div class="ui grid">
                                <div class="middle eleven wide column">
                                    <div class="ui horizontal link list">
                                        <div class="item">
                                            <a href="#">
                                                <img src="${pageContext.request.contextPath}/img/touxiang.jpg" alt="" class="ui avatar image">
                                                <div class="content" style="display: inline-block">
                                                    <div class="ui header" style="opacity: 0.7;font-size: 14px;color: blueviolet">Jayce</div>
                                                </div>
                                            </a>
                                        </div>
                                        <div class="item aligned">
                                            <i class="calendar icon"></i> 2019-10-8
                                        </div>
                                        <div class="item aligned">
                                            <i class="eye icon"></i> 4399
                                        </div>
                                    </div>
                                </div>
                                <div class="right aligned five wide column" style="padding-top: 20px">
                                    <a href="#" target="_self" class="ui blue label" style="opacity: 0.8;padding: 0.3em">查看内容</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!--底部-->
            <div class="ui attached segment">
                <div class="ui middle aligned two column grid">
                    <div class="column">
                        <button href="#" class="ui mini teal basic button">上一页</button>
                    </div>
                    <div class="right aligned column">
                        <button href="#" class="ui mini teal basic button">下一页</button>
                    </div>
                </div>
            </div>
        </div>

        <!--右边栏-->
        <div class="four wide column">

            <!--分类-->
            <div class="ui segments">
                <div class="ui secondary segment">
                    <div class="ui two column grid">
                        <div class="column">
                            <i class="idea icon"></i>
                            <h3 class="ui header" style="opacity: 0.8;display: inline-block;margin-top: 0">分类</h3>
                        </div>
                        <div class="right aligned column">
                            <a href="#" target="_self">more <i class="angle double right icon"></i></a>
                        </div>
                    </div>
                </div>
                <div class="ui teal segment">
                    <div class="ui fluid vertical menu">
                        <a href="#" class="item">
                            日志
                            <div class="ui teal basic left pointing label">6</div>
                        </a>
                        <a href="#" class="item">
                            思考
                            <div class="ui teal basic left pointing label">9</div>
                        </a>
                        <a href="#" class="item">
                            学习工具
                            <div class="ui teal basic left pointing label">13</div>
                        </a>
                    </div>
                </div>
            </div>

            <!-- 标签 -->
            <div class="ui segments" style="margin-top: 3em">
                <div class="ui secondary segment">
                    <div class="ui two column grid">
                        <div class="column">
                            <i class="tags icon"></i>
                            <h3 class="ui header" style="opacity: 0.8;display: inline-block;margin-top: 0">标签</h3>
                        </div>
                        <div class="right aligned column">
                            <a href="#" target="_self">more <i class="angle double right icon"></i></a>
                        </div>
                    </div>
                </div>
                <div class="ui teal segment">
                    <a href="#" target="_self" class="ui teal basic left pointing label" style="margin: 0.3em">
                        方法<div class="detail">13</div>
                    </a>
                    <a href="#" target="_self" class="ui teal basic left pointing label" style="margin: 0.3em">
                        Java<div class="detail">35</div>
                    </a>
                    <a href="#" target="_self" class="ui teal basic left pointing label" style="margin: 0.3em">
                        Html<div class="detail">8</div>
                    </a>
                    <a href="#" target="_self" class="ui teal basic left pointing label" style="margin: 0.3em">
                        css<div class="detail">12</div>
                    </a>
                    <a href="#" target="_self" class="ui teal basic left pointing label" style="margin: 0.3em">
                        JavaScript<div class="detail">16</div>
                    </a>
                    <a href="#" target="_self" class="ui teal basic left pointing label" style="margin: 0.3em">
                        python<div class="detail">23</div>
                    </a>
                    <a href="#" target="_self" class="ui teal basic left pointing label" style="margin: 0.3em">
                        c++<div class="detail">9</div>
                    </a>
                </div>
            </div>

            <!--最新推荐-->
            <div class="ui segments" style="margin-top: 3em">
                <div class="ui secondary segment">
                    <div class="ui two column grid">
                        <div class="column">
                            <i class="tags icon"></i>
                            <h3 class="ui header" style="opacity: 0.8;display: inline-block;margin-top: 0">已完成功能</h3>
                        </div>
                    </div>
                </div>
                <div class="ui segment">
                    <a href="#" target="_self" style="color: black;opacity: 0.8">1.页面的登录、注册、退出登录</a>
                </div>
                <div class="ui segment">
                    <a href="${pageContext.request.contextPath}/page/Leaflet.html" target="_self" style="color: black;opacity: 0.8">2.切换地图，获取位置(精度不高)，在地图上做标记</a>
                </div>
                <div class="ui segment">
                    <a href="${pageContext.request.contextPath}/page/vector.html" target="_self" style="color: black;opacity: 0.8">3.自己画矢量地图，类似于画板</a>
                </div>
                <div class="ui segment">
                    <a href="${pageContext.request.contextPath}/page/GeoJSON.jsp" target="_self" style="color: black;opacity: 0.8">4.从空间数据库获取数据</a>
                </div>
                <div class="ui segment">
                    <a href="#" target="_self" style="color: black;opacity: 0.8">5.待续...</a>
                </div>
            </div>

            <!--二维码-->
            <h4 class="ui horizontal divider header">加我好友</h4>
            <div class="ui centered card" style="width: 12em">
                <img class="ui rounded image" src="${pageContext.request.contextPath}/img/myWeChat.png" alt="">
            </div>
        </div>
    </div>
    <!--</div>-->
</div>

<%--底部--%>
<footer class="ui inverted vertical segment" style="padding-top: 5em !important;padding-bottom: 5em !important;">
    <div class="ui center aligned container">
        <div class="ui inverted divided stackable grid">
            <div class="four wide column">
                <img src="${pageContext.request.contextPath}/img/myWeChat.png" style="width: 100px">
            </div>
            <div class="three wide column">
                <h4 class="ui inverted header" style="opacity: 0.8">最新博客</h4>
                <div class="ui inverted link list">
                    <a href="#" class="item">故事1(user story)</a>
                    <a href="#" class="item">故事2(user story)</a>
                    <a href="#" class="item">故事3(user story)</a>
                </div>
            </div>
            <div class="three wide column">
                <h4 class="ui inverted header" style="opacity: 0.8">联系我</h4>
                <p style="opacity: 0.8">E-mail : tangjayce@163.com</p>
                <p style="opacity: 0.8">QQ : 1198009679</p>
            </div>
            <div class="six wide column">
                <h4 class="ui inverted header" style="opacity: 0.8">作者有话要说</h4>
                <p style="opacity: 0.8;font-weight: 300">这是我的个人博客，仅用来学习</p>
            </div>
        </div>
        <div class="ui inverted section divider"></div>
        <p style="opacity: 0.6;letter-spacing: 1px">Copyright © 2019 - 2020 GisTask Designed by Jayce</p>
    </div>
</footer>

<div style="position: absolute;left: 30%;right: 30%;top: 80px">
    <c:choose>
        <c:when test="${login_state == 1}">
            <div class="ui success message center aligned">
                <i class="close icon"></i>
                <div class="header">
                    你登录成功！
                </div>
                <p>欢迎回来！</p>
            </div>
        </c:when>
        <c:when test="${login_state == 0}">
            <div class="ui negative message center aligned">
                <i class="close icon"></i>
                <div class="header">
                    你登录失败！
                </div>
                <p>用户名或者密码错误，请重新登陆</p>
            </div>
        </c:when>
        <c:when test="${register_state == 1}">
            <div class="ui success message center aligned">
                <i class="close icon"></i>
                <div class="header">
                    你注册成功！
                </div>
                <p>现在，你可以登录你的用户名</p>
            </div>
        </c:when>
        <c:when test="${register_state == 0}">
            <div class="ui negative message center aligned">
                <i class="close icon"></i>
                <div class="header">
                    你注册失败！
                </div>
                <p>请尝试重新注册</p>
            </div>
        </c:when>
    </c:choose>
</div>
<div class="ui long small modal" id="login_div" style="width: 30% !important;">
    <div class="ui segments">
        <div class="ui secondary segment">
            <div class="ui centered header">
                <h3>登录</h3>
            </div>
        </div>
        <form action="${pageContext.request.contextPath}/LoginServlet" method="post">
            <div class="ui teal segments">
                <div class="ui segment center aligned">
                    <div class="ui fluid icon input item">
                        <input type="text" name="user_name" placeholder="请输入用户名...">
                        <i class="users icon"></i>
                    </div>
                    <br/>
                    <div class="ui fluid icon input item">
                        <input type="password" name="user_password" placeholder="请输入密码...">
                        <i class="myPasswordIcon link eye icon"></i>
                    </div>
<%--                    <div id="login_error_div" class="ui error message" style="display: none">--%>
<%--                        <div class="header">错误</div>--%>
<%--                        <p id="login_error_msg"></p>--%>
<%--                    </div>--%>
                    <br/>
                    <div class="ui item">
                        <input class="ui olive button" type="submit" value="登录">
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
<div class="ui long modal" id="register_div" style="width: 30% !important;">
    <div class="ui segments">
        <div class="ui secondary segment">
            <div class="ui centered header">
                <h3>注册</h3>
            </div>
        </div>
        <form id="register_form" action="${pageContext.request.contextPath}/RegisterServlet" method="post">
            <div class="ui teal segments">
                <div class="ui segment">
                    <div id="userExist_error" class="ui fluid icon input item">
                        <input type="text" id="register_name_div" name="register_name" placeholder="请输入昵称...">
                        <i class="check circle teal icon" style="display: none"></i>
                    </div>
                    <br/>
                    <div class="ui fluid icon input item">
                        <input id="register_password_input" type="password" name="register_password" placeholder="请输入密码...">
                        <i class="myPasswordIcon eye link icon"></i>
                    </div>
                    <br/>
                    <div id="check_code_error_div" class="ui fluid input item">
                        <input id="check_code_input" type="text" placeholder="请输入验证码...">
                        <img id="CheckCode" class="ui image" src="${pageContext.request.contextPath}/CheckCode" onclick="refreshCheckCode()"/>
                    </div>
                    <br/>
                    <div class="ui accordion field">
                        <div class="title">
                            <i class="icon dropdown"></i>
                            更多信息填写
                        </div>
                        <div class="content field">
                            <div class="ui form">
                                <div class="field">
                                    <label>真实姓名</label>
                                    <input type="text" name="register_realName" class="ui input">
                                </div>
                                <div class="field">
                                    <label>个人介绍</label>
                                    <textarea name="register_introduction" rows="4" placeholder="说点什么介绍自己吧，基本信息最好把它写上..."></textarea>
                                </div>
                                <div class="field">
                                    <label>个人爱好</label>
                                    <textarea name="register_hobby" rows="2" placeholder="唱 跳 rap 篮球 ？"></textarea>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div id="register_error_div" class="ui error message" style="display: none">
                        <div class="header">输入错误</div>
                        <p id="register_error_msg"></p>
                    </div>
                    <div class="ui item" style="text-align: center">
                        <input class="ui yellow button" type="button" onclick="checkForm()" value="注册">
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>