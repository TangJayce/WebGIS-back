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
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jayce
 * @date 2019/12/20
 */
@WebServlet("/SelectLayersNameAPI")
public class SelectLayersNameAPI extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("-----------------------------------------");
        String table_name = request.getParameter("table_name");
        System.out.println("在数据库中查询所有" + table_name + "表中图层名字...");
        response.setContentType("application/json;charset=utf-8");

        MapService service = new MapServiceImpl();
        ArrayList<String> names = service.selectLayersName(table_name);
        Map<String,Object> map = new HashMap<>();
        map.put("names",names);
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
