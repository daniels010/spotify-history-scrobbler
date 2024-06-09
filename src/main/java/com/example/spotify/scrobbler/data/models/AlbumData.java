package com.example.spotify.scrobbler.data.models;

import com.example.spotify.scrobbler.data.Triplet;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AlbumData {
    private List<Triplet<String, String, Integer>> albumRanking;
    public AlbumData() {
        this.albumRanking = new ArrayList<>();
    }
    public void incrementAlbumCount(String albumName, String artistName) {
        incrementCountTriplet(albumRanking, albumName, artistName);
    }

    public List<Triplet<String, String, Integer>> getAlbumRanking() {
        return albumRanking;
    }

    private void incrementCountTriplet(List<Triplet<String, String, Integer>> ranking, String itemName, String itemName1) {
        boolean found = false;
        for (Triplet<String, String, Integer> triplet : ranking) {
            if (triplet.getName().equals(itemName) && triplet.getName1().equals(itemName1)) {
                triplet.setReproductions(triplet.getReproductions() + 1);
                found = true;
                break;
            }
        }
        if (!found) {
            ranking.add(new Triplet<>(itemName, itemName1, 1));
        }
        ranking.sort(Comparator.comparing(Triplet<String, String, Integer>::getReproductions).reversed());
    }
}
