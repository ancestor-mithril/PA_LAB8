package org.example.dao;

import org.example.Artist;

import java.sql.SQLException;
import java.util.List;

public interface IArtistController {
    /**
     * creaza un nou camp in tabelul artists care contine parametrii din @param
     *
     * @param name
     * @param country
     * @throws SQLException
     */
    void create(String name, String country) throws SQLException;

    /**
     * @param name
     * @return o lista cu toti artistii care au numele din @param
     * @throws SQLException
     */
    List<Artist> findByName(String name) throws SQLException;
}
