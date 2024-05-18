package com.example.spotify.scrobbler.controllers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RankingData {
    private List<Pair<String, Integer>> artistRanking;
    private List<Pair<String, Integer>> trackRanking;
    private List<Pair<String, Integer>> albumRanking;

    public RankingData() {
        this.artistRanking = new ArrayList<>();
        this.trackRanking = new ArrayList<>();
        this.albumRanking = new ArrayList<>();
    }

    public void incrementArtistCount(String artistName) {
        incrementCount(artistRanking, artistName);
    }

    public void incrementTrackCount(String trackName) {
        incrementCount(trackRanking, trackName);
    }

    public void incrementAlbumCount(String albumName) {
        incrementCount(albumRanking, albumName);
    }

    public List<Pair<String, Integer>> getArtistRanking() {
        return artistRanking;
    }

    public List<Pair<String, Integer>> getTrackRanking() {
        return trackRanking;
    }

    public List<Pair<String, Integer>> getAlbumRanking() {
        return albumRanking;
    }

    private void incrementCount(List<Pair<String, Integer>> ranking, String itemName) {
        boolean found = false;
        for (Pair<String, Integer> pair : ranking) {
            if (pair.getName().equals(itemName)) {
                pair.setReproductions(pair.getReproductions() + 1);
                found = true;
                break;
            }
        }
        if (!found) {
            ranking.add(new Pair<>(itemName, 1));
        }
        ranking.sort(Comparator.comparing(Pair<String, Integer>::getReproductions).reversed());
    }
}
