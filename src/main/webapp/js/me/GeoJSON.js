$(function () {
    var RootPath = $("#RootPath").val();
    var map_name = "Australia";
    //异步请求空间数据库的矢量数据
    $.post(RootPath + "/GetGeoJSON",  //发送请求的路径
        {map_name: map_name},         //发送的数据
        function (data) {             //回调函数
            //alert(data.msg);
            loadMap(data);                //加载地图
        },
        "json"  //返回的数据类型
    );
});

function loadMap(data) {
    //初始化图层
    var map = L.map("geoJson_map", {
        center: [data.center.latitude, data.center.longitude],
        zoom: 4,
        // layers: [base_layer],
        zoomControl: false
    });

    //放大缩小的控件
    L.control.zoom({
        zoomInTitle: '放大',
        zoomOutTitle: '缩小'
    }).addTo(map);

    var myStyle = {
        color: "blue",
        fillColor: "teal",
        fillOpacity: 0.8,
        weight: 2
    };

    L.geoJSON(data.json,{
        style: myStyle,
        onEachFeature: onEachFeature
    }).addTo(map);
}

function onEachFeature(feature, layer) {//针对每个要素采取的操作
    // does this feature have a property named popupContent?
    if (feature.properties && feature.properties.popupContent) {
        layer.bindPopup(feature.properties.popupContent);
    }
}
