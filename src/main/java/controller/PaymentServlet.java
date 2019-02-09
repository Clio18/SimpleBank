package controller;

import service.BankService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "paymentServlet", urlPatterns = "/payment")
public class PaymentServlet extends HttpServlet {
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

        String current_id = req.getParameter("current_id");
        String desire_id = req.getParameter("desire_id");
        String money = req.getParameter("money");


        if (bankService.validationID(current_id).size() != 0 | bankService.validationID(desire_id).size() != 0 | bankService.validationID(money).size() != 0) {
            req.setAttribute("alertList", bankService.validationID(current_id));
            req.setAttribute("alertList", bankService.validationID(desire_id));
            req.setAttribute("alertList", bankService.validationID(money));
            req.getRequestDispatcher("alertIDListUser.jsp").forward(req, resp);
        } else if (!bankService.hasIDAccount(current_id) | !bankService.hasIDCredit(desire_id)) {
            req.setAttribute("alertList", "ID does not exist");
            req.getRequestDispatcher("alertIDListUser.jsp").forward(req, resp);
        } else {
            int id_curr = Integer.parseInt(current_id);
            int id_cre = Integer.parseInt(desire_id);
            int mon = Integer.parseInt(money);
            req.setAttribute("alertList", bankService.changeCurrent(id_curr, mon));
            req.getRequestDispatcher("alertIDListUser.jsp").forward(req, resp);


//            bankService.changeCredit(id_cre, mon);
//            Account account = bankService.getCurrentAccount(id_curr);
//            CreditAccount creditAccount = bankService.getCreditAccount(id_cre);
//
//            bankService.writeHistory(account, BankService.PAYMENT + mon);
//            bankService.writeHistory(creditAccount, BankService.CREDIT_PAYMENT);
//
//            req.getRequestDispatcher("mainPage.jsp").forward(req, resp);
        }


    }
}
