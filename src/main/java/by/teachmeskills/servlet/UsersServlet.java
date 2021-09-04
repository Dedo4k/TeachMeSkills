package by.teachmeskills.servlet;

import by.teachmeskills.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/users")
public class UsersServlet extends HttpServlet {

    private final UserDao userDao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("users", userDao.readAll());
        req.setAttribute("users", userDao.readAll());
        req.getRequestDispatcher("/pages/users.jsp").forward(req, resp);
    }
}
