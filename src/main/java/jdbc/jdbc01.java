package jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class jdbc01 {
    public static void main(String[] args) {
        Connection con = null;
        List list = new ArrayList();
        try {
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //使用驱动管理工具 获取连接  url 数据库地址+数据库名  user 数据库名 passw
            String url = "jdbc:mysql://localhost:3306/crashcourse ";
            con = DriverManager.getConnection(url, "root", "banyuan");

            Statement statement = con.createStatement();//专门对sql语句进行处理
            statement.setMaxRows(5);
            String sql = "select * from orders";
            ResultSet resultSet = statement.executeQuery(sql);//获取处理之后的结果集

            while (resultSet.next()) {
                Orders or = new Orders();
                or.setOrder_num(resultSet.getInt(1));
                or.setData(resultSet.getString(2));
                or.setCust_id(resultSet.getInt(3));
                list.add(or);
            }

            for (Object o : list) {
                Orders o2 = (Orders) o;
                System.out.println(o2);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

