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
import java.util.List;


@WebServlet(name = "showServlet", urlPatterns = "/show")
public class ShowServlet extends HttpServlet {
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
        if (client.getType().equals(Client.ADMIN)) {
            List<Client> info = bankService.showInfo();
            req.setAttribute("info", info);
            req.getRequestDispatcher("showAdmin.jsp").forward(req, resp);
        } else {
            //String info = bankService.showUserInfo(bankService.getClient(client.getLogin(), client.getPassword()));

            List <Client> info = bankService.showUserInfo(client);
            List <Account> accounts = bankService.showUserAccounts(client);
            List <CreditAccount> creditAccounts = bankService.showUserCreditAccounts(client);
            List <String> history = bankService.showUserHistory(client);

            req.setAttribute("info", info);
            req.setAttribute("accounts", accounts);
            req.setAttribute("creditAccounts", creditAccounts);
            req.setAttribute("history", history);
            req.getRequestDispatcher("showUser.jsp").forward(req, resp);

        }
    }
}
