/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunesamt.GUI.Model;

import java.io.IOException;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mytunesamt.BE.Song;
import mytunesamt.BLL.MTLogicFacade;
import mytunesamt.BLL.TunesManager;

/**
 *
 * @author kokus
 */
public class TunesModel
{

    private ObservableList<Song> songList;
    private final MTLogicFacade logicLayer;

    public TunesModel() throws IOException, SQLException
    {
        songList = FXCollections.observableArrayList();
        logicLayer = new TunesManager();
        songList.addAll(logicLayer.getAllSongs());
    }

    public ObservableList<Song> getSongs()
    {
        return songList;
    }

    public void createSong(Song song) throws SQLException
    {
        logicLayer.addSong(song);
    }

    public void deleteSong(Song song)
    {
        logicLayer.deleteSong(song);
    }

    public void editSong(Song song)
    {
        logicLayer.editSong(song);
    }

    public ObservableList<Song> getAllSongs() throws SQLException
    {
        songList = FXCollections.observableList(logicLayer.getAllSongs());
        return songList;
    }
    
    public Song getSong(Song song)
    {
        return logicLayer.getSong(song);
    }
    
}
