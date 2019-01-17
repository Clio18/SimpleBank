package DAO;

import entity.Client;

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

}
