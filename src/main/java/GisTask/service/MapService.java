package GisTask.service;

import GisTask.domain.Coordinate;
import GisTask.domain.Point;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author Jayce
 * @date 2019/11/1
 */
public interface MapService {
    public JSONObject findMapByName(String map_name);

    public Point findMapCenter(String table_name, String map_name);

    public JSONObject findLayerByName(String table_name, String map_name);

    public ArrayList<Point> findMBRByName(String table_name, String map_name);

    public ArrayList<String> selectLayersName(String table_name);

    public ArrayList<Coordinate> selectUserPoint(String name);

    public ArrayList<Coordinate> selectUserPoints();

    public boolean updatePoint(int point_id,double longitude, double latitude, String description, String time);

    public boolean deletePoint(int point_id);

    public boolean savePoint(String name, double longitude, double latitude, String description, String time);
}
