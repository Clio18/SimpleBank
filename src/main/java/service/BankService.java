package service;

import DAO.UserDAO;

public class BankService {
    public static final String LOGIN_IS_TAKEN = "This login already taken!";
    public static final String USER_IS_EXIST = "This client is already exist!";
    public static final String WRONG_LOGIN = "Wrong login!";
    public static final String CUREENT_ACCOUNT_REQUEST = "Current account was requested: ";
    UserDAO userDAO = new UserDAO();

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
}
