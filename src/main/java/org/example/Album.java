package org.example;

public class Album {
    private int id;
    private String name;
    private int artistId;
    private int releaseYear;

    /**
     * se instantiaza un obiect dupa coloanele din tabel
     *
     * @param id
     * @param name
     * @param artist_id
     * @param release_year
     */
    public Album(int id, String name, int artist_id, int release_year) {
        this.id = id;
        this.name = name;
        this.artistId = artist_id;
        this.releaseYear = release_year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArtist_id() {
        return artistId;
    }

    public void setArtist_id(int artist_id) {
        this.artistId = artist_id;
    }

    public int getRelease_year() {
        return releaseYear;
    }

    public void setRelease_year(int release_year) {
        this.releaseYear = release_year;
    }


    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", artistId=" + artistId +
                ", releaseYear=" + releaseYear +
                '}';
    }
}
