package com.example.spotify.scrobbler.data;

public class Triplet<N, N1, R> {
    private N name;
    private N1 name1;
    private R reproductions;

    public Triplet(N name, N1 name1, R reproductions) {
        this.name = name;
        this.name1 = name1;
        this.reproductions = reproductions;
    }

    public N getName() {
        return name;
    }

    public void setName(N name) {this.name = name;}

    public N1 getName1(){return name1;}

    public void setName1(N1 name1){this.name1 = name1;}

    public R getReproductions() {
        return reproductions;
    }

    public void setReproductions(R reproductions) {
        this.reproductions = reproductions;
    }
}
