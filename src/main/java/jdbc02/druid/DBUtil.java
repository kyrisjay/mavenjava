package jdbc02.druid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    static Connection con = null;

    public static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/crashcourse";
        String driver = "com.mysql.cj.jdbc.Driver";
        String user = "root";
        String password = "banyuan";
        try {
            Class.forName(driver);
            try {
                con = DriverManager.getConnection(url, user, password);
                return con;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void closeCon() {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
