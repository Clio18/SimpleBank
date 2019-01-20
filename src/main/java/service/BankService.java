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
            list.add(showUserInfo(client));
        }
        return list;
    }

    public <T> String showUserInfo(T t) {
        String requestInfo = null;
        if (t.getClass().getSimpleName().equals("Client")) {
            requestInfo = t.toString();
        } else if (t.getClass().getSimpleName().equals("Account")) {
            requestInfo = t.toString();
        }
        return requestInfo;
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
            list.add(showUserInfo(account));
        }
        return list;
    }

    public void confirmRequestClientID(String param) {
        int id = Integer.parseInt(param);
        administratorDAO.confirmation(id);


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
}
