package GisTask.dao;

import GisTask.domain.Coordinate;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author Jayce
 * @date 2019/11/1
 */
public interface MapDao {
    public String findMapByName(String map_name);

    public String findMapCenter(String table_name, String map_name);

    public String findLayerByName(String table_name, String map_name);

    public String findMBRByName(String table_name, String map_name);

    public ArrayList<String> selectLayersName(String table_name);

    public ArrayList<Map<String, Object>> selectUserPoint(String name);

    public ArrayList<Map<String, Object>> selectUserPoints();

    public boolean updatePoint(int point_id, double longitude, double latitude, String description, String time);

    public boolean deletePoint(int point_id);

    public boolean savePoint(String name, double longitude, double latitude, String description, String time);
}
