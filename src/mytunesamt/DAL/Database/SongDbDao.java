/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunesamt.DAL.Database;

import java.io.IOException;
import mytunesamt.BE.Song;

/**
 *
 * @author kokus
 */
public class SongDbDao
{

    DbConnectionProvider ds;

    public SongDbDao() throws IOException
    {
        DbConnectionProvider ds = new DbConnectionProvider();

    }

    public void addSong(Song song)
    {
        String artist = song.getArtist();
        String title = song.getTitle();
        String location = song.getLocation();
    }
}
