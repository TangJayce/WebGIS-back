package GisTask.web.servlet;

import GisTask.domain.Coordinate;
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
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jayce
 * @date 2019/12/23
 */
@WebServlet("/UpdatePointAPI")
public class UpdatePointAPI extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("-----------------------------------------");
        response.setContentType("application/json;charset=utf-8");
        String pointId = request.getParameter("point_id");
        String description = request.getParameter("description");
        String time = request.getParameter("time");
        double latitude = Double.parseDouble(request.getParameter("latitude"));
        double longitude = Double.parseDouble(request.getParameter("longitude"));
        String name = request.getParameter("name");

        MapService service = new MapServiceImpl();
        Map<String, Object> map = new HashMap<>();
        boolean result = false;

        if(pointId == null){
            System.out.println("发起了保存坐标点信息的请求：");
            System.out.println("name = " + name);
            System.out.println("latitude = " + latitude);
            System.out.println("longitude = " + longitude);
            System.out.println("description = " + description);
            result = service.savePoint(name,longitude,latitude,description,time);
        }
        else {
            int point_id = Integer.parseInt(pointId);
            System.out.println("point_id为" + point_id + ",发起了更新坐标点信息的请求：" + description);
            result = service.updatePoint(point_id,longitude,latitude, description, time);
        }

        if (result) {
            map.put("msg", "保存信息成功...");
            map.put("status", "success");
        } else {
            map.put("msg", "保存信息失败...");
            map.put("status", "error");
        }
        System.out.println("map = " + map);

        JSONObject jsonObject = JSONObject.fromObject(map);
        response.getWriter().write(jsonObject.toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
