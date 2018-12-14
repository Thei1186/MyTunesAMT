/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunesamt.BLL;

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

    /*
    adds a song to the list of songs
    @param song
     */
    void addSong(Song song) throws SQLException;

    void deleteSong(Song song);

    void editSong(Song song, String songName);

    List<Song> getAllSongs() throws SQLException;

    Song getSong(Song song);

    void newPlaylist(Playlist playlist) throws SQLException;

    List<Playlist> getAllPlaylists() throws SQLException;

    void deletePlaylist(Playlist playlist);

    void editPlaylist(Playlist playlist, String playlistName) throws SQLException;

    List<Song> searchSongs(String input);

    void addToPlaylist(Song selectedSong, Playlist selectedPlaylist);

    List<Song> getAllSongsOnPlaylist(Playlist playlist);

    void deleteSongsOnPlaylist(Song song);

    void stop();

    void pause();

    void setVolume(double volume);
    
    void playAll(List<Song> songs, int i);

}
