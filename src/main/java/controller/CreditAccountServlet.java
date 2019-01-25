package controller;

import entity.Account;
import entity.Client;
import entity.CreditAccount;
import service.BankService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "creditAccountServlet", urlPatterns = "/credit")
public class CreditAccountServlet extends HttpServlet {
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
        int duration = Integer.parseInt(req.getParameter("select"));
        String money_param = req.getParameter("money");
        if (bankService.validationID(money_param).size() == 0) {
            double money = Double.parseDouble(money_param);
            CreditAccount creditAccount = new CreditAccount(money, client.getId(), duration);
            bankService.putCurrentToRequest(client, creditAccount);
            bankService.writeHistory(creditAccount, BankService.CREDIT_REQUEST_MESSAGE);
            req.getRequestDispatcher("mainPage.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("current.jsp").forward(req, resp);
        }
    }

}
