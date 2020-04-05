package org.example.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseOperations {
    Connection connection;

    /**
     * deschide o conexiune la baza de date
     *
     * @throws SQLException
     */
    public DatabaseOperations() throws SQLException {
        Database db = Database.getInstance();
        connection = db.getConnection();
    }

    /**
     * folosita pentru a crea tabelele, secventele si triggerurile de care este nevoie la inceput
     *
     * @param string
     * @throws SQLException
     */
    public void executeUpdate(String string) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute(string);
    }
}
