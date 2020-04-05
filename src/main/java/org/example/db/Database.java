package org.example.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * https://gist.github.com/jasoet/3843797
 * singleton care se conecteaza la bd doar atunci cand este instantiat pentru prima data sau cand conexiunea s-a oprit
 *
 */
public class Database {
    private static Database instance;
    private Connection con;
    private String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private String user = "dba";
    private String password = "sql";

    private Database() throws SQLException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return con;
    }

    public static Database getInstance() throws SQLException {
        if (instance == null)
            instance = new Database();
        else if (instance.getConnection().isClosed())
            instance = new Database();
        return instance;
    }
}
