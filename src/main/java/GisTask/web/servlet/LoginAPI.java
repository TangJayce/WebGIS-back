package GisTask.web.servlet;

import GisTask.domain.User;
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
 * @date 2019/12/18
 */
@WebServlet("/LoginAPI")
public class LoginAPI extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("-----------------------------------------------");
        String name = request.getParameter("user_name").trim();
        String password = request.getParameter("user_password");
        User loginUser = new User(name,password);
        System.out.println("有用户登录  ==> " + name + " : " + password);

        UserService service = new UserServiceImpl();
        User user = service.login(loginUser);

        Map<String,Object> map = new HashMap<>();
        if (user == null) {
            //登录失败
            map.put("msg","账号或密码错误");
            map.put("status","error");
        }else {
            //登录成功
            map.put("msg","登录成功");
            map.put("status","success");
//            request.getSession().setAttribute("user", user);
//            request.getSession().setAttribute("login_state", "1");
        }

        JSONObject jsonObject = JSONObject.fromObject(map);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(jsonObject.toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("-----------------------------------------------");
        System.out.println("有用户使用get方式登录 ");
        Map<String,Object> map = new HashMap<>();
        map.put("msg","请使用post方式登录");
        map.put("status","error");

        JSONObject jsonObject = JSONObject.fromObject(map);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(jsonObject.toString());
    }
}
