package DAO;

import entity.Client;

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
                        rs.getString("type"));
                list.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
