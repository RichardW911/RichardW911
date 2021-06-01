import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class test extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        String name1 = "王睿杰";
        String name2 = "蒋宇航";
        String name3 = "梁浩阳";
        String s = req.getParameter("myname");
        PrintWriter writer = resp.getWriter();
        if(s.equals(name1)) {
            writer.println("<h1>贼高</h1>");
        }else if(s.equals(name2)) {
            writer.println("<h1>贼帅</h1>");
        }else if(s.equals(name3)) {
            writer.println("<h1>贼有钱</h1>");
        }else {
            writer.println("输入有误！");
        }
    }
}
