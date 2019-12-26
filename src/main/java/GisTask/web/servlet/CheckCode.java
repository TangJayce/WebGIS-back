package GisTask.web.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @author Jayce
 * @date 2019/10/7
 */
@WebServlet("/CheckCode")
public class CheckCode extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width = 100;
        int height = 40;
        //1.创建一个对象，在内存中的图片(用于制作验证码图片)
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_BGR);
        //2.美化图片
        //2.1填充背景色
        Graphics g = image.getGraphics();//画笔
        g.setColor(Color.PINK);//设置画笔颜色
        g.fillRect(0,0,width,height);//填充颜色
        //2.2画边框
        g.setColor(Color.BLUE);
        g.drawRect(0,0,width-1,height-1);
        //2.3写验证码
        g.setColor(Color.YELLOW);
        g.setFont(new Font("Cambria",Font.BOLD,24));
        String str = "QWQERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm0123456789";//所有字母和数字
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= 4 ; i++) {
            char c = str.charAt(random.nextInt(str.length()));//随机获取一个字符
            sb.append(c);
            g.drawString(c + "", (width / 5) * i - 10, height / 2 + 8);
        }
        HttpSession session = request.getSession();
        session.setAttribute("checkCode",sb.toString());
        //2.4画干扰线
        g.setColor(Color.GREEN);
        for (int i = 0; i < 5; i++) {
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);
            g.drawLine(x1,y1,x2,y2);
        }
        //3.将图片输出到页面显示
        ImageIO.write(image,"jpg",response.getOutputStream());
    }
}
