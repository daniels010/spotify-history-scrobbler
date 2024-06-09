package com.example.spotify.scrobbler.data.models;

import java.util.List;
import java.util.ArrayList;

public class AlbumRanking {
    private String albumName;
    private String artistName; // Inherited from ArtistRanking
    private List<TrackCount> tracks;

    public AlbumRanking(String albumName, String artistName) {
        this.albumName = albumName;
        this.artistName = artistName;
        this.tracks = new ArrayList<>();
    }

    public String getAlbumName() {
        return albumName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void addTrackCount(String trackName, int count) {
        tracks.add(new TrackCount(trackName, count));
    }

    public List<TrackCount> getTracks() {
        return tracks;
    }
}
