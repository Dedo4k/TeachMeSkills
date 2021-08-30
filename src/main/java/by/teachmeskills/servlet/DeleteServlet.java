package by.teachmeskills.servlet;

import by.teachmeskills.dao.UserDao;
import by.teachmeskills.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

    private final UserDao userDao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        if (user != null) {
            userDao.delete(user.getId());
            req.getSession().invalidate();
        }
        resp.sendRedirect(req.getContextPath() + "/login");
    }
}
