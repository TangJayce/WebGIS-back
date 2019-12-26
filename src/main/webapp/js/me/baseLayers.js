/**
 * 智图地图内容
 */
var normalm1 = L.tileLayer.chinaProvider('Geoq.Normal.Map', {
    maxZoom: 18,
    minZoom: 2
});
var normalm3 = L.tileLayer.chinaProvider('Geoq.Normal.PurplishBlue', {
    maxZoom: 18,
    minZoom: 2
});
var normalm4 = L.tileLayer.chinaProvider('Geoq.Normal.Gray', {
    maxZoom: 18,
    minZoom: 2
});
var normalm5 = L.tileLayer.chinaProvider('Geoq.Normal.Warm', {
    maxZoom: 18,
    minZoom: 2
});
/**
 * 天地图内容
 */
var normalm = L.tileLayer.chinaProvider('TianDiTu.Normal.Map', {
        maxZoom: 18,
        minZoom: 2
    }),
    normala = L.tileLayer.chinaProvider('TianDiTu.Normal.Annotion', {
        maxZoom: 18,
        minZoom: 2
    }),
    imgm = L.tileLayer.chinaProvider('TianDiTu.Satellite.Map', {
        maxZoom: 18,
        minZoom: 2
    }),
    imga = L.tileLayer.chinaProvider('TianDiTu.Satellite.Annotion', {
        maxZoom: 18,
        minZoom: 2
    });

var TianDiTu = L.layerGroup([normalm, normala]),
    TianDiTuimage = L.layerGroup([imgm, imga]);
/**
 * 谷歌
 */
var Google = L.tileLayer.chinaProvider('Google.Normal.Map', {
        maxZoom: 18,
        minZoom: 2
    }),
    Googleimage = L.tileLayer.chinaProvider('Google.Satellite.Map', {
        maxZoom: 18,
        minZoom: 2
    });
/**
 * 高德地图
 */
var Gaode = L.tileLayer.chinaProvider('GaoDe.Normal.Map', {
    maxZoom: 18,
    minZoom: 2
});
var Gaodimgem = L.tileLayer.chinaProvider('GaoDe.Satellite.Map', {
    maxZoom: 18,
    minZoom: 2
});
var Gaodimga = L.tileLayer.chinaProvider('GaoDe.Satellite.Annotion', {
    maxZoom: 18,
    minZoom: 2
});
var Gaodimage = L.layerGroup([Gaodimgem, Gaodimga]);



var baseLayers = {
    "TianDiTu": TianDiTu,
    "TianDiTuimage": TianDiTuimage,
    "Google": Google,
    "Googleimage": Googleimage,
    "Gaode": Gaode,
    "Gaodimage": Gaodimage,
    "normalm1": normalm1,
    "normalm3": normalm3,
    "normalm4": normalm4,
    "normalm5": normalm5
};

var customBaselayer = Gaode; //底图
var map;        //当前地图对象
var latitude;   //纬度
var longitude;  //精度
var myPositionMarker;  //我的当前位置
var myIcon = L.icon({  //我的图标
    iconUrl:"../img/icon/position-icon.png",
    iconSize:[32,32],
    shadowUrl:"../img/icon/position-shadow.png",
    shadowSize: [32, 32]
});