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
@WebServlet("/ShowPointsAPI")
public class ShowPointsAPI extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("-----------------------------------------");
        response.setContentType("application/json;charset=utf-8");
        System.out.println("查询所有的坐标点：");

        MapService service = new MapServiceImpl();
        ArrayList<Coordinate> points = service.selectUserPoints();
        Map<String,Object> map = new HashMap<>();

        map.put("points",points);
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
