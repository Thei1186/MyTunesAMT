/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunesamt.BLL;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.ObservableList;
import mytunesamt.BE.Playlist;
import mytunesamt.BE.Song;
import mytunesamt.DAL.AudioPlayer;
import mytunesamt.DAL.Database.PlaylistDbDao;
import mytunesamt.DAL.Database.SongDbDao;

/**
 *
 * @author kokus
 */
public class TunesManager implements MTLogicFacade
{

    PlaylistDbDao pLDbDao;
    SongDbDao sDbDao;
    AudioPlayer aPlayer;
    public TunesManager() throws IOException
    {
        this.sDbDao = new SongDbDao();
        this.pLDbDao = new PlaylistDbDao();
        this.aPlayer = new AudioPlayer();
    }

    @Override
    public List<Song> getAllSongs() throws SQLException
    {
        return sDbDao.getAllSongs();
    }

    @Override
    public Song getSong(Song song)
    {
        return sDbDao.getSong(song.getId());
    }

    @Override
    public void addSong(Song song) throws SQLException
    {
        sDbDao.addSong(song);
    }

    @Override
    public void editSong(Song song,String songName)
    {
        sDbDao.editSong(song, songName);
    }

    @Override
    public void deleteSong(Song song)
    {
        sDbDao.deleteSong(song);
    }

    @Override
    public void newPlaylist(Playlist playlist) throws SQLException
    {
        pLDbDao.newPlaylist(playlist); 
    }

    @Override
    public List<Playlist> getAllPlaylists() throws SQLException 
    {
        return pLDbDao.getAllPlaylists();
    }

    @Override
    public void deletePlaylist(Playlist playlist)
    {
        pLDbDao.deletePlaylist(playlist);
    }

    @Override
    public void editPlaylist(Playlist playlist, String playlistName) throws SQLException
    {
        pLDbDao.editPlaylist(playlist, playlistName);
    }

    @Override
    public List<Song> searchSongs(String input)
    {
        return sDbDao.searchSongs(input);
    }

    @Override
    public void addToPlaylist(Song selectedSong, Playlist selectedPlaylist)
    {
      pLDbDao.addToPlaylist(selectedSong, selectedPlaylist);
    }

    @Override
    public List<Song> getAllSongsOnPlaylist(Playlist playlist)
    {
      return pLDbDao.getAllSongsOnPlaylist(playlist);
    }
    
    @Override
    public void deleteSongsOnPlaylist(Song song)
    {
        pLDbDao.deleteSongsOnPlaylist(song);
    }

    @Override
    public void play(Song song)
    {
        aPlayer.play(song);
    }

    @Override
    public void stop()
    {
        aPlayer.stop();
    }

    @Override
    public void pause()
    {
        aPlayer.pause();
    }

    @Override
    public void setVolume(double volume)
    {
        aPlayer.setVolume(volume);
    }

    @Override
    public void playAll(List<Song> songs, int i) {
       aPlayer.playAll(songs, i);
    }
    
    
    
    
}
