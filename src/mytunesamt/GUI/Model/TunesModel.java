/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunesamt.GUI.Model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mytunesamt.BE.Playlist;
import mytunesamt.BE.Song;
import mytunesamt.BLL.MTLogicFacade;
import mytunesamt.BLL.TunesManager;
import mytunesamt.DAL.AudioPlayer;

/**
 *
 * @author kokus
 */
public class TunesModel
{

    private ObservableList<Playlist> playlist;
    private ObservableList<Song> songList;
    private ObservableList<Song> songsOnPlaylist;
    private final MTLogicFacade logicLayer;
    private AudioPlayer aPlayer;

    public TunesModel() throws IOException, SQLException
    {
        songsOnPlaylist = FXCollections.observableArrayList();
        songList = FXCollections.observableArrayList();
        playlist = FXCollections.observableArrayList();
        logicLayer = new TunesManager();
        songList.addAll(logicLayer.getAllSongs());
        aPlayer = new AudioPlayer();
//        playlist.addAll(logicLayer.getAllPlaylists());
    }

    /*
    Gets all the songs from the logic layer and then shows them on the listview
     */
    public ObservableList<Song> getSongsOnPlaylist(Playlist playlist)
    {
        List<Song> tempSongs = logicLayer.getAllSongsOnPlaylist(playlist);
        songsOnPlaylist.clear();
        songsOnPlaylist.addAll(tempSongs);
        return songsOnPlaylist;
    }

    /*
    Returns the songs on the observableList
     */
    public ObservableList<Song> getSongs()
    {
        return songList;
    }

    /*
    Adds a song through the logicLayer to the observableList of songs
     */
    public void addSong(Song song) throws SQLException
    {
        logicLayer.addSong(song);
        songList.add(song);
    }

    /*
    Removes a song from the observableList 
     */
    public void deleteSong(Song song)
    {
        logicLayer.deleteSong(song);
        this.songList.remove(song);
    }

    /*
    edits the title of a song
     */
    public void editSong(Song song, String songName)
    {
        logicLayer.editSong(song, songName);
    }

    /*
    returns the observable song list
     */
    public ObservableList<Song> getAllSongs() throws SQLException
    {
        List<Song> tempSongs = logicLayer.getAllSongs();
        songList.clear();
        songList.addAll(tempSongs);
        return songList;
    }

    /*
    gets a specific song from the list
     */
    public Song getSong(Song song)
    {
        return logicLayer.getSong(song);
    }

    /*
    gets a playlist from the list of playlists
     */
    public ObservableList<Playlist> getPlaylist()
    {
        return playlist;
    }

    /*
    creates a new playlist
     */
    public void newPlaylist(Playlist playlist) throws SQLException
    {
        logicLayer.newPlaylist(playlist);
        this.playlist.add(playlist);
    }

    /*
    converts the List of arraylists into an observableArrayList and then returns it
     */
    public ObservableList<Playlist> getAllPlaylists() throws SQLException
    {
        playlist = FXCollections.observableArrayList(logicLayer.getAllPlaylists());
        return playlist;
    }

    /*
    deletes a playlist
     */
    public void deletePlaylist(Playlist playlist)
    {
        logicLayer.deletePlaylist(playlist);
        this.playlist.remove(playlist);
    }

    /*
    changes the name of a playlist
     */
    public void editPlaylist(Playlist playlist, String playlistName) throws SQLException
    {
        List <Playlist> tempPList = logicLayer.getAllPlaylists();
        logicLayer.editPlaylist(playlist, playlistName);
        this.playlist.clear();
        this.playlist.addAll(tempPList);
        
    }

    /*
    searches for a song based on title and artist
     */
    public ObservableList<Song> searchSongs(String input) throws SQLException
    {
        return FXCollections.observableArrayList(logicLayer.searchSongs(input));
    }

    public void addToPlaylist(Song selectedSong, Playlist selectedPlaylist)
    {
        logicLayer.addToPlaylist(selectedSong, selectedPlaylist);
        this.songsOnPlaylist.add(selectedSong);
    }

    public void deleteSongsOnPlaylist(Song song)
    {
        logicLayer.deleteSongsOnPlaylist(song);
        this.songsOnPlaylist.remove(song);
    }

    public void play(Song song)
    {
        logicLayer.play(song);
    }

    public void stop()
    {
        logicLayer.stop();
    }

    public void pause()
    {
        logicLayer.pause();
    }

    public void previous()
    {
//        logicLayer.previous();
    }

    public void next()
    {
//        logicLayer.next();
    }

    public void setVolume(double volume)
    {
        logicLayer.setVolume(volume);
    }

}
