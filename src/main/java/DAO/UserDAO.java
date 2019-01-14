package DAO;

import entity.Client;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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

    @Override
    public List<String> showInfo() {
        return null;
    }

    @Override
    public boolean hasUser(String login, String password) {
        boolean flag = false;
        ResultSet rs = null;
        try {
            st = con.createStatement();
            String sql = "SELECT * FROM CLIENT WHERE login = ? AND password = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, login);
            ps.setString(2, password);
            rs = ps.executeQuery();
            flag = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
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

    public List<String> showUserInfo(String login) {
        List<String> list = new ArrayList<>();
        String info = null;
        ResultSet rs;
        try {
            st = con.createStatement();
            String sql = "SELECT * FROM CLIENT WHERE login = ?";
            PreparedStatement prep = con.prepareStatement(sql);
            prep.setString(1, login);
            rs = prep.executeQuery();
            while (rs.next()) {
                info = rs.getString("id") + " "
                        + rs.getString("firstname") + " "
                        + rs.getString("lastname") + " "
                        + rs.getString("login") + " "
                        + rs.getString("password");
                list.add(info);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void createNewUser(Client client) {
        ResultSet rs;
        try {
            //validation of string types and not null!!
            st = con.createStatement();
            String sql = "INSERT INTO CLIENT"
                    + "(ID, FIRSTNAME, LASTNAME, LOGIN, PASSWORD) VALUES"
                    + "(?,?,?,?,?)";
            PreparedStatement prep = con.prepareStatement(sql);
            prep.setInt(1, getLastId());
            prep.setString(2, client.getName());
            prep.setString(3, client.getLastName());
            prep.setString(4, client.getLogin());
            prep.setString(5, client.getPassword());
            prep.setString(6, client.getType());
            rs = prep.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getLastId() {
        ResultSet rs;
        int idNew = 0;
        try {
            st = con.createStatement();
            String sql = "SELECT MAX(id) FROM CLIENT";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                idNew = rs.getInt(1);
            }
            idNew = idNew + 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idNew;
    }

    public boolean hasClient(Client client) {
        boolean flag = false;
        ResultSet rs = null;
        try {
            st = con.createStatement();
            String sql = "SELECT * FROM CLIENT WHERE firstName =? AND lastName=? AND login = ? AND password = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, client.getName());
            ps.setString(2, client.getLastName());
            ps.setString(3, client.getLogin());
            ps.setString(4, client.getPassword());
            rs = ps.executeQuery();
            flag = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public void makeRequestForCurrentAccount(String login, double money) {
        ResultSet rs;
        try {
            st = con.createStatement();
            String sql = "INSERT INTO REQUEST"
                    + "(ID, MONEY) VALUES"
                    + "(?,?)";
            int id = getID(login);
            System.out.println(id);

            PreparedStatement prep = con.prepareStatement(sql);
            prep.setInt(1, id);
            prep.setDouble(2, money);

            String date = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime());
            //String history = UserDAO.CUREENT_ACCOUNT_REQUEST;
            //putHistory(id, history, date);

            prep.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void putHistory(int id, String history, String date){
        ResultSet rs;
        try {
            st = con.createStatement();
            String sql = "INSERT INTO HISTORY"
                    + "(ID, HISTORY, DATE) VALUES"
                    + "(?,?,?)";
            PreparedStatement prep = con.prepareStatement(sql);
            prep.setInt(1, id);
            prep.setString(2, history);
            prep.setString(3, date);
            prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getID(String login) {
        int info = -1;
        ResultSet rs;
        try {
            st = con.createStatement();
            String sql = "SELECT ID FROM CLIENT WHERE login = ?";
            PreparedStatement prep = con.prepareStatement(sql);
            prep.setString(1, login);
            rs = prep.executeQuery();
            while (rs.next()) {
                info = rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return info;
    }
}
