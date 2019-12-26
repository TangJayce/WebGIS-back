$(function () {
    var base_layer = L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png?{foo}', {foo: 'bar'});

    //初始化图层
    var map = L.map("vector_map", {
        center: [10, 10],
        zoom: 8,
        // layers: [base_layer],
        zoomControl: false
    });

    //放大缩小的控件
    L.control.zoom({
        zoomInTitle: '放大',
        zoomOutTitle: '缩小'
    }).addTo(map);

    var featureGroup = L.featureGroup().addTo(map);

    //编辑控件
    var drawControl = new L.Control.Draw({
        draw:{
            marker: {icon: myIcon}
        },
        edit: {
            featureGroup: featureGroup
        }
    }).addTo(map);

    map.on('draw:created', function(e) {
        featureGroup.addLayer(e.layer);
    });

    featureGroup.addLayer(L.circle([10,10], {radius: 50000}));
    featureGroup.addLayer(L.circle([10.5,9.5], {radius: 20000}));
    featureGroup.addLayer(L.circle([10.5,10.5], {radius: 20000}));

    // map.setView([50.5,30.5]);
});