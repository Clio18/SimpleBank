package controller;

import DAO.UserDAO;
import entity.Client;
import util.Validator;

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
        Validator validator = new Validator();
        Client client = new Client(name, lastName, login, password, "user");
        if (validator.validation(client).size()!=0){
            req.setAttribute("alertList", validator.validation(client));
            req.getRequestDispatcher("alertList.jsp").forward(req,resp);
        } else {
            req.getSession().setAttribute("username", login);
            req.getRequestDispatcher("mainPage.jsp").forward(req, resp);
        }


//        if (userDAO.hasClient(name, lastName, login, password)) {
//            req.setAttribute("alert", UserDAO.USER_IS_EXIST);
//            req.getRequestDispatcher("alert.jsp").forward(req, resp);
//        } else if (userDAO.hasLogin(login)) {
//            req.setAttribute("alert", UserDAO.LOGIN_IS_TAKEN);
//            req.getRequestDispatcher("alert.jsp").forward(req, resp);
//        } else {
//            userDAO.createNewUser(name, lastName, login, password);
//            req.getRequestDispatcher("login.jsp").forward(req, resp);
//        }
    }

}
