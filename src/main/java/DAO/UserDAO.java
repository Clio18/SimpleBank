package DAO;

import entity.Client;

import java.sql.*;

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
            st = con.createStatement();
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

    public void makeRequest(int id, double money) {
        try {
            st = con.createStatement();
            String sql = "INSERT INTO REQUEST"
                    + "(MONEY, ID_CLIENT) VALUES"
                    + "(?,?)";
            PreparedStatement prep = con.prepareStatement(sql);
            prep.setDouble(1, money);
            prep.setInt(2, id);
            prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public void putHistory(int id, String history, String date){
//        ResultSet rs;
//        try {
//            st = con.createStatement();
//            String sql = "INSERT INTO HISTORY"
//                    + "(ID, HISTORY, DATE) VALUES"
//                    + "(?,?,?)";
//            PreparedStatement prep = con.prepareStatement(sql);
//            prep.setInt(1, id);
//            prep.setString(2, history);
//            prep.setString(3, date);
//            prep.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}
