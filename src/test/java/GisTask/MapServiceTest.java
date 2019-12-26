package GisTask;

import GisTask.domain.Point;
import GisTask.service.MapService;
import GisTask.service.impl.MapServiceImpl;
import net.sf.json.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jayce
 * @date 2019/11/1
 */
public class MapServiceTest {
    private MapService service = new MapServiceImpl();

    @Test
    public void findMBRByNameTest(){
        String map_name = "南二环";
        String table_name = "road";
        JSONObject leaflet_json = service.findLayerByName(table_name, map_name);
        ArrayList<Point> map_MBR = service.findMBRByName(table_name, map_name);
        System.out.println("leaflet_json = " + leaflet_json);
        System.out.println("map_MBR = " + map_MBR);
    }
    @Test
    public void selectUserPointTest(){
        System.out.println(service.selectUserPoint("阿虎"));
    }
    @Test
    public void selectUserPointsTest(){
        System.out.println(service.selectUserPoints());
    }
    @Test
    public void updatePointTest(){
        System.out.println(service.updatePoint(5,112.916,27.915,"测试5555","2019-12-23 09:12:36"));
    }
}
