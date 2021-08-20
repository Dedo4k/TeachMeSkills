package app;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet(urlPatterns = "/welcome-page")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        try (ServletOutputStream out = resp.getOutputStream();
             BufferedReader reader = new BufferedReader(
                     new FileReader("E:\\Documents\\JAVA\\TMS\\web-app\\src\\main\\resources\\home-page.html"))) {
            while (reader.ready()) {
                out.write(reader.read());
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
