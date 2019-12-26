<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8" />
    <title>空间数据库</title>
    <!--    <meta name="viewport" content="initial-scale=1,maximum-scale=1,user-scalable=no" />-->
    <script src="../js/jquery/jquery.min.js"></script>

    <!-- 加载 leaflet -->
    <link rel="stylesheet" href="../css/leaflet/leaflet.css"
          integrity="sha512-xwE/Az9zrjBIphAcBb3F6JVqxf46+CDLwfLMHloNu6KEQCAWi6HcDUbeOfBIptF7tcCzusKFjFw2yuvEpDL9wQ=="
          crossorigin=""/>
    <script src="../js/leaflet/leaflet.js"
            integrity="sha512-GffPMF3RvMeYyc1LWMHtK8EbPv0iNZ8/oTtHPx9/cc2ILxQ+u905qIwdpULaqDkyBKgOaB57QTMg7ztg8Jm2Og=="
            crossorigin=""></script>

    <!-- 加载 leaflet.draw -->
    <link href='https://api.mapbox.com/mapbox.js/plugins/leaflet-draw/v0.4.10/leaflet.draw.css' rel='stylesheet' />
    <script src='../js/leaflet/leaflet.draw.js'></script>

    <!-- 加载 leaflet.ChineseTmsProviders -->
    <script src="../js/leaflet/leaflet.ChineseTmsProviders.js"></script>

    <!-- 加载 semanticUI -->
    <link href="https://cdn.bootcss.com/semantic-ui/2.4.1/semantic.min.css" rel="stylesheet">
    <script src="../js/semanticUI/semantic.min.js"></script>

    <!-- 加载个人文件 -->
    <script src="https://cdn.bootcss.com/axios/0.19.0-beta.1/axios.js"></script>
    <link rel="stylesheet" href="../css/me/map.css">
<!--    <script src="../js/me/baseLayers.js"></script>-->
    <script src="../js/me/GeoJSON.js"></script>

</head>
<body>
<input type="hidden" id="RootPath" value="${pageContext.request.contextPath}"/>
<!--导航栏-->
<nav class="ui inverted attached segment">
    <div class="ui container">
        <div class="ui inverted secondary menu stackable">
            <h2 class="ui teal header" style="margin: 0 1em 0 1em;" id="mylogo">Jayce</h2>
            <a href="home.jsp" class="item"><i class="home icon"></i>首页</a>
            <a href="#" class="item"><i class="idea icon"></i>分类</a>
            <a href="#" class="item"><i class="tags icon"></i>标签</a>
            <a href="#" class="item"><i class="info icon"></i>关于</a>
            <div class="right item">
                <div class="ui icon inverted transparent input">
                    <input type="text" placeholder="在这里搜索......">
                    <i class="search link icon"></i>
                </div>
            </div>
        </div>
    </div>
</nav>
<!--地图-->
<div class="leaflet-container">
    <div id="geoJson_map"></div>
</div>

</body>
</html>