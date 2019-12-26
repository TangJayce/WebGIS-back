package GisTask.dao.impl;

import GisTask.dao.MapDao;
import GisTask.util.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Jayce
 * @date 2019/11/1
 */
public class MapDaoImpl implements MapDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public String findMapByName(String map_name) {
        String sql = "SELECT ST_AsGeoJSON(shape) AS shape_json from map WHERE `name` = ?";
        Map<String, Object> map = template.queryForMap(sql, map_name);
        return (String) map.get("shape_json");
    }

    @Override
    public String findMapCenter(String table_name, String map_name) {
        String sql = "SELECT ST_AsText(ST_Centroid(shape)) AS center_point from "+table_name+" WHERE `name` = ?";
        Map<String, Object> map = template.queryForMap(sql, map_name);
        return (String) map.get("center_point");
    }

    @Override
    public String findLayerByName(String table_name, String map_name) {
        String sql = "SELECT ST_AsGeoJSON(shape) AS shape_json from "+table_name+" WHERE `name` = ?";
        Map<String, Object> map = template.queryForMap(sql, map_name);
        return (String) map.get("shape_json");
    }

    @Override
    public String findMBRByName(String table_name, String map_name) {
        String sql = "SELECT ST_AsText(ST_Envelope(shape)) AS shape_MBR from "+table_name+" WHERE `name` = ?";
        Map<String, Object> map = template.queryForMap(sql, map_name);
        return (String) map.get("shape_MBR");
    }

    @Override
    public ArrayList<String> selectLayersName(String table_name) {
        String sql = "SELECT name from " + table_name;
        List<Map<String, Object>> maps = template.queryForList(sql);
        ArrayList<String> LayersName = new ArrayList<>();
        for (Map<String, Object> map : maps) {
            LayersName.add((String) map.get("name"));
        }
        return LayersName;
    }

    @Override
    public ArrayList<Map<String, Object>> selectUserPoint(String name) {
        String sql = "SELECT ST_ASText(latlng) AS latlng,description,time from user_point where name = ?";
        return (ArrayList<Map<String, Object>>) template.queryForList(sql,name);
    }

    @Override
    public ArrayList<Map<String, Object>> selectUserPoints() {
        String sql = "SELECT id, name, ST_ASText(latlng) AS latlng, description, time from user_point";
        return (ArrayList<Map<String, Object>>) template.queryForList(sql);
    }

    @Override
    public boolean updatePoint(int point_id, double longitude, double latitude, String description, String time) {
        String sql = "UPDATE user_point SET description = ?, time = ?, latlng = GeomFromText('POINT("+longitude+" "+latitude+")') WHERE id = ?";
        int count = template.update(sql, description, time, point_id);
        System.out.println("count = " + count);
        return count == 1;
    }

    @Override
    public boolean deletePoint(int point_id) {
        String sql = "DELETE FROM coordinate WHERE id = ?";
        int count = template.update(sql, point_id);
        System.out.println("count = " + count);
        return count == 1;
    }

    @Override
    public boolean savePoint(String name, double longitude, double latitude, String description, String time) {
        String sql = "INSERT INTO coordinate VALUES(NULL,GeomFromText('POINT("+longitude+" "+latitude+")'),?,?,(SELECT id from user where name = ?))";
        int count = template.update(sql,description,time,name);
        System.out.println("count = " + count);
        return count == 1;
    }
}
