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
  private int id;
  private String name;

    public Playlist(int id, String name)
    {
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

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getId()
    {
        return id;
    }
    
    @Override
    public String toString()
    {
        return "" + name;
    }
  
}
