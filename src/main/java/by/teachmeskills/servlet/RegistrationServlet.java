package by.teachmeskills.servlet;

import by.teachmeskills.dao.UserDao;
import by.teachmeskills.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    private final UserDao userDao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/pages/registration.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("password").equals(req.getParameter("conf_password"))) {
            User user = new User();
            user.setFirstName(req.getParameter("first_name"));
            user.setLastName(req.getParameter("last_name"));
            user.setAge(Integer.parseInt(req.getParameter("age")));
            user.setLogin(req.getParameter("login"));
            user.setPassword(req.getParameter("password"));
            if (userDao.checkLogin(user.getLogin())) {
                resp.sendRedirect("/registration");
            } else {
                userDao.add(user);
                resp.sendRedirect(req.getContextPath() + "/login");
            }
        } else {
            resp.sendRedirect("/registration");
        }
    }
}
