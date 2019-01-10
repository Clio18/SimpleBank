package controller;

import DAO.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "currentAccountServlet", urlPatterns = "/current")
public class CurrentAccountServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getSession().getAttribute("username").toString();
        double money = Double.parseDouble(req.getParameter("money"));
        userDAO.makeRequestForCurrentAccount(login, money);
    }

}
