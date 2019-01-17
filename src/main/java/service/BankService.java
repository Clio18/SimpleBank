package service;

import DAO.AdministratorDAO;
import DAO.UserDAO;
import entity.Client;
import java.util.ArrayList;
import java.util.List;

public class BankService {
    UserDAO userDAO = new UserDAO();
    AdministratorDAO administratorDAO = new AdministratorDAO();

    public boolean hasLogin(String login) {
        return userDAO.hasLogin(login);
    }

    public void createUser(Client client) {
        userDAO.createNewUser(client);
    }

    public List<String> showInfo() {
        List<String> list = new ArrayList<>();
        for (Client client:administratorDAO.showInfoForAdmin()){
            list.add(showUserInfo(client));
        }
        return list;
    }

    public String showUserInfo(Client client) {
        String info = client.getName() + " " +
                client.getLastName() + " " +
                client.getLogin() + " " +
                client.getPassword() + " " +
                client.getType();
        return info;
    }

    public Client getClient(String login, String password) {
      return userDAO.getClient(login, password);
    }

    public void changeTypeToAdmin(String login) {
        Client client = administratorDAO.getClient(login);
        if (client.getType().equals(Client.USER)) {
            administratorDAO.changeType(login, Client.ADMIN);
        }else {
            administratorDAO.changeType(login, Client.USER);
        }
    }

    public void putCurrentToRequest(int id, double money) {
        userDAO.makeRequest(id, money);
    }
}
