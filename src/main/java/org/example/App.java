package org.example;

import org.example.dao.AlbumController;
import org.example.dao.ArtistController;
import org.example.db.Database;
import org.example.db.DatabaseOperations;

import java.sql.SQLException;
import java.util.List;


public class App {
    /**
     * intrucat pe versiunile mai vechi de oracle nu exista autoincrement
     * interogarile de mai jos inlocuiesc interogarile din cerinta
     * incadrandu-se in standardul clasic sql
     * in standardul oracle nu exista on delete restrict, face restrict implicit, daca nu exista on delete cascade
     * pentru auto-increment se folosesc secvente
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Hello World!");
        try {
            DatabaseOperations op = new DatabaseOperations();
//            op.executeUpdate("create table artists(" +
//                    "id integer primary key," +
//                    "name varchar(100) not null," +
//                    "country varchar(100)" +
//                    ")");
////
////
//            op.executeUpdate("create sequence FOO_seq");
////
////
//            op.executeUpdate("create or replace trigger FOO_trg " +
//                    "before insert on artists " +
//                    "for each row " +
//                    "begin " +
//                    "select FOO_seq.nextval into :new.id from dual; " +
//                    "end; ");
//
//
//            op.executeUpdate("create table albums(" +
//                    "id integer primary key," +
//                    "name varchar(100) not null," +
//                    "artist_id integer not null, " +
//                    "release_year integer, " +
//                    "foreign key (artist_id) references artists (id)" +
//                    ")");
//
//
//            op.executeUpdate("create sequence FOO_seq2");
//
//
//            op.executeUpdate("create or replace trigger FOO_trg2 " +
//                    "before insert on albums " +
//                    "for each row " +
//                    "begin " +
//                    "select FOO_seq2.nextval into :new.id from dual; " +
//                    "end; ");

//
            AlbumController albumController = new AlbumController(Database.getInstance().getConnection());
            ArtistController artistController = new ArtistController(Database.getInstance().getConnection());
//
//
//            artistController.create("Artist1", "Country1");
//            artistController.create("Artist2", "Country1");
//            artistController.create("Artist3", "Country2");
//            artistController.create("Artist4", "Country3");
//            albumController.create("Album1", 1, 2010);
//            albumController.create("Album2", 1, 2011);
//            albumController.create("Album3", 1, 2012);
//            albumController.create("Album4", 2, 2013);
//            albumController.create("Album5", 3, 2014);
//            albumController.create("Album6", 4, 2015);
//            albumController.create("Album7", 4, 2016);
//
//
            List<Artist> artists = artistController.findByName("Artist1");
            artists.stream().forEach(System.out::println);
//
//
            List<Album> albums = albumController.findByArtist(1);
            albums.stream().forEach(System.out::println);


            Database.getInstance().getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
