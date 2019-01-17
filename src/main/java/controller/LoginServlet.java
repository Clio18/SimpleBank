package controller;

import DAO.UserDAO;
import entity.Client;
import service.BankService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    public static final String BANK_SERVICE = "bankService";
    private BankService bankService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        bankService = (BankService) servletContext.getAttribute(BANK_SERVICE);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("username");
        String password = req.getParameter("password");
        Client client = bankService.getClient(login, password);

        if (client == null) {
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        } else if (client.getType().equals(Client.ADMIN)) {
            req.getSession().setAttribute("client", client);
            req.getRequestDispatcher("administrator.jsp").forward(req, resp);
        } else {
            req.getSession().setAttribute("username", client.getLogin());
            req.getSession().setAttribute("client", client);
            req.getRequestDispatcher("mainPage.jsp").forward(req, resp);
        }

    }
}