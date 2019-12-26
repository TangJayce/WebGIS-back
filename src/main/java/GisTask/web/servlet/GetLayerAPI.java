package GisTask.web.servlet;

import GisTask.domain.Point;
import GisTask.service.MapService;
import GisTask.service.impl.MapServiceImpl;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jayce
 * @date 2019/12/20
 */
@WebServlet("/GetLayerAPI")
public class GetLayerAPI extends HttpServlet {
    private MapService service = new MapServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("-----------------------------------------");
        response.setContentType("application/json;charset=utf-8");
        String map_name = request.getParameter("map_name");
        String table_name = request.getParameter("table_name");
        System.out.println("查询地图：" + map_name);
        System.out.println("查询表：" + table_name);

        JSONObject leaflet_json = service.findLayerByName(table_name,map_name);
        ArrayList<Point> map_MBR = service.findMBRByName(table_name,map_name);
        Map<String,Object> map = new HashMap<>();

        map.put("json",leaflet_json);
        map.put("map_MBR",map_MBR);
        map.put("msg","获取信息成功...");
        map.put("status","success");
        System.out.println("map = " + map);

        JSONObject jsonObject = JSONObject.fromObject(map);
        response.getWriter().write(jsonObject.toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
