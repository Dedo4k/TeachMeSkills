package app;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@WebServlet(urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        try (ServletOutputStream out = resp.getOutputStream();
             BufferedReader reader = new BufferedReader(
                     new FileReader("E:\\Documents\\JAVA\\TMS\\web-app\\src\\main\\resources\\hello.html"))) {
            while (reader.ready()) {
                out.write(reader.read());
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (ServletOutputStream out = resp.getOutputStream();
             BufferedReader reader = new BufferedReader(
                     new FileReader("E:\\Documents\\JAVA\\TMS\\web-app\\src\\main\\resources\\post.html"))) {
            while (reader.ready()) {
                out.write(reader.read());
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
