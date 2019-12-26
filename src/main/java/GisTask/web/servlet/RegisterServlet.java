package GisTask.web.servlet;

import GisTask.domain.User;
import GisTask.service.UserService;
import GisTask.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Jayce
 * @date 2019/10/14
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("-----------------------------------------------");
//        String name = request.getParameter("register_name").trim();
//        String password = request.getParameter("register_password");
//        System.out.println("有用户注册 ==> " + name + " : " + password);
//
//        String introduction = request.getParameter("register_introduction");
//        String hobby = request.getParameter("register_hobby");
//        String realName = request.getParameter("register_realName");
//
//        User user = new User(name,password,introduction,hobby,realName);
//        UserService service = new UserServiceImpl();
//        int count = service.register(user);
//
//        if(count == 1){
//            System.out.println("注册成功...");
//            request.setAttribute("register_state",1);
//        }else {
//            System.out.println("注册失败...");
//            request.setAttribute("register_state",0);
//        }
//        request.getRequestDispatcher("/page/home.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
