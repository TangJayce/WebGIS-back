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
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("-----------------------------------------------");
        String name = request.getParameter("user_name").trim();
        String password = request.getParameter("user_password");
        User loginUser = new User(name,password);
        System.out.println("有用户登录  ==> " + name + " : " + password);

        UserService service = new UserServiceImpl();
        User user = service.login(loginUser);

        if (user == null) {
            //登录失败
            System.out.println("登录失败");
            request.setAttribute("login_state", "0");
        }else {
            //登录成功
            System.out.println("登录成功");
            request.getSession().setAttribute("user", user);
            request.getSession().setAttribute("login_state", "1");
        }
        request.getRequestDispatcher("/page/home.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
