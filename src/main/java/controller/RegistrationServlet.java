package controller;

import DAO.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "RegistrationServlet", urlPatterns = "/user_form")
public class RegistrationServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("j_name");
        String lastName = req.getParameter("j_lastName");
        String login = req.getParameter("j_login");
        String password = req.getParameter("j_password");

        if (userDAO.hasClient(name, lastName, login, password)) {
            userDAO.showAlert(resp, UserDAO.USER_IS_EXIST);
        } else if (userDAO.hasLogin(login)) {
            userDAO.showAlert(resp, UserDAO.LOGIN_IS_TAKEN);
        } else {
            userDAO.createNewUser(name, lastName, login, password);
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }

}
