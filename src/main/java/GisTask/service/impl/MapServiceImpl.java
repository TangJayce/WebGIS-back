package GisTask.service.impl;

import GisTask.dao.MapDao;
import GisTask.dao.impl.MapDaoImpl;
import GisTask.domain.Coordinate;
import GisTask.domain.Point;
import GisTask.service.MapService;
import GisTask.util.StringUtils;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jayce
 * @date 2019/11/1
 */
public class MapServiceImpl implements MapService {
    private MapDao dao = new MapDaoImpl();

    @Override
    public JSONObject findMapByName(String map_name) {
        String mapStr = dao.findMapByName(map_name);
        if(mapStr != null) {
            JSONObject leaflet_json = new JSONObject();
            leaflet_json.put("type", "Feature");
            Map<String, Object> map = new HashMap<>();
            map.put("name", map_name);
            map.put("popupContent", "这个图层是: " + map_name);
            leaflet_json.put("properties", map);
            JSONObject geoJSON = JSONObject.fromObject(mapStr);
            leaflet_json.put("geometry", geoJSON);
            return leaflet_json;
        }
        return null;
    }

    @Override
    public Point findMapCenter(String table_name, String map_name) {
        String mapCenter = dao.findMapCenter(table_name, map_name);
        return StringUtils.StringToPoint(mapCenter);
    }

    @Override
    public JSONObject findLayerByName(String table_name, String map_name) {
        String mapStr = dao.findLayerByName(table_name, map_name);
        if(mapStr != null) {
            JSONObject leaflet_json = new JSONObject();
            leaflet_json.put("type", "Feature");
            Map<String, Object> map = new HashMap<>();
            map.put("name", map_name);
            map.put("popupContent", "这个图层是: " + map_name);
            leaflet_json.put("properties", map);
            JSONObject geoJSON = JSONObject.fromObject(mapStr);
            leaflet_json.put("geometry", geoJSON);
            return leaflet_json;
        }
        return null;
    }

    @Override
    public ArrayList<Point> findMBRByName(String table_name, String map_name) {
        String map_MBR = dao.findMBRByName(table_name, map_name);
        return StringUtils.StringToPointArray(map_MBR);
    }

    @Override
    public ArrayList<String> selectLayersName(String table_name) {
        return dao.selectLayersName(table_name);
    }

    @Override
    public ArrayList<Coordinate> selectUserPoint(String name) {
        ArrayList<Map<String, Object>> maps = dao.selectUserPoint(name);
        ArrayList<Coordinate> points = new ArrayList<>();
        for (Map<String, Object> map : maps) {
            Point latlng = StringUtils.StringToPoint((String) map.get("latlng"));
            points.add(new Coordinate(name,latlng,(String) map.get("description"),(String) map.get("time")));
        }
        return points;
    }

    @Override
    public ArrayList<Coordinate> selectUserPoints() {
        ArrayList<Map<String, Object>> maps = dao.selectUserPoints();
        ArrayList<Coordinate> points = new ArrayList<>();
        for (Map<String, Object> map : maps) {
            Point latlng = StringUtils.StringToPoint((String) map.get("latlng"));
            points.add(new Coordinate((Integer) map.get("id"), (String) map.get("name"),latlng,(String) map.get("description"),(String) map.get("time")));
        }
        return points;
    }

    @Override
    public boolean updatePoint(int point_id,double longitude, double latitude, String description, String time) {
        return dao.updatePoint(point_id,longitude,latitude,description,time);
    }

    @Override
    public boolean deletePoint(int point_id) {
        return dao.deletePoint(point_id);
    }

    @Override
    public boolean savePoint(String name, double longitude, double latitude, String description, String time) {
        return dao.savePoint(name,longitude,latitude,description,time);
    }
}
