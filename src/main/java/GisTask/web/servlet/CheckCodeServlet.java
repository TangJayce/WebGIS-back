package GisTask.web.servlet;

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
 * @date 2019/10/15
 */
@WebServlet("/CheckCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("-----------------------------------------");
        //可以设置数据响应格式为json
        response.setContentType("application/json;charset=utf-8");
        //判断验证码
        String input_check_code = request.getParameter("check_code");
        String checkCode = (String) request.getSession().getAttribute("checkCode");
        //在session中删除验证码
        request.getSession().removeAttribute("checkCode");
        System.out.println("input_check_code = " + input_check_code);
        System.out.println("checkCode = " + checkCode);

        Map<String,Object> map = new HashMap<String,Object>();
        if(input_check_code.equalsIgnoreCase(checkCode)){
            //验证码正确
            System.out.println("验证码正确");
            map.put("check_right",true);
            map.put("msg","验证码正确");
        }else {
            //验证码错误
            System.out.println("验证码错误");
            map.put("check_right",false);
            map.put("msg","验证码错误");
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
