package com.ralmeida;

import java.util.ArrayList;

public class Album {

    private String name;
    private ArrayList<Song> songs;

    public Album(String name) {
        this.name = name;
        this.songs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void addSong(String name, int duration){
        this.songs.add(new Song(name, duration));
    }
}
