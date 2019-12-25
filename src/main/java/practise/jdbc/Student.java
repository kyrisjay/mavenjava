package practise.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Student {


    static String creatSql = "create table student("
            + "stuNum int(4) primary key auto_increment,"
            + "stuName varchar(255) not null,"
            + "stuScore int(255) not null,"
            + "address varchar(255) not null,"
            + "data varchar(255) not null"
            + ");";

    final static String url = "jdbc:mysql://localhost:3306/crashcourse";
    final static String driver = "com.mysql.cj.jdbc.Driver";
    final static String user = "root";
    final static String password = "banyuan";

    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement statement = null;
        List list = new ArrayList();

        try {
            Class.forName(driver);
            try {
                con = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                //创建表
//                statement=con.createStatement();
//                if (statement.executeLargeUpdate(creatSql)==0){
//                    System.out.println("成功创建表");
//                }else{
//                    System.out.println("创建表失败");
//                }
                String sql1 = "insert into student(stuName,stuScore,address,data) values('张三',65,'半圆学社','2019-10-12');";
                String sql2 = "insert into student(stuName,stuScore,address,data) values('花爷',75,'半圆学社','2019-10-13');";
                String sql3 = "insert into student(stuName,stuScore,address,data) values('周二',85,'半圆学社','2019-10-14');";
                String sql4 = "insert into student(stuName,stuScore,address,data) values('周三',85,'半圆学社','2019-10-14');";
                String sql5 = "insert into student(stuName,stuScore,address,data) values('李四',85,'半圆学社','2019-10-14');";
                String sql10 = "insert into student(stuName,stuScore,address,data) values('花无缺',90,'半圆学社','2019-10-14');";
                String sql11 = "insert into student(stuName,stuScore,address,data) values('小鱼儿',85,'半圆学社','2019-10-14');";
                String sql12 = "insert into student(stuName,stuScore,address,data) values('周通',70,'半圆学社','2019-10-15');";

                String sql6 = "delete from student where stuName='张三';";
                String sql7 = "update student set stuName='周五' where stuNum=4;";
                String sql8 = "select * from student where stuName like '%花%';";
                String sql9 = "update student set stuScore=stuScore+5 where stuName like '周%';";

                //批量插入;批量删除
//                String sql13 = "insert into student(stuName,stuScore,address,data) values(?,?,?,?);";
                String sql14 = "delete from student where stuName like ?;";
//                Student2 stu2 = new Student2("小龙女", 67, "南京", "2019-10-10");
//                Student2 stu3 = new Student2("杨过", 67, "南京", "2019-10-10");
//                Student2 stu4 = new Student2("斑", 75, "南京", "2019-10-10");
//                Student2 stu5 = new Student2("千手", 80, "南京", "2019-10-10");
                List list1 = new ArrayList();
//                list1.add(stu2);
//                list1.add(stu3);
//                list1.add(stu4);
//                list1.add(stu5);

                list1.add("杨%");
                list1.add("斑%");
               statement=con.prepareStatement(sql14);
                for (Object o : list1) {
//                    Student2 student2 = (Student2) o;
//                    statement.setString(1, student2.getStuName());
//                    statement.setInt(2, student2.getStuScore());
//                    statement.setString(3, student2.getAddress());
//                    statement.setString(4, student2.getData());
                String str=(String) o;
                statement.setString(1,str);
                statement.addBatch();
                }
                statement.executeBatch();



                //statement = con.createStatement();
                // statement.executeUpdate(sql13);

                //ResultSet resultSet = statement.executeQuery(sqlÍ8);

//                while (resultSet.next()) {
//                    Student2 stu = new Student2();
//
//                    stu.setStuNum(resultSet.getInt(1));
//                    stu.setStuName(resultSet.getString(2));
//                    stu.setStuScore(resultSet.getInt(3));
//                    stu.setAddress(resultSet.getString(4));
//                    stu.setData(resultSet.getString(5));
//
//                     list.add(stu);
//                }
//                for (Object o : list) {
//                    Student2 stu2 = (Student2) o;
//                    System.out.println(stu2);
//                }

                statement.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
