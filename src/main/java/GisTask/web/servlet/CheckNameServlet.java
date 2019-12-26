package GisTask.web.servlet;

import GisTask.service.UserService;
import GisTask.service.impl.UserServiceImpl;
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
 * @date 2019/10/14
 */
@WebServlet("/CheckNameServlet")
public class CheckNameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("-----------------------------------------");
        //可以设置数据响应格式为json
        response.setContentType("application/json;charset=utf-8");
//        response.setContentType("text/html;charset=utf-8");
        String register_name = request.getParameter("register_name").trim();
        System.out.println("register_name = " + register_name);
        Map<String,Object> map = new HashMap<String,Object>();
        //查询数据库
        UserService service = new UserServiceImpl();
        if(service.findUserByName(register_name)){
            //存在
            map.put("userExsit",true);
            map.put("msg","该用户已经存在");
        }else {
            //不存在
            map.put("userExsit",false);
            map.put("msg","该用户名可用");
        }
        System.out.println("map = " + map);
        JSONObject jsonObject = JSONObject.fromObject(map);
        System.out.println("jsonObject = " + jsonObject);
        response.getWriter().write(jsonObject.toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
