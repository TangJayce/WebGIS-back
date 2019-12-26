<%--
  User: GisTask
  Date: 2019/10/13
  Time: 21:45
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>登录</title>
    <script src="../js/jquery/jquery.min.js"></script>
    <%--    <link href="../css/semanticUI/semantic.min.css" rel="stylesheet">--%>
    <link href="https://cdn.bootcss.com/semantic-ui/2.4.1/semantic.min.css" rel="stylesheet">
    <%--  <script src="https://cdn.bootcss.com/semantic-ui/2.4.1/semantic.min.js"></script>--%>
    <script src="../js/semanticUI/semantic.min.js"></script>
    <script src="../js/me/myScript.js"></script>
</head>
<body>

<div style="position: absolute;left: 30%;right: 30%">
    <div id="msg" class="ui success message center aligned" style="display: none">
        <i class="close icon"></i>
        <div class="header">
            你注册成功！.....
        </div>
        <p>现在，你可以登录你的用户名</p>
    </div>
</div>

<div class="ui long small modal" id="login_div" style="width: 30% !important;">
    <div class="ui segments">
        <div class="ui segment">
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
                        <i class="eye icon"></i>
                    </div>
                    <div class="ui error message">
                        <div class="header">输入错误</div>
                        <p>你只能用指定的邮箱注册</p>
                    </div>
                    <br/>
                    <div class="ui item">
                        <input class="ui olive button" type="submit" value="登录">
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
<div class="ui modal">
    <div class="ui form error">
        <div class="field">
            <label>E-mail</label>
            <input type="email" placeholder="joe@schmoe.com">
        </div>
        <div class="ui error message">
            <div class="header">输入错误</div>
            <p>你只能用指定的邮箱注册</p>
        </div>
        <div class="ui submit button">提交</div>
    </div>
</div>
<button class="test button ui olive">点我</button>
<%=request.getContextPath()%>
<button class="ui button yellow" onclick="test()">测试</button>
<button class="ui button yellow" onclick="showMsg()">点击显示</button>
<i class="check circle teal icon"></i>
<button class="ui button yellow" onclick="reg()">注册</button>

<div class="ui segment">
    <form class="ui fluid form" action="${pageContext.request.contextPath}/TestServlet" method="post">
        <div class="two fields">
            <div class="field">
                <label>姓</label>
                <input type="text" name="xing" placeholder="姓">
            </div>
            <div class="field">
                <label>名</label>
                <input type="text" name="ming" placeholder="名">
            </div>
        </div>
        <div class="ui accordion field">
            <div class="title">
                <i class="icon dropdown"></i>
                选填内容
            </div>
            <div class="content field">
                <label class="transition hidden">婚前姓氏</label>
                <input class="transition hidden" type="text" name="huiqianxingshi" placeholder="Maiden Name">
            </div>
        </div>
        <input type="submit" class="ui secondary submit button" value="点击测试表单"/>
    </form>
</div>

<div class="ui long small modal" id="register_div" style="width: 30% !important;">
    <div class="ui segments">
        <div class="ui secondary segment">
            <div class="ui centered header">
                <h3>注册</h3>
            </div>
        </div>
        <form>
            <div class="ui teal segments">
                <div class="ui segment">
                    <div class="ui fluid icon input item">
                        <input type="text" id="register_name_div" placeholder="请输入用户名...">
                        <i class="check circle teal icon" style="display: none"></i>
                    </div>
                    <br/>
                    <div class="ui fluid icon input item">
                        <input type="password" placeholder="请输入密码...">
                        <i id="password_icon" class="eye link icon"></i>
                    </div>
                    <br/>
                    <div class="ui fluid input item">
                        <input type="text" placeholder="请输入验证码...">
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
                                    <label>个人介绍</label>
                                    <textarea rows="4" placeholder="说点什么介绍自己吧，基本信息最好把它写上..."></textarea>
                                </div>
                                <div class="field">
                                    <label>个人爱好</label>
                                    <textarea rows="2" placeholder="唱 跳 rap 篮球 ？"></textarea>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div id="register_error_div" class="ui error message" style="display: none">
                        <div class="header">输入错误</div>
                        <p id="register_error_msg"></p>
                    </div>
                    <div class="ui item" style="text-align: center">
                        <input class="ui yellow button" type="submit" value="注册">
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>

<div class="ui text menu">
    <div class="item">
        <img src="../images/new-school.jpg">
    </div>
    <a class="浏览 item">
        浏览课程
        <i class="dropdown icon"></i>
    </a>
    <div class="ui right dropdown item">
        更多
        <i class="dropdown icon"></i>
        <div class="menu">
            <div class="item">应用</div>
            <div class="item">国际学生</div>
            <div class="item">奖学金</div>
        </div>
    </div>
</div>
<div class="ui flowing basic admission popup">
    <div class="ui three column relaxed divided grid">
        <div class="column">
            <h4 class="ui header">Business</h4>
            <div class="ui link list">
                <a class="item">Design &amp; Urban Ecologies</a>
                <a class="item">Fashion Design</a>
                <a class="item">Fine Art</a>
                <a class="item">Strategic Design</a>
            </div>
        </div>
        <div class="column">
            <h4 class="ui header">Liberal Arts</h4>
            <div class="ui link list">
                <a class="item">Anthropology</a>
                <a class="item">Economics</a>
                <a class="item">Media Studies</a>
                <a class="item">Philosophy</a>
            </div>
        </div>
        <div class="column">
            <h4 class="ui header">Social Sciences</h4>
            <div class="ui link list">
                <a class="item">Food Studies</a>
                <a class="item">Journalism</a>
                <a class="item">Non Profit Management</a>
            </div>
        </div>
    </div>
</div>

<script>
    $('.ui.modal')
        .modal({
            blurring: true
        })
        .modal('attach events', '.test.button', 'show')
    ;

    function test() {
        var path = "${pageContext.request.contextPath}";
        alert(path);
    }

    function showMsg(){
        $('.message').show();
    }

    $('.ui.accordion')
        .accordion()
    ;

    function reg() {
        $('#register_div')
            .modal({
                blurring: true
            })
            .modal('show')
        ;
    }

    $("#password_icon").click(function () {
        alert("成功");
    });
</script>
</body>
</html>
