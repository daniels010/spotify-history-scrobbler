package com.example.spotify.scrobbler.data.models;

public class TrackCount {
    private String trackName;
    private int count;

    public TrackCount(String trackName, int count) {
        this.trackName = trackName;
        this.count = count;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
