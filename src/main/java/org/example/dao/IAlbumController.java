package org.example.dao;

import org.example.Album;

import java.sql.SQLException;
import java.util.List;

public interface IAlbumController {
    /**
     * creaza in tabela sql un nou camp cu valorile @param
     *
     * @param name
     * @param artistId
     * @param releaseYear
     * @throws SQLException
     */
    void create(String name, int artistId, int releaseYear) throws SQLException;

    /**
     * @param artistId artistul care a scris albume
     * @return returneaza o lista de albume care au fost scrise de artistul din @param
     * @throws SQLException
     */
    List<Album> findByArtist(int artistId) throws SQLException;
}
