/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunesamt.BLL;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import mytunesamt.BE.Playlist;
import mytunesamt.BE.Song;

/**
 *
 * @author kokus
 */
public interface MTLogicFacade
{

    void addSong(Song song) throws SQLException;

    void deleteSong(Song song);

    void editSong(Song song);

    List<Song> getAllSongs() throws SQLException;

    Song getSong(Song song);
    
    void newPlaylist (Playlist playlist) throws SQLException;
    
    List<Playlist> getAllPlaylists() throws SQLException;
    
    void deletePlaylist(Playlist playlist);
    
    void editPlaylist(Playlist playlist);
    
    List<Song> searchSongs (String input);
    
}
