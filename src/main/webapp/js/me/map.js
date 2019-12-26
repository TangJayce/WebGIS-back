$(function () {
    $('.ui.dropdown').dropdown();

    //初始化图层
    map = L.map("map", {
        center: [27.902326, 112.920405],
        zoom: 15,
        layers: [customBaselayer],  //默认使用高德地图
        zoomControl: false
    });
    var featureGroup = L.featureGroup().addTo(map);

    //放大缩小的控件
    L.control.zoom({
        zoomInTitle: '放大',
        zoomOutTitle: '缩小'
    }).addTo(map);

    //编辑控件
    var drawControl = new L.Control.Draw({
        draw:{
            marker: {
                // title: '做一个标记',
                icon: myIcon
            },
            polygon: false,
            polyline: false,
            rectangle: false,
            circle: false
        },
        edit: {
            featureGroup: featureGroup,
            edit: false
        }
    }).addTo(map);

    map.on('draw:created', function(e) {
        featureGroup.addLayer(e.layer);
    });

    //定位
    if(navigator.geolocation){
        navigator.geolocation.getCurrentPosition(onSuccess,onError);
    }else {
        console.log("您的浏览器不支持使用HTML5来获取地理位置服务");
    }
});

//切换地图
function setMap(MapDiv) {
    if(customBaselayer){
        map.removeLayer(customBaselayer);
    }
    customBaselayer = baseLayers[MapDiv.id];
    map.addLayer(customBaselayer);
}

//定位成功
function onSuccess(position) {
    latitude = position.coords.latitude;
    longitude = position.coords.longitude;
    console.log("纬度 = " + latitude + "\n经度 = " + longitude);
    myPositionMarker = L.marker([latitude,longitude],{icon:myIcon}).bindPopup("这是你的位置");
    myPositionMarker.addTo(map).openPopup();
}

//定位失败
function onError(error) {
    switch(error.code)  {
        case error.PERMISSION_DENIED:
            console.log("您拒绝对获取地理位置的请求");
            break;
        case error.POSITION_UNAVAILABLE:
            console.log("位置信息是不可用的");
            break;
        case error.TIMEOUT:
            console.log("请求您的地理位置超时");
            break;
        case error.UNKNOWN_ERROR:
            console.log("未知错误");
            break;
        default:
            console.log("位置错误");
    }
}