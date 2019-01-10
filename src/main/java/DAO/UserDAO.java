package DAO;

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
    public static final String LOGIN_IS_TAKEN = "This login already taken!";
    public static final String USER_IS_EXIST = "This client is already exist!";
    public static final String WRONG_LOGIN = "Wrong login!";
    public static final String CUREENT_ACCOUNT_REQUEST = "Current account was requested: ";

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

    public void createNewUser(String firstname, String lastname, String login, String password) {
        ResultSet rs;
        try {
            //validation of string types and not null!!
            st = con.createStatement();
            String sql = "INSERT INTO CLIENT"
                    + "(ID, FIRSTNAME, LASTNAME, LOGIN, PASSWORD) VALUES"
                    + "(?,?,?,?,?)";
            PreparedStatement prep = con.prepareStatement(sql);
            prep.setInt(1, getLastId());
            prep.setString(2, firstname);
            prep.setString(3, lastname);
            prep.setString(4, login);
            prep.setString(5, password);
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

    public boolean hasClient(String firstName, String lastName, String username, String password) {
        boolean flag = false;
        ResultSet rs = null;
        try {
            st = con.createStatement();
            String sql = "SELECT * FROM CLIENT WHERE firstName =? AND lastName=? AND login = ? AND password = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, username);
            ps.setString(4, password);
            rs = ps.executeQuery();
            flag = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public void showAlert(HttpServletResponse resp, String s) throws IOException {
        PrintWriter writer = resp.getWriter();
        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<body>");
        writer.println(s);
        writer.println("</body>");
        writer.println("</html>");
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
            String history = UserDAO.CUREENT_ACCOUNT_REQUEST;
            putHistory(id, history, date);

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
