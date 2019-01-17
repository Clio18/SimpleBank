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


@WebServlet(name = "currentAccountServlet", urlPatterns = "/current")
public class CurrentAccountServlet extends HttpServlet {
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
        Client client = (Client) req.getSession().getAttribute("client");
       String param = req.getParameter("money");
        if (param.matches("[0-9]+")){
            double money = Double.parseDouble(param);
            bankService.putCurrentToRequest(client.getId(), money);
            req.getRequestDispatcher("mainPage.jsp").forward(req,resp);
        } else {
            req.getRequestDispatcher("current.jsp").forward(req,resp);
        }


        //userDAO.makeRequestForCurrentAccount(login, money);
    }

}
