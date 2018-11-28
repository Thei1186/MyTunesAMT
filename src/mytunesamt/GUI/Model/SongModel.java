/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunesamt.GUI.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mytunesamt.BE.Song;

/**
 *
 * @author kokus
 */
public class SongModel
{    
private ObservableList<Song> songList;

    public SongModel()
    {
        songList = FXCollections.observableArrayList();
        
    }

   public ObservableList<Song> getSongs()
   {
       return songList;
   }

   public void deleteSong(Song song)
   {
       songList.remove(song);
   }
}
