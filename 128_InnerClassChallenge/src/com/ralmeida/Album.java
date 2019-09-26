package com.ralmeida;

import java.util.ArrayList;

public class Album {

    // ###########################
    // Modify the playlist challenge so that the Album class uses an inner class.
    // Instead of using an ArrayList to hold its tracks, it will use an inner class called SongList
    // The inner SongList class will use an ArrayList and will provide a method to add a song.
    // It will also provide findSong() methods which will be used by the containing Album class
    // to add songs to the playlist.
    // Neither the Song class or the Main class should be changed.

    private String name;
    private SongList songs;

    public Album(String name) {
        this.name = name;
        this.songs = new SongList();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Song> getSongs() {
        return songs.getSongs();
    }

    public void addSong(String name, int duration){
        this.songs.addSong(new Song(name, duration));
    }


    private class SongList{
        private ArrayList<Song> songs;

        public SongList() {
            this.songs = new ArrayList<>();
        }

        public void addSong(Song song){
            this.songs.add(song);
        }

        public ArrayList<Song> getSongs() {
            return songs;
        }
    }
}
