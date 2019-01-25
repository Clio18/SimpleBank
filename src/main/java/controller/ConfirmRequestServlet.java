package controller;

import entity.Account;
import service.BankService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "confirmRequestServlet", urlPatterns = "/confirm")
public class ConfirmRequestServlet extends HttpServlet {
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
        String param = req.getParameter("id");
        if (bankService.validationID(param).size() != 0) {
            req.setAttribute("alertList", bankService.validationID(param));
            req.getRequestDispatcher("alertIDList.jsp").forward(req, resp);
        } else if (!bankService.hasID(param)) {
            req.setAttribute("alertList", "ID does not exist");
            req.getRequestDispatcher("alertIDList.jsp").forward(req, resp);
        } else {
            int id = Integer.parseInt(param);
            Account account = bankService.getAccount(id);
            bankService.confirmRequestClientID(account);
            bankService.writeHistory(account, BankService.APPROVAL_CREDIT_MESSAGE);
            bankService.denyRequest(id);
            req.getRequestDispatcher("administrator.jsp").forward(req, resp);
        }


    }
}
