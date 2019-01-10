package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    @Override
    public List<String> showInfo() {
        List<String> list = new ArrayList<>();
        String info = null;
        ResultSet rs;
        try {
            st = con.createStatement();
            String sql = "SELECT * FROM CLIENT";
            rs = st.executeQuery(sql);
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

    @Override
    public boolean hasUser(String username, String password) {
        return false;
    }
}
