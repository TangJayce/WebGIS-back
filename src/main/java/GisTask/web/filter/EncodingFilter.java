package GisTask.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author Jayce
 * @date 2019/10/14
 */
@WebFilter("/*")
public class EncodingFilter implements Filter {
    private String encoding;

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding(encoding);
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        encoding = config.getServletContext().getInitParameter("encoding");
        System.out.println("encoding = " + encoding);
    }

    public void destroy() {
    }
}
