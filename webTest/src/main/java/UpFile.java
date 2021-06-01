import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

@MultipartConfig
public class UpFile extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        //1.得到图片对象
        Part part = request.getPart("myfile");
        //2.将图片保存到某个位置
        UUID uuid = UUID.randomUUID();
        part.write("D:\\Wrj\\bite\\" + uuid + part.getSubmittedFileName());

        PrintWriter writer = response.getWriter();
        writer.println("上传成功");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
