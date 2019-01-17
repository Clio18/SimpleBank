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

@WebServlet(name = "ChangeTypeServlet", urlPatterns = "/changeType")
public class ChangeTypeServlet extends HttpServlet {
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
        String login = req.getParameter("login");
        if (bankService.hasLogin(login)) {
            bankService.changeTypeToAdmin(login);
            req.getRequestDispatcher("administrator.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("changeType.jsp").forward(req, resp);
        }
    }

}
