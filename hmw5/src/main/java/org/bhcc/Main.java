package org.bhcc;

import java.io.IOException;
import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, SQLException, IOException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
//        // to see how IntelliJ IDEA suggests fixing it.
//        Class.forName("com.mysql.cj.jdbc.Driver");
//
//        //  Create connect string
//        String connectUrl = "jdbc:mysql://localhost/sample";
//
//        //  Create JDBC Connection
//        Connection connection = DriverManager.getConnection(connectUrl, "user", "password");
//
//        //  Create the SQL Statement
//        Statement statement = connection.createStatement();
//
//        //  To query for data, use executeQuery()
//        ResultSet resultSet = statement.executeQuery("select * from WEB_USER");
//
//        //  Iterate through all records in result set
//        while (resultSet.next()) {
//            String firstName = resultSet.getString("FIRST_NAME");
//            String lastName = resultSet.getString("LAST_NAME");
//            String email = resultSet.getString("EMAIL");
//            System.out.println(String.format("%s %s --> %s", firstName, lastName, email));
//        }
//
//        //  Clean up
//        connection.close();
        new parseData();
    }
}