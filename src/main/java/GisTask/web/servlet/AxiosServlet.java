package GisTask.web.servlet;

import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jayce
 * @date 2019/12/18
 */
@WebServlet("/AxiosServlet")
public class AxiosServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("发起了跨域post请求...");
        response.setContentType("application/json;charset=utf-8");
        String user_name = null, user_password = null;
        try {
            user_name = request.getParameter("user_name").trim();
            user_password = request.getParameter("user_password");
        }catch (Exception e){
            e.printStackTrace();
        }
        Map<String,Object> map = new HashMap<>();
        map.put("type","post");
        if("admin".equals(user_name) && "admin".equals(user_password)) {
            map.put("msg", "登录成功...");
            map.put("status", "success");
        }else {
            map.put("msg", "登录失败...");
            map.put("state", "error");
        }

        JSONObject jsonObject = JSONObject.fromObject(map);
        response.getWriter().write(jsonObject.toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("发起了跨域get请求...");
        response.setContentType("application/json;charset=utf-8");
        Map<String,Object> map = new HashMap<>();
        map.put("type","get");
        map.put("msg","获取信息成功...");

        JSONObject jsonObject = JSONObject.fromObject(map);
        response.getWriter().write(jsonObject.toString());
    }
}
