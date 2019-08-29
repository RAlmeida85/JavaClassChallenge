package com.ralmeida;

import java.util.*;

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
    private static LinkedList<Song> playlist = new LinkedList<>();

    public static void main(String[] args) {

        ArrayList<Album> albumsList = new ArrayList<>();


        Album octavarium = new Album("Octavarium");
        octavarium.addSong("Octavarium", 1220);
        octavarium.addSong("Panic Attack", 450);
        octavarium.addSong("These Walls", 240);
        octavarium.addSong("Sacrificied Sons", 580);

        Album images = new Album("Images and Words");
        images.addSong("Another Day", 280);
        images.addSong("Pull Me Under", 321);
        images.addSong("Take the time", 290);
        images.addSong("Surrounded", 430);

        Album sorceres = new Album("Sorceress");
        sorceres.addSong("Persephone", 220);
        sorceres.addSong("Sorceress", 320);
        sorceres.addSong("Strange Brew", 458);

        albumsList.add(octavarium);
        albumsList.add(images);
        albumsList.add(sorceres);

        boolean quit = false;
        boolean goingForward = true;
        boolean isPlaying = false;
        int option;

        ListIterator<Song> playlistIterator = playlist.listIterator();

        //check if list is empty and print which song is playing before menu
        if(playlist.isEmpty()){
            System.out.println("Playlist is empty, add songs before start playing");
        } else {
            System.out.println("Now playing --> " + playlistIterator.next().toString());
        }

        printMenu();

        while(!quit){
            System.out.println("Type an option (0 to show menu)");
            option = scanner.nextInt();
            scanner.nextLine();

            switch(option){
                case 1:
                    //add song to the list
//                    if(isPlaying){
//                        System.out.println("Cannot add songs while playing");
//                    } else {
//                        addSongToPlaylist(albumsList, playlist);
//                    }
                    int index = (playlistIterator.nextIndex());
                    addSongToPlaylist(albumsList);
                    playlistIterator = playlist.listIterator(index);
                    break;

                case 2:
                    //change state between Play/Stop
                    if(isPlaying){
                        System.out.println("Playlist Stopped");
                        isPlaying = false;
                    } else {
                        if(playlist.isEmpty()){
                            System.out.println("Playlist is empty, add songs before start playing");
                        } else {
                            System.out.println("Playlist Playing");
                            playlistIterator = playlist.listIterator();
                            isPlaying = true;
                            System.out.println("Now playing: " + playlistIterator.next().toString());
                        }
                    }
                    break;

                case 3:
                    // skip forward
                    // adjust iterator direction case it is not going forward
                    if(!goingForward){
                        if(playlistIterator.hasNext()){
                            playlistIterator.next();
                        }
                        goingForward = true;
                    }
                    if(playlistIterator.hasNext()){
                        System.out.println("Now playing: " + playlistIterator.next().toString());
                    } else {
                        System.out.println("Playlist has finished");
                        goingForward = false;
                    }
                    break;

                case 4:
                    // skip backward
                    // adjust iterator direction case it is not going backwards
                    if(goingForward){
                        if(playlistIterator.hasPrevious()){
                            playlistIterator.previous();
                        }
                        goingForward = false;
                    }
                    if(playlistIterator.hasPrevious()){
                        System.out.println("Now playing: " + playlistIterator.previous().toString());
                    } else {
                        System.out.println("Start of the Playlist");
                        goingForward = true;
                    }
                    break;

                case 5:
                    // replay current song
                    if(isPlaying){
                        replaySong(goingForward, playlistIterator);
                    } else {
                        System.out.println("Playlist stopped");
                    }
                    break;

                case 6:
                    // list playlist songs
                    if(isPlaying){
                        replaySong(goingForward, playlistIterator);
                    } else {
                        System.out.println("Playlist stopped");
                    }
                    listPlaylist();
                    break;

                case 7:
                    quit = true;
                    break;

                case 0:
                    // list options/menu
                    printMenu();
                    break;

                default:
                    System.out.println("Invalid option");
                    break;
            }
        }

    }

    private static void replaySong(boolean goingForward, ListIterator<Song> playlistIterator){
        if(!goingForward){
            if(playlistIterator.hasNext()){
                System.out.println("Now playing: " + playlistIterator.next().toString());
                playlistIterator.previous();
            } else {
                System.out.println("Now playing: " + playlistIterator.previous().toString());
                playlistIterator.next();
            }
        } else {
            if(playlistIterator.hasPrevious()){
                System.out.println("Now playing: " + playlistIterator.previous().toString());
                playlistIterator.next();
            } else {
                System.out.println("Now playing: " + playlistIterator.next().toString());
                playlistIterator.previous();
            }
        }
    }

    public static void addSongToPlaylist(ArrayList<Album> albumsList){
        System.out.println("Provide song name: ");
        String songName = scanner.nextLine();

        for (int i=0; i < albumsList.size(); i++){

            for (int j=0; j < albumsList.get(i).getSongs().size(); j++){
                if (albumsList.get(i).getSongs().get(j).getName().equals(songName)){
                    playlist.add(albumsList.get(i).getSongs().get(j));
                    System.out.println("Added Song " + songName + " from album " + albumsList.get(i).getName() + " to playlist");

                    return;
                }
            }
        }
        System.out.println("Could not add song " + songName + " (it is not available in any album!)");
    }

    public static void listPlaylist(){
        Iterator<Song> i = playlist.iterator();
        System.out.println("======================");
        if(playlist.isEmpty()) {
            System.out.println("Playlist is empty, add songs before start playing");
        } else {
            while (i.hasNext()) {
                System.out.println(i.next().toString());
            }
        }

        System.out.println("======================");

    }

    public static void printMenu(){
        // Quit,Skip forward to the next song, skip backwards to a previous song.  Replay the current song.
        // List the songs in the playlist
        System.out.println( "Menu\nPress:\n" +
                            "\t0 - Show menu\n"+
                            "\t1 - Add song to playlist\n"+
                            "\t2 - Play/Stop\n" +
                            "\t3 - Skip Forward\n"+
                            "\t4 - Skip Backwards\n"+
                            "\t5 - Replay current song\n"+
                            "\t6 - List Playlist songs\n"+
                            "\t7 - Quit");
    }
}
