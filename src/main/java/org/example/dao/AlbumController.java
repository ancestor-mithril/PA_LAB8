package org.example.dao;

import org.example.Album;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlbumController implements IAlbumController {
    private Connection connection;

    /**
     * se conecteaza la bd
     *
     * @param connection
     */
    public AlbumController(Connection connection) {
        this.connection = connection;
    }

    /**
     * creaza in tabela sql un nou camp cu valorile @param
     *
     * @param name
     * @param artistId
     * @param releaseYear
     * @throws SQLException
     */
    @Override
    public void create(String name, int artistId, int releaseYear) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement
                ("insert into albums (name, artist_id, release_year) values (?, ?, ?)");
        stmt.setString(1, name);
        stmt.setInt(2, artistId);
        stmt.setInt(3, releaseYear);
        stmt.executeUpdate();
    }

    /**
     * @param artistId artistul care a scris albume
     * @return returneaza o lista de albume care au fost scrise de artistul din @param
     * @throws SQLException
     */
    @Override
    public List<Album> findByArtist(int artistId) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("select * from albums where artist_id=?");
        stmt.setInt(1, artistId);
        ResultSet rs = stmt.executeQuery();
        List<Album> albums = new ArrayList<>();
        while (rs.next()) {
            albums.add(new Album(rs.getInt("id"), rs.getString("name"),
                    rs.getInt("artist_id"), rs.getInt("release_year")));
        }
        return albums;
    }
}
