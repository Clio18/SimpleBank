package controller;

import entity.Client;
import service.BankService;
import util.Validator;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "RegistrationServlet", urlPatterns = "/user_form")
public class RegistrationServlet extends HttpServlet {
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
        req.getRequestDispatcher("registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String lastName = req.getParameter("lastName");
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        Client client = new Client(name, lastName, login, password, Client.USER);
        if (bankService.validation(client).size() != 0) {
            req.setAttribute("alertList", bankService.validation(client));
            req.getRequestDispatcher("alertList.jsp").forward(req, resp);
        } else if (bankService.hasLogin(client.getLogin())) {
            req.setAttribute("alertList", "Login already taken");
            req.getRequestDispatcher("alertList.jsp").forward(req, resp);
        } else {
            bankService.createUser(client);
            req.getSession().setAttribute("username", login);
            req.getSession().setAttribute("client", client);
            req.getRequestDispatcher("mainPage.jsp").forward(req, resp);
        }
    }
}
