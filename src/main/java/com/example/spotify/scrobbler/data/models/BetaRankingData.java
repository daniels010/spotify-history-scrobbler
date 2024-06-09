package com.example.spotify.scrobbler.data.models;

import java.util.List;
import java.util.ArrayList;
public class BetaRankingData {
    private List<ArtistRanking> artistRankings;

    public BetaRankingData() {
        this.artistRankings = new ArrayList<>();
    }

    public void addArtistRanking(ArtistRanking ranking) {
        artistRankings.add(ranking);
    }

    public List<ArtistRanking> getArtistRankings() {
        return artistRankings;
    }
}
