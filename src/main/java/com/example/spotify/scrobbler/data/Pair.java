package com.example.spotify.scrobbler.data;

public class Pair<N, R> {
    private N name;
    private R reproductions;

    public Pair(N name, R reproductions) {
        this.name = name;
        this.reproductions = reproductions;
    }

    public N getName() {
        return name;
    }

    public void setName(N name) {
        this.name = name;
    }

    public R getReproductions() {
        return reproductions;
    }

    public void setReproductions(R reproductions) {
        this.reproductions = reproductions;
    }
}
