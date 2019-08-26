package com.ralmeida;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    // Create a program that implements a playlist for songs
    // Create a Song class having Title and Duration for a song.
    // The program will have an Album class containing a list of songs.
    // The albums will be stored in an ArrayList
    // Songs from different albums can be added to the playlist and will appear in the list in the order
    // they are added.
    // Once the songs have been added to the playlist, create a menu of options to:-
    // Quit,Skip forward to the next song, skip backwards to a previous song.  Replay the current song.
    // List the songs in the playlist
    // A song must exist in an album before it can be added to the playlist (so you can only play songs that
    // you own).
    // Hint:  To replay a song, consider what happened when we went back and forth from a city before we
    // started tracking the direction we were going.
    // As an optional extra, provide an option to remove the current song from the playlist
    // (hint: listiterator.remove()


    public static void main(String[] args) {

        ArrayList<Album> albumsList = new ArrayList<>();
        LinkedList<Song> playlist = new LinkedList<>();

        Album octavarium = new Album(new Song("Octavarium", 1220));
        octavarium.addSong(new Song("Panic Attack", 450));
        octavarium.addSong(new Song("These Walls", 240));
        octavarium.addSong(new Song("Sacrificied Sons", 580));

        Album images = new Album(new Song("Another Day", 280));
        images.addSong(new Song("Pull Me Under", 321));
        images.addSong(new Song("Take the time", 290));
        images.addSong(new Song("Surrounded", 430));

        Album sorceres = new Album(new Song("Persephone", 220));
        sorceres.addSong(new Song("Sorceress", 320));
        sorceres.addSong(new Song("Strange Brew", 458));

        albumsList.add(octavarium);
        albumsList.add(images);
        albumsList.add(sorceres);


    }


}
