package service;

import DAO.AdministratorDAO;
import DAO.UserDAO;
import entity.Account;
import entity.Client;
import entity.CreditAccount;
import entity.History;
import util.Validator;
import util.ValidatorID;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BankService {
    public static String CURRENT_REQUEST_MESSAGE = "Current request created";
    public static String CREDIT_REQUEST_MESSAGE = "Credit request created";
    public static String APPROVAL_MESSAGE = "Current request is approved";
    public static String APPROVAL_CREDIT_MESSAGE = "Credit request is approved";
    public static String DENY_MESSAGE = "Current request was deny by Administrator";
    public static String DENY_CREDIT_MESSAGE = "Credit request was deny by Administrator";
    public static String PAYMENT = "Your payment was done. Money for payment is ";
    public static String CREDIT_PAYMENT = "Your credit payment was done";
    public static double CREDIT_RATE = 5.0;

    UserDAO userDAO = new UserDAO();
    AdministratorDAO administratorDAO = new AdministratorDAO();
    ValidatorID validatorID = new ValidatorID();
    Validator validator = new Validator();

    public boolean hasLogin(String login) {
        return userDAO.hasLogin(login);
    }

    public void createUser(Client client) {
        userDAO.createNewUser(client);
    }

    public List<Client> showInfo() {
        List<Client> list = new ArrayList<>();
        for (Client client : administratorDAO.showInfoForAdmin()) {
            list.add(client);
        }
        return list;
    }

    public List<Client> showUserInfo(Client client) {
        List<Client> infoList = new ArrayList<>();
        infoList.add(client);
        return infoList;
    }

    public Client getClient(String login, String password) {
        return userDAO.getClient(login, password);
    }

    public void changeTypeToAdmin(String login) {
        Client client = administratorDAO.getClient(login);
        if (client.getType().equals(Client.USER)) {
            administratorDAO.changeType(login, Client.ADMIN);
        } else {
            administratorDAO.changeType(login, Client.USER);
        }
    }

    public void putCurrentToRequest(Client client, Account account) {
        userDAO.makeRequest(client, account);
    }

    public List<Account> showListOfRequest() {
        List<Account> list = new ArrayList<>();
        for (Account account : administratorDAO.showRequestsForAdmin()) {
            list.add(account);
        }
        return list;
    }

    public void confirmRequestClientID(Account account) {
        if (account.getType().equals("Account")) {
            administratorDAO.putAccountToClient(account);
        } else if (account.getType().equals("CreditAccount")) {
            double withdraw = getWithdraw(account.getMoney());
            double sum_rate = withdraw - account.getMoney();
            administratorDAO.putCreditToClient(account, sum_rate, withdraw);
        }
    }

    public double getWithdraw(double money) {
        return money + (money * BankService.CREDIT_RATE / 100);
    }

    public boolean hasID(String id) {
        int request_id = Integer.parseInt(id);
        return administratorDAO.hasID(request_id);
    }

    public List<String> validation(Client client) {
        return validator.validation(client);
    }

    public List<String> validationID(String param) {
        return validatorID.validation(param);
    }

    public void writeHistory(Account account, String message) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        History history = new History(account.getClass().getSimpleName(), account.getMoney(), account.getId_client(), dateFormat.format(date));
        userDAO.writeHistory(history, message);
    }

    public List<Account> showUserAccounts(Client client) {
        List<Account> listAccount = new ArrayList<>();
        for (Account account : userDAO.showInfoAccounts(client)) {
            listAccount.add(account);
        }
        return listAccount;
    }

    public List<CreditAccount> showUserCreditAccounts(Client client) {
        List<CreditAccount> listAccount = new ArrayList<>();
        for (CreditAccount creditAccount : userDAO.showInfoCredits(client)) {
            listAccount.add(creditAccount);
        }
        return listAccount;
    }

    public List<History> showUserHistory(Client client) {
        List<History> list = new ArrayList<>();
        for (History history : userDAO.showHistory(client)) {
            list.add(history);
        }
        return list;
    }

    public void denyRequest(int id) {
        administratorDAO.denyRequest(id);
    }

    public Account getAccount(int id) {
        return administratorDAO.getAccount(id);
    }

    public boolean hasIDAccount(String current_id) {
        int request_id = Integer.parseInt(current_id);
        return userDAO.hasIDAccount(request_id);
    }

    public boolean hasIDCredit(String desire_id) {
        int request_id = Integer.parseInt(desire_id);
        return userDAO.hasIDCredit(request_id);
    }

    public Account getCurrentAccount(int current_id) {
        return userDAO.getCurrentAccount(current_id);
    }

    public List<String> changeCurrent(int id_curr, int mon) {
        Account account = getCurrentAccount(id_curr);
        List<String> message = new ArrayList<>();

        System.out.println(account.getMoney());
        System.out.println(mon);

        if (account.getMoney() < mon) {
            message.add("The sum of money is too large!");
        } else {
            //userDAO.changeCurrent(id_curr, mon);
            message.add("Success operation");
        }
        return message;
    }

    public CreditAccount getCreditAccount(int id_cre) {
        return userDAO.getCreditAccount(id_cre);
    }

    public void changeCredit(int desire_id, int mon) {
        userDAO.changeCredit(desire_id, mon);
    }
}
