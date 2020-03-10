package com.axw.Util;

import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
    private static final String diver="com.mysql.jdbc.Driver";
    private static final String url="jdbc:mysql://localhost:3306/axw?characterEncoding=UTF-8&useSSL=true";
    private static final String username="root";
    private static final String password="axw112630";
    private static Connection connection=null;

    public static Connection getConnection(){
        try {
            Class.forName(diver);
            connection= (Connection) DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
    public static void closeConnection(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

class JDBCUtiltest{
    public static void main(String[] args) throws SQLException {
        Connection connection=JDBCUtil.getConnection();
        System.out.println(connection.hashCode());
        String sql="select * from axw.books";
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery(sql);
        while(resultSet.next()){
            String bookID=resultSet.getString("bookID");
            String bookName=resultSet.getString("bookName");
            String bookCounts=resultSet.getString("bookCounts");
            String detail=resultSet.getString("detail");
            System.out.print(" bookID: "+bookID);
            System.out.print(" bookName: "+bookName);
            System.out.print(" bookCounts: "+bookCounts);
            System.out.println(" detail: "+detail);
        }
       JDBCUtil.closeConnection();
    }
}
