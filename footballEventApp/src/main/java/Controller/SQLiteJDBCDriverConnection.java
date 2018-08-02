package Controller;

import java.sql.*;

/**
 *
 * @author sqlitetutorial.net
 */
public class SQLiteJDBCDriverConnection {

    private Connection connection=null;

    public SQLiteJDBCDriverConnection(){
      openConnection();
    }

    public Connection openConnection(){

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/contact.sqlite");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        System.out.println("Opened database successfully");

        return connection;
    }

    public Connection getConnection(){
        return connection;
    }

}