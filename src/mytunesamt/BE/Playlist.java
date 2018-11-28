/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunesamt.BE;

import java.util.List;

/**
 *
 * @author kokus
 */
public class Playlist
{
  private List<Song> songList;   
  private int numberOfSongs;
  private final int id;
  private String name;

    public Playlist(List<Song> songList, int numberOfSongs, int id, String name)
    {
        this.numberOfSongs = numberOfSongs;
        this.id = id;
        this.name = name;
    }

    public List<Song> getSongList()
    {
        return songList;
    }

    public void setSongList(List<Song> songList)
    {
        this.songList = songList;
    }

    public int getNumberOfSongs()
    {
        return numberOfSongs;
    }

    public void setNumberOfSongs(int numberOfSongs)
    {
        this.numberOfSongs = numberOfSongs;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
  
}
