package DAO;

import entity.Account;
import entity.Client;
import entity.CreditAccount;
import entity.History;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {
    Connection con;
    Statement st;

    public UserDAO() {
        try {
            this.con = BankPaymentsConnection.getConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean hasLogin(String login) {
        boolean flag = false;
        ResultSet rs = null;
        try {
            st = con.createStatement();
            String sql = "SELECT * FROM CLIENT WHERE login = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, login);
            rs = ps.executeQuery();
            flag = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public void createNewUser(Client client) {
        try {
            // st = con.createStatement();
            String sql = "INSERT INTO CLIENT"
                    + "(FIRSTNAME, LASTNAME, LOGIN, PASSWORD, TYPE) VALUES"
                    + "(?,?,?,?,?)";
            PreparedStatement prep = con.prepareStatement(sql);
            prep.setString(1, client.getName());
            prep.setString(2, client.getLastName());
            prep.setString(3, client.getLogin());
            prep.setString(4, client.getPassword());
            prep.setString(5, Client.USER);
            prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Client getClient(String login, String password) {
        Client client = null;
        ResultSet rs;
        try {
            st = con.createStatement();
            String sql = "SELECT * FROM CLIENT WHERE login = ? AND password = ?";
            PreparedStatement prep = con.prepareStatement(sql);
            prep.setString(1, login);
            prep.setString(2, password);
            rs = prep.executeQuery();
            while (rs.next()) {
                client = new Client(
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("login"),
                        rs.getString("password"),
                        rs.getString("type"),
                        rs.getInt("id_client"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }

    public void makeRequest(Client client, Account account) {
        try {
            st = con.createStatement();
            String sql = "INSERT INTO REQUEST"
                    + "(MONEY, ID_CLIENT, TYPE, DURATION) VALUES"
                    + "(?,?,?,?)";
            PreparedStatement prep = con.prepareStatement(sql);
            prep.setDouble(1, account.getMoney());
            prep.setInt(2, client.getId());
            prep.setString(3, account.getClass().getSimpleName());
            prep.setInt(4, account.getDuration());
            prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void writeHistory(History history, String message) {
        try {
            st = con.createStatement();
            String sql = "INSERT INTO HISTORY"
                    + "(ACCOUNT_TYPE, MONEY, ID_CLIENT, DATE, MESSAGE) VALUES"
                    + "(?,?,?,?,?)";
            PreparedStatement prep = con.prepareStatement(sql);
            prep.setString(1, history.getAccount_type());
            prep.setDouble(2, history.getMoney());
            prep.setInt(3, history.getId_client());
            prep.setString(4, history.getDate());
            prep.setString(5, message);
            prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<History> showHistory(Client client) {
        List<History> list = new ArrayList<>();
        History history = null;
        ResultSet rs;
        try {
            st = con.createStatement();
            String sql = "SELECT ACCOUNT_TYPE, MONEY, DATE, MESSAGE FROM HISTORY WHERE ID_CLIENT = ?";
            PreparedStatement prep = con.prepareStatement(sql);
            prep.setInt(1, client.getId());
            rs = prep.executeQuery();
            while (rs.next()) {
                history = new History(
                        rs.getString("account_type"),
                        rs.getDouble("money"),
                        rs.getString("date"),
                        rs.getString("message"));
                list.add(history);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Account> showInfoAccounts(Client client) {
        List<Account> list = new ArrayList<>();
        Account account = null;
        ResultSet rs;
        try {
            st = con.createStatement();
            String sql = "SELECT * FROM CURRENT_ACCOUNT WHERE id_client=?";
            PreparedStatement prep = con.prepareStatement(sql);
            prep.setInt(1, client.getId());
            rs = prep.executeQuery();
            while (rs.next()) {
                account = new Account(
                        rs.getInt("id_current"),
                        rs.getDouble("money"),
                        rs.getString("type"));
                list.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<CreditAccount> showInfoCredits(Client client) {
        List<CreditAccount> list = new ArrayList<>();
        Account account = null;
        ResultSet rs;
        try {
            st = con.createStatement();
            String sql = "SELECT * FROM CREDIT_ACCOUNT WHERE id_client=?";
            PreparedStatement prep = con.prepareStatement(sql);
            prep.setInt(1, client.getId());
            rs = prep.executeQuery();
            while (rs.next()) {
                account = new CreditAccount(
                        rs.getInt("id_credit"),
                        rs.getDouble("money"),
                        rs.getString("type"),
                        rs.getDouble("sum_rate"),
                        rs.getInt("duration"),
                        rs.getDouble("withdraw"));
                list.add((CreditAccount) account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean hasIDAccount(int id) {
        boolean flag = false;
        ResultSet rs = null;
        try {
            st = con.createStatement();
            String sql = "SELECT * FROM CURRENT_ACCOUNT WHERE id_current = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            flag = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean hasIDCredit(int id) {
        boolean flag = false;
        ResultSet rs = null;
        try {
            st = con.createStatement();
            String sql = "SELECT * FROM CREDIT_ACCOUNT WHERE id_credit = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            flag = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public Account getCurrentAccount(int current_id) {
        Account account = null;
        ResultSet rs;
        try {
            st = con.createStatement();
            String sql = "SELECT * FROM CURRENT_ACCOUNT WHERE id_current = ?";
            PreparedStatement prep = con.prepareStatement(sql);
            prep.setInt(1, current_id);

            rs = prep.executeQuery();
            while (rs.next()) {
                account = new Account(
                        rs.getDouble("money"),
                        rs.getInt("id_client"),
                        rs.getString("type"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    public CreditAccount getCreditAccount(int current_id) {
        CreditAccount creditAccount = null;
        ResultSet rs;
        try {
            st = con.createStatement();
            String sql = "SELECT * FROM CREDIT_ACCOUNT WHERE id_credit = ?";
            PreparedStatement prep = con.prepareStatement(sql);
            prep.setInt(1, current_id);
            rs = prep.executeQuery();
            while (rs.next()) {
                creditAccount = new CreditAccount(
                        rs.getInt("id_credit"),
                        rs.getDouble("money"),
                        rs.getString("type"),
                        rs.getDouble("sum_rate"),
                        rs.getInt("duration"),
                        rs.getDouble("withdraw"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return creditAccount;
    }

    public void changeCurrent(int id_curr, int mon) {
        Account account = getCurrentAccount(id_curr);
        double new_balance = account.getMoney() - mon;
        try {
            st = con.createStatement();
            String sql = "UPDATE CURRENT_ACCOUNT SET money=? WHERE id_current=?";
            PreparedStatement prep = con.prepareStatement(sql);
            prep.setInt(2, id_curr);
            prep.setDouble(1, new_balance);
            prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void changeCredit(int desire_id, int mon) {
        CreditAccount account = getCreditAccount(desire_id);
        double new_balance = account.getWithdraw() - mon;
        try {
            st = con.createStatement();
            String sql = "UPDATE CREDIT_ACCOUNT SET withdraw=? WHERE id_credit=?";
            PreparedStatement prep = con.prepareStatement(sql);
            prep.setInt(2, desire_id);
            prep.setDouble(1, new_balance);
            prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
