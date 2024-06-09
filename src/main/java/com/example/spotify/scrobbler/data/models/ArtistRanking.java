package com.example.spotify.scrobbler.data.models;

import java.util.List;
import java.util.ArrayList;
import com.example.spotify.scrobbler.data.models.AlbumRanking;

public class ArtistRanking {
    private String artistName;
    private List<AlbumRanking> albums;

    public ArtistRanking(String artistName) {
        this.artistName = artistName;
        this.albums = new ArrayList<>();
    }

    public String getArtistName() {
        return artistName;
    }

    public void addAlbum(AlbumRanking album) {
        albums.add(album);
    }

    public List<AlbumRanking> getAlbums() {
        return albums;
    }
}
