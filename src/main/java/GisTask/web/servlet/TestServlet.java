package GisTask.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Jayce
 * @date 2019/10/13
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("-----------------------------------------------");
//        String xing = request.getParameter("xing");
//        String ming = request.getParameter("ming");
//        String huiqianxingshi = request.getParameter("huiqianxingshi");
//        System.out.println("huiqianxingshi = " + huiqianxingshi);
//        System.out.println("xing = " + xing);
//        System.out.println("ming = " + ming);

        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("<h1>测试成功</h1>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
