package org.example.dao;

import org.example.Album;
import org.example.Artist;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArtistController implements IArtistController {
    private Connection connection;

    /**
     * se conecteaza la bd
     *
     * @param connection
     */
    public ArtistController(Connection connection) {
        this.connection = connection;
    }

    /**
     * creaza un nou camp in tabelul artists care contine parametrii din @param
     *
     * @param name
     * @param country
     * @throws SQLException
     */
    @Override
    public void create(String name, String country) throws SQLException {
        String sql = "insert into artists (name, country) values (?, ?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, name);
        stmt.setString(2, country);
        stmt.executeUpdate();
    }

    /**
     * @param name
     * @return o lista cu toti artistii care au numele din @param
     * @throws SQLException
     */
    @Override
    public List<Artist> findByName(String name) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("select * from artists where name=?");
        stmt.setString(1, name);
        ResultSet rs = stmt.executeQuery();
        List<Artist> artists = new ArrayList<>();
        while (rs.next()) {
            artists.add(new Artist(rs.getInt("id"), rs.getString("name"),
                    rs.getString("country")));
        }
        return artists;
    }
}
