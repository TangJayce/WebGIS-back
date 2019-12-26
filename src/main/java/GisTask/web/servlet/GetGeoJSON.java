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
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jayce
 * @date 2019/11/1
 */
@WebServlet("/GetGeoJSON")
public class GetGeoJSON extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("-----------------------------------------");
        response.setContentType("application/json;charset=utf-8");
        String map_name = request.getParameter("map_name");
        System.out.println("查询地图：" + map_name);

        MapService service = new MapServiceImpl();
        JSONObject leaflet_json = service.findMapByName(map_name);
        Point center = service.findMapCenter("map",map_name);
        Map<String,Object> map = new HashMap<>();

        map.put("json",leaflet_json);
        map.put("center",center);
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
