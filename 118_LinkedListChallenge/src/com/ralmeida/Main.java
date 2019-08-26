package com.ralmeida;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

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


    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<Album> albumsList = new ArrayList<>();
        LinkedList<Song> playlist = new LinkedList<>();

        Album octavarium = new Album("Octavarium", new Song("Octavarium", 1220));
        octavarium.addSong(new Song("Panic Attack", 450));
        octavarium.addSong(new Song("These Walls", 240));
        octavarium.addSong(new Song("Sacrificied Sons", 580));

        Album images = new Album("Images and Words", new Song("Another Day", 280));
        images.addSong(new Song("Pull Me Under", 321));
        images.addSong(new Song("Take the time", 290));
        images.addSong(new Song("Surrounded", 430));

        Album sorceres = new Album("Sorceress", new Song("Persephone", 220));
        sorceres.addSong(new Song("Sorceress", 320));
        sorceres.addSong(new Song("Strange Brew", 458));

        albumsList.add(octavarium);
        albumsList.add(images);
        albumsList.add(sorceres);

        boolean quit = false;
        int option;

        printMenu();

        while(!quit){
            option = scanner.nextInt();
            scanner.nextLine();

            switch(option){
                case 0:
                    quit = true;
                    break;

                case 1:
                    //add song to the list
                    addSongToPlaylist(albumsList, playlist);

                case 2:
                    // skip forward

                case 3:
                    // skip backward

                case 4:
                    // replay current song

                case 5:
                    // list playlist songs
                    listPlaylist(playlist);
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }

    }

    public static void addSongToPlaylist(ArrayList<Album> albumsList, LinkedList<Song> playlist){
        System.out.println("Provide song name: ");
        String songName = scanner.nextLine();

        for (int i=0; i < albumsList.size(); i++){

            Song[] songs = albumsList.get(i).getSongList();

            for (int j=0; j < songs.length; j++){
                if (songs[j].getName().equals(songName)){
                    playlist.add(songs[j]);
                    System.out.println("Song " + songName + " from album " + albumsList.get(i).getName());
                    return;
                }
            }
        }

        System.out.println("Could not add song " + songName + " (it is not available in any album!)");
    }

    public static void listPlaylist(LinkedList<Song> playlist){
        Iterator<Song> i = playlist.iterator();

        while(i.hasNext()){
            System.out.println(i.next().getName());
        }

        System.out.println("======================");

    }

    public static void printMenu(){
        // Quit,Skip forward to the next song, skip backwards to a previous song.  Replay the current song.
        // List the songs in the playlist
        System.out.println( "\nMenu\nPress:\n" +
                            "0 - Quit\n"+
                            "1 - Add song to playlist\n"+
                            "2 - Skip Forward\n"+
                            "3 - Skip Backwards\n"+
                            "4 - Replay current song\n"+
                            "5 - List Playlist songs");
    }
}
