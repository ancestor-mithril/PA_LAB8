package org.example;

import com.github.javafaker.Faker;
import org.example.dao.AlbumController;
import org.example.dao.ArtistController;
import org.example.db.Database;
import org.example.db.DatabaseOperations;

import java.sql.SQLException;
import java.util.ArrayList;
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
/*            op.executeUpdate("create table artists(" +
                    "id integer primary key," +
                    "name varchar(100) not null," +
                    "country varchar(100)" +
                    ")");
//
//
            op.executeUpdate("create sequence FOO_seq");
//
//
            op.executeUpdate("create or replace trigger FOO_trg " +
                    "before insert on artists " +
                    "for each row " +
                    "begin " +
                    "select FOO_seq.nextval into :new.id from dual; " +
                    "end; ");


            op.executeUpdate("create table albums(" +
                    "id integer primary key," +
                    "name varchar(100) not null," +
                    "artist_id integer not null, " +
                    "release_year integer, " +
                    "foreign key (artist_id) references artists (id)" +
                    ")");


            op.executeUpdate("create sequence FOO_seq2");


            op.executeUpdate("create or replace trigger FOO_trg2 " +
                    "before insert on albums " +
                    "for each row " +
                    "begin " +
                    "select FOO_seq2.nextval into :new.id from dual; " +
                    "end; ");*/

//
            AlbumController albumController = new AlbumController(Database.getInstance().getConnection());
            ArtistController artistController = new ArtistController(Database.getInstance().getConnection());
//
//
            List<Artist> insertedArtists=new ArrayList<>();
            for (int i=0; i<4; i++){
                insertedArtists.add(new Artist(i, new Faker().name().fullName(), new Faker().nation().nationality()));
            }
            List<Album> insertedAlbums=new ArrayList<>();
            for (int i=0; i<6; i++){
                insertedAlbums.add(new Album(i, new Faker().funnyName().name(), i%4, 2010+i));
            }
            artistController.create(new Faker().name().fullName(), new Faker().nation().nationality());
            artistController.create(new Faker().name().fullName(), new Faker().nation().nationality());
            artistController.create(new Faker().name().fullName(), new Faker().nation().nationality());
            artistController.create(new Faker().name().fullName(), new Faker().nation().nationality());
            albumController.create(new Faker().funnyName().name(), 1, 2010);
            albumController.create(new Faker().funnyName().name(), 1, 2011);
            albumController.create(new Faker().funnyName().name(), 1, 2012);
            albumController.create(new Faker().funnyName().name(), 2, 2013);
            albumController.create(new Faker().funnyName().name(), 3, 2014);
            albumController.create(new Faker().funnyName().name(), 4, 2015);
            albumController.create(new Faker().funnyName().name(), 4, 2016);
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
