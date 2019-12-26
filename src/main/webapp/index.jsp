<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>首页</title>
    <script src="js/jquery/jquery.min.js"></script>
    <%--    <link href="../css/semanticUI/semantic.min.css" rel="stylesheet">--%>
    <link href="https://cdn.bootcss.com/semantic-ui/2.4.1/semantic.min.css" rel="stylesheet">
    <%--  <script src="https://cdn.bootcss.com/semantic-ui/2.4.1/semantic.min.js"></script>--%>
    <script src="js/semanticUI/semantic.min.js"></script>
    <script src="js/me/myScript.js"></script>
    <script src="https://cdn.bootcss.com/axios/0.19.0-beta.1/axios.js"></script>
</head>
<body>
    <h2>Hello World!</h2>
    <a href="TestServlet">点击测试</a>
    <button onclick="success_click()">点击成功</button>
    <button onclick="ajaxGet()">点击发送ajax请求</button>
    <div class="ui basic modal">
        <div class="ui icon header">
            <i class="user icon"></i>
            弹出一个窗口
        </div>
        <div class="content">
            <p>恭喜你登录成功，现在你可以查看你的个人信息了，是否跳转到个人主页</p>
        </div>
        <div class="actions">
            <div class="ui red basic cancel inverted button">
                <i class="remove icon"></i>
                否
            </div>
            <div class="ui green ok inverted button">
                <i class="checkmark icon"></i>
                是
            </div>
        </div>
    </div>
<script>
    function success_click() {
        $('.ui.basic.modal')
            .modal('show')
        ;
    }
    
    function ajaxGet() {
        const url = '/GisTask/TestServlet';
        axios.get(url).then(reponse => {
            console.log(reponse);
        })
    }
</script>
</body>
</html>
