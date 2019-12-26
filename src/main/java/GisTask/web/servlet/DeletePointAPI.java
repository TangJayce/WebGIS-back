package GisTask.web.servlet;

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
 * @date 2019/12/24
 */
@WebServlet("/DeletePointAPI")
public class DeletePointAPI extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("-----------------------------------------");
        response.setContentType("application/json;charset=utf-8");
        int point_id = Integer.parseInt(request.getParameter("point_id"));
        System.out.println("point_id为" + point_id + ",发起了删除坐标点信息的请求：");

        MapService service = new MapServiceImpl();
        Map<String, Object> map = new HashMap<>();

        if(service.deletePoint(point_id)) {
            map.put("msg", "删除信息成功...");
            map.put("status", "success");
        }else {
            map.put("msg", "删除信息失败...");
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
