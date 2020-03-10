package com.axw.Dao;

import com.axw.Pojo.Teacher;
import com.axw.Util.JDBCUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TeacherDao {
    public Teacher getTeacherByID(String id) throws SQLException {
        Connection connection=JDBCUtil.getConnection();
        String sql="select * from axw.teacher where id = "+id+";";
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery(sql);
       if(resultSet.next()){
            Teacher teacher=new Teacher();
            teacher.setId(resultSet.getString("id"));
            teacher.setName(resultSet.getString("name"));
            teacher.setPassword(resultSet.getString("password"));
            connection.close();
            return teacher;
        }
        connection.close();
        return null;
    }
}
