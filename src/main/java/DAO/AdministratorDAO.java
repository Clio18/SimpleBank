package DAO;

import entity.Account;
import entity.Client;
import entity.CreditAccount;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdministratorDAO implements IUserDAO {
    Connection con;
    Statement st;

    public AdministratorDAO() {
        try {
            this.con = BankPaymentsConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Client> showInfoForAdmin() {
        List<Client> list = new ArrayList<>();
        Client client = null;
        ResultSet rs;
        try {
            st = con.createStatement();
            String sql = "SELECT * FROM CLIENT";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                client = new Client(rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("login"),
                        rs.getString("password"),
                        rs.getString("type"),
                        rs.getInt("id_client"));
                list.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void changeType(String login, String type) {
        try {
            st = con.createStatement();
            String sql = "UPDATE CLIENT SET type=? WHERE login=?";
            PreparedStatement prep = con.prepareStatement(sql);
            prep.setString(2, login);
            prep.setString(1, type);
            prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Client getClient(String login) {
        Client client = null;
        ResultSet rs;
        try {
            st = con.createStatement();
            String sql = "SELECT * FROM CLIENT WHERE login = ?";
            PreparedStatement prep = con.prepareStatement(sql);
            prep.setString(1, login);
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

    public List<Account> showRequestsForAdmin() {
        List<Account> list = new ArrayList<>();
        Account account = null;
        ResultSet rs;
        try {
            st = con.createStatement();
            String sql = "SELECT * FROM REQUEST";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                account = new Account(rs.getInt("id_request"),
                        rs.getDouble("money"),
                        rs.getInt("id_client"),
                        rs.getString("type"),
                        rs.getInt("duration"));
                list.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean hasID(int id) {
        boolean flag = false;
        ResultSet rs = null;
        try {
            st = con.createStatement();
            String sql = "SELECT * FROM REQUEST WHERE id_request = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            flag = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public String getType(int id) {
        ResultSet rs;
        String type = null;
        try {
            st = con.createStatement();
            String sql_type = "SELECT TYPE FROM REQUEST WHERE id_request = ?";
            PreparedStatement preparedStatement = con.prepareStatement(sql_type);
            preparedStatement.setInt(1, id);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                type = rs.getString("type");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return type;
    }

    public Account getAccount(int id) {
        Account account = null;
        ResultSet rs;
        String type = getType(id);
        try {
            if (type.equals("Account")) {
                String sql = "SELECT * FROM REQUEST WHERE id_request = ?";
                PreparedStatement prep = con.prepareStatement(sql);
                prep.setInt(1, id);
                rs = prep.executeQuery();
                while (rs.next()) {
                    account = new Account(rs.getDouble("money"),
                            rs.getInt("id_client"),
                            rs.getString("type"));
                }
                return account;
            } else if (type.equals("CreditAccount")) {
                String sql = "SELECT * FROM REQUEST WHERE id_request = ?";
                PreparedStatement prep = con.prepareStatement(sql);
                prep.setInt(1, id);
                rs = prep.executeQuery();
                account = null;
                while (rs.next()) {
                    account = new CreditAccount(rs.getDouble("money"),
                            rs.getInt("id_client"),
                            rs.getString("type"),
                            rs.getInt("duration"));
                }
                return account;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    public void putAccountToClient(Account account) {
        try {
            st = con.createStatement();
            String sql = "INSERT INTO CURRENT_ACCOUNT"
                    + "(TYPE, MONEY, ID_CLIENT) VALUES"
                    + "(?,?,?)";
            PreparedStatement prep = con.prepareStatement(sql);
            prep.setString(1, account.getType());
            prep.setDouble(2, account.getMoney());
            prep.setInt(3, account.getId_client());
            prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void putCreditToClient(Account account, double rate, double withdraw){
        try {
            st = con.createStatement();
            String sql = "INSERT INTO CREDIT_ACCOUNT"
                    + "(TYPE, MONEY, ID_CLIENT, DURATION, SUM_RATE, WITHDRAW) VALUES"
                    + "(?,?,?,?,?,?)";
            PreparedStatement prep = con.prepareStatement(sql);
            prep.setString(1, account.getType());
            prep.setDouble(2, account.getMoney());
            prep.setInt(3, account.getId_client());
            prep.setInt(4, account.getDuration());
            prep.setDouble(5, rate);
            prep.setDouble(6, withdraw);
            prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void denyRequest(int id) {
        try {
            st = con.createStatement();
            String sql = "DELETE FROM REQUEST WHERE id_request = ?";
            PreparedStatement prep = con.prepareStatement(sql);
            prep.setInt(1, id);
            prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
