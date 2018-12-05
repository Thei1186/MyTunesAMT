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

    public TunesManager() throws IOException
    {
        this.sDbDao = new SongDbDao();
        this.pLDbDao = new PlaylistDbDao();
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
    public void editSong(Song song)
    {
        sDbDao.editSong(song);
    }

    @Override
    public void deleteSong(Song song)
    {
        sDbDao.deleteSong(song);
    }

    @Override
    public void newPlaylist(String name, int id) throws IOException, SQLException
    {
        pLDbDao.newPlaylist(name, id); 
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
    public void editPlaylist(Playlist playlist)
    {
        pLDbDao.editPlaylist(playlist);
    }
}
