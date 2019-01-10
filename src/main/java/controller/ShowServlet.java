package controller;

import DAO.AdministratorDAO;
import DAO.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "showServlet", urlPatterns = "/show")
public class ShowServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAO();
    private AdministratorDAO adminDAO = new AdministratorDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getSession().getAttribute("username").toString();
        System.out.print("show ");
        System.out.println(login);

        if(login.equals("admin")){
            List<String> info = adminDAO.showInfo();
            req.setAttribute("info", info);
            req.getRequestDispatcher("show.jsp").forward(req, resp);
        }else {
            List<String> info = userDAO.showUserInfo(login);
            req.setAttribute("info", info);
            req.getRequestDispatcher("show.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }
}
