package controller;

import DAO.UserDAO;
import util.Validator;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegistrationServlet", urlPatterns = "/login")
public class RegistrationServlet extends HttpServlet {
    public static final String USER_SERVICE = "userService";
    private UserDAO userService;

    //do not understand!
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        userService = (UserDAO) servletContext.getAttribute(USER_SERVICE);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("j_username");
        String password = req.getParameter("j_password");

        if (username.isEmpty() && password.isEmpty()) {
            req.getRequestDispatcher("registration.jsp").forward(req, resp);
        } else if (!Validator.isCorrectString(username)) {
            userService.showAlert(resp, UserDAO.WRONG_LOGIN);
        } else if (username.equals("admin") && password.equals("admin")) {
            req.getSession().setAttribute("username", username);
            req.getRequestDispatcher("administrator.jsp").forward(req, resp);
        } else if (userService.hasUser(username, password)) {
            req.getSession().setAttribute("username", username);
            req.getRequestDispatcher("mainPage.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("registration.jsp").forward(req, resp);
        }
    }
}