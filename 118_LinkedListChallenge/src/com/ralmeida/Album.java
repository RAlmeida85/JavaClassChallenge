package com.ralmeida;

public class Album {

    private Song[] songList;

    public Album(Song song) {
        this.songList = new Song[1];
        songList[0] = song;
    }

    public Song[] getSongList() {
        return songList;
    }

    public int getSongNumber(String songName){
        // return song index in this album, if not found, will return -1
        for (int i=0; i < this.songList.length; i++){
            if (songList[i].getName().equals(songName)){
                return i;
            }
        }
        return -1;
    }

    public void addSong(Song song){

        Song[] newSongList = new Song[this.songList.length];

        for(int i=0; i<songList.length; i++){
            newSongList[i] = songList[i];
        }

        newSongList[newSongList.length] = song;
        this.songList = newSongList;
    }
}
