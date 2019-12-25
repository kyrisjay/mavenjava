package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IDUSSql {

    public static void select() {
        try {
            Connection con = Tools.getConnection();
            String sql = "select * from orders";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
