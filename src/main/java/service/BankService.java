package service;

import DAO.AdministratorDAO;
import DAO.UserDAO;
import entity.Account;
import entity.Client;
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
    public static String APPROVAL_MESSAGE = "Current request is approved";
    public static String DENY_MESSAGE = "Current request was deny by Administrator";
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

    public List<String> showInfo() {
        List<String> list = new ArrayList<>();
        for (Client client : administratorDAO.showInfoForAdmin()) {
            list.add(client.toString());
        }
        return list;
    }

    public List <String> showUserInfo(Client client) {
        List<String> infoList = new ArrayList<>();
        infoList.add(client.toString());
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


    public List<String> showListOfRequest() {
        List<String> list = new ArrayList<>();
        for (Account account : administratorDAO.showRequestsForAdmin()) {
            list.add(account.toString());
        }
        return list;
    }

    public void confirmRequestClientID(String param) {
        int id = Integer.parseInt(param);
        Account account = administratorDAO.getAccount(id);
        administratorDAO.putAccountToClient(account);
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

    public List<String> showUserAccounts(Client client) {
        List<String> list = new ArrayList<>();
        for (Account account : userDAO.showInfoAccounts(client)) {
            list.add(account.toStringForShowUser());
        }
        return list;
    }

    public List<String> showUserHistory(Client client) {
        List<String> list = new ArrayList<>();
        for (History history : userDAO.showHistory(client)) {
            list.add(history.toString());
        }
        return list;
    }

    public void denyRequest(String param) {
        administratorDAO.denyRequest(Integer.parseInt(param));
    }

    public Account getAccount(String param) {
        return administratorDAO.getAccount(Integer.parseInt(param));
    }
}
