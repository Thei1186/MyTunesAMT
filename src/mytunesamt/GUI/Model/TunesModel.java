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

    public TunesModel() throws IOException, SQLException
    {
        songsOnPlaylist = FXCollections.observableArrayList();
        songList = FXCollections.observableArrayList();
        playlist = FXCollections.observableArrayList();
        logicLayer = new TunesManager();
        songList.addAll(logicLayer.getAllSongs());
//        playlist.addAll(logicLayer.getAllPlaylists());
    }

    public ObservableList<Song> getSongsOnPlaylist(Playlist playlist)
    {
        List<Song> tempSongs = logicLayer.getAllSongsOnPlaylist(playlist);
        songsOnPlaylist.clear();
        songsOnPlaylist.addAll(tempSongs);
        
        return songsOnPlaylist;
    }

    public ObservableList<Song> getSongs()
    {
        return songList;
    }

    public void addSong(Song song) throws SQLException
    {
        logicLayer.addSong(song);
        songList.add(song);
    }

    public void deleteSong(Song song)
    {
        logicLayer.deleteSong(song);
        this.songList.remove(song);
    }

    public void editSong(Song song)
    {
        logicLayer.editSong(song);
    }

    public ObservableList<Song> getAllSongs() throws SQLException
    {
        return songList;
    }

    public Song getSong(Song song)
    {
        return logicLayer.getSong(song);
    }

    public ObservableList<Playlist> getPlaylist()
    {
        return playlist;
    }

    public void newPlaylist(Playlist playlist) throws SQLException
    {
        logicLayer.newPlaylist(playlist);
    }

    public ObservableList<Playlist> getAllPlaylists() throws SQLException
    {
        playlist = FXCollections.observableArrayList(logicLayer.getAllPlaylists());
        return playlist;
    }

    public void deletePlaylist(Playlist playlist)
    {
        logicLayer.deletePlaylist(playlist);
        this.playlist.remove(playlist);
    }

    public void editPlaylist(Playlist playlist)
    {
        logicLayer.editPlaylist(playlist);
    }

    public ObservableList<Song> searchSongs(String input) throws SQLException
    {
        return FXCollections.observableArrayList(logicLayer.searchSongs(input));
    }

    public void addToPlaylist(Song selectedSong, Playlist selectedPlaylist)
    {
        logicLayer.addToPlaylist(selectedSong, selectedPlaylist);
    }
    
     public void deleteSongsOnPlaylist(Song song)
     {
        logicLayer.deleteSongsOnPlaylist(song);
        this.songsOnPlaylist.remove(song);
        
        
     }
     
     public void deleteAllPlaylistSongs(Playlist playlist)
     {
         logicLayer.deleteAllPlaylistSongs(playlist);
     }
    
    
}
